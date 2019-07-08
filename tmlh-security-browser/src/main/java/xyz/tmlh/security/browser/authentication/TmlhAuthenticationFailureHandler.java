package xyz.tmlh.security.browser.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import xyz.tmlh.security.browser.suport.ResultBean;
import xyz.tmlh.security.properties.TmlhSecurityProperties;
import xyz.tmlh.security.properties.browser.LoginType;
import xyz.tmlh.security.util.JsonUtils;

/**
 * 
 * <p>
 *     自定义的登陆失败处理 implements 
 *          AuthenticationFailureHandler 
 *  Override 
 *          onAuthenticationFailure()
 * </p>
 *
 * @author TianXin
 * @since 2018年12月29日下午4:57:34
 */
@Component
public class TmlhAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TmlhAuthenticationFailureHandler.class);

    @Autowired
    private TmlhSecurityProperties tmlhSecurityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException,
        ServletException {
        LOGGER.info("----login in failure----");
        if (LoginType.JSON.equals(tmlhSecurityProperties.getBrowser().getLoginType())) {
            response.setContentType("application/json;charset=UTF-8");
            ResultBean result = ResultBean.fail(exception.getMessage()).putResult("exception", exception);
            response.getWriter().write(JsonUtils.objectToJson(result));
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }

    }

}
