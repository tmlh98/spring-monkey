package xyz.tmlh.security.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import xyz.tmlh.security.suport.SecurityConstants;

/**
 * <p>
 *    WebSecurity配置
 * </p>
 *
 * @author TianXin
 * @since 2019年3月25日下午4:34:57
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler tmlhAuthenticationSuccessHandler;
    
    @Autowired
    private AuthenticationFailureHandler tmlhAuthenticationFailureHandler;
	
	protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
		http.formLogin()
			.loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
			.loginProcessingUrl(SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM)
			.successHandler(tmlhAuthenticationSuccessHandler)
			.failureHandler(tmlhAuthenticationFailureHandler);
	}
	
}
