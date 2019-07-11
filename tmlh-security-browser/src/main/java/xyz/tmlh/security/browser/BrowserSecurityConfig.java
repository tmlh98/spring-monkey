package xyz.tmlh.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import xyz.tmlh.security.core.properties.TmlhSecurityProperties;
import xyz.tmlh.security.core.properties.browser.BrowserProerties;
import xyz.tmlh.security.core.suport.SecurityConstants;

/**
 * <p>
 *    WebSecurity配置
 * </p>
 *
 * @author TianXin
 * @since 2019年3月25日下午4:34:57
 */
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;
    
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    
    @Autowired 
    protected TmlhSecurityProperties tmlhSecurityProperties;
    
	@Override
    protected void configure(HttpSecurity http) throws Exception {
	    applyPasswordAuthenticationConfig(http);
    }

    private void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
	    BrowserProerties browser = tmlhSecurityProperties.getBrowser();
	    
		http.formLogin()
			.loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
			.loginProcessingUrl(browser.getLoginProcessingUrl())
			.usernameParameter(browser.getUsernameParameter())
			.passwordParameter(browser.getPasswordParameter())
			.successHandler(authenticationSuccessHandler)
			.failureHandler(authenticationFailureHandler);
	}
	
}
