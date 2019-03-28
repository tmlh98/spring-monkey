package xyz.tmlh.security.browser.authentication;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import xyz.tmlh.security.browser.suport.ResultBean;
import xyz.tmlh.security.properties.LoginType;
import xyz.tmlh.security.properties.SecurityProperties;

/**  
 * 自定义的登陆成功处理 
 *      implements 
 *  AuthenticationSuccessHandler 
 *      Override 
 *  onAuthenticationSuccess()
 * @CreateInformation Created by TianXin on 2018年12月29日. 
 */
@Component
public class TmlhAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
    
    private static final Logger LOGGER = LoggerFactory.getLogger(TmlhAuthenticationSuccessHandler.class);

    @Autowired
    private ObjectMapper objectMapper;
    
    @Autowired
    private SecurityProperties securityProperties;
    
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException,
        ServletException {
        LOGGER.info("----login in succcess----");
        if(LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(objectMapper.writeValueAsString(ResultBean.success()));
            
            LOGGER.info("authentication : {}" , ReflectionToStringBuilder.toString(authentication , ToStringStyle.MULTI_LINE_STYLE));
        }else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
        
    }

}
