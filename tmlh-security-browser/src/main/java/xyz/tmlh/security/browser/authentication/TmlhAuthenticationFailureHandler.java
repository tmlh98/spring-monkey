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

import com.fasterxml.jackson.databind.ObjectMapper;

import xyz.tmlh.security.browser.suport.ResultBean;
import xyz.tmlh.security.properties.LoginType;
import xyz.tmlh.security.properties.SecurityProperties;

/**
 * 自定义的登陆失败处理 implements AuthenticationFailureHandler Override onAuthenticationFailure()
 * 
 * @CreateInformation Created by TianXin on 2018年12月29日.
 */
@Component
public class TmlhAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TmlhAuthenticationFailureHandler.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException,
        ServletException {
        LOGGER.info("----login in failure----");
        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setContentType("application/json;charset=UTF-8");
            String jsonResult = objectMapper.writeValueAsString(ResultBean.fail(exception.getMessage()).putResult("exception", exception));
            response.getWriter().write(jsonResult);
        } else {
            super.onAuthenticationFailure(request, response, exception);
        }

    }

}
