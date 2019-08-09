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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import xyz.tmlh.security.browser.suport.ResultBean;
import xyz.tmlh.security.core.properties.TmlhSecurityProperties;
import xyz.tmlh.security.core.suport.SecurityConstants;

/**
 * <p>
 *   配置默认的请求
 * </p>
 *
 * @author TianXin
 * @since 2019年7月10日下午1:52:04
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
    private TmlhSecurityProperties tmlhSecurityProperties;

    /**
     * 基本请求监听,没有返回401
     * 
     * @throws IOException
     */
    @RequestMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public ResultBean requireAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();

            LOGGER.info("引发请求的url: {}  ", targetUrl );
            redirectStrategy.sendRedirect(request, response, tmlhSecurityProperties.getBrowser().getRedirectUrl());
        }
        
        return ResultBean.fail("请先登陆!");
    }

    /**
     * @throws IOException 
     * session 失效后的策略
      *
      * @param @return    参数
      * @return ResultBean    返回类型
      * @throws
     */
    @GetMapping(SecurityConstants.DEFAULT_SESSION_INVALID_URL)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void sessionInvalid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        redirectStrategy.sendRedirect(request, response, tmlhSecurityProperties.getBrowser().getRedirectUrl());
    }
    
}
