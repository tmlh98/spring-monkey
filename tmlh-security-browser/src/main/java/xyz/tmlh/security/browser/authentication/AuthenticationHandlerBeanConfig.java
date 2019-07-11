package xyz.tmlh.security.browser.authentication;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.social.security.SocialUserDetailsService;

import xyz.tmlh.security.browser.authentication.suport.DefaultAuthenticationFailureHandler;
import xyz.tmlh.security.browser.authentication.suport.DefaultAuthenticationSuccessHandler;
import xyz.tmlh.security.browser.authentication.suport.DefaultLogoutSuccessHandler;
import xyz.tmlh.security.browser.authentication.suport.DefaultSocialUserDetailsService;

/**
 * <p>
 *   AuthenticationHandlerBeanConfig
 * </p>
 *
 * @author TianXin
 * @since 2019年7月9日上午10:14:25
 */
@Configuration
public class AuthenticationHandlerBeanConfig {
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean 
    @ConditionalOnMissingBean
    public AuthenticationSuccessHandler tmlhAuthenticationSuccessHandler() {
        return new DefaultAuthenticationSuccessHandler();
    }
    
    @Bean 
    @ConditionalOnMissingBean
    public AuthenticationFailureHandler tmlhAuthenticationFailureHandler() {
        return new DefaultAuthenticationFailureHandler();
    }
    
    @Bean 
    @ConditionalOnMissingBean
    public LogoutSuccessHandler logoutSuccessHandler() {
        return new DefaultLogoutSuccessHandler();
    }
    
    @Bean 
    @ConditionalOnMissingBean
    public SocialUserDetailsService socialUserDetailsService() {
        return new DefaultSocialUserDetailsService();
    }
    
}
