package xyz.tmlh.security.browser;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xyz.tmlh.security.browser.suport.ResultBean;
import xyz.tmlh.security.properties.SecurityProperties;

/**
 *      配置默认的请求 
 * Created by TianXin on 2018年12月29日.
 */
@RestController
public class BrowserSecurityController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BrowserSecurityController.class);

    /**
     * 请求的缓存信息
     */
    private RequestCache requestCache = new HttpSessionRequestCache();

    /**
     * 跳转策略
     */
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Autowired
    private SecurityProperties securityProperties;


    /**
     * 基本请求监听,没有返回401
     * 
     * @throws IOException
     */
    @RequestMapping("/authentication/require")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResultBean requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {

        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();

            LOGGER.info("引发请求的url: {} , 目标url: {}" ,targetUrl,securityProperties.getBrowser().getLoginPage());
            if(targetUrl.indexOf("/admin") != -1){
                redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
            }
        }

        return ResultBean.fail("没有权限,请先登陆!!");
    }

    
 
}
