package xyz.tmlh.security.browser;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import xyz.tmlh.security.core.suport.SecurityConstants;
import xyz.tmlh.security.core.validate.code.ValidateCodeFilter;

/**
 * <p>
 *      默认的实现web配置实现
 * </p>
 *
 * @author TianXin
 * @since 2019年4月8日下午4:29:50
 */
public class BrowserSecurityConfigAdapter extends BrowserSecurityConfig {
    
    @Autowired
    private ValidateCodeFilter validateCodeFilter;
    
    @Autowired
    private SpringSocialConfigurer tmlhSpringSocialConfigurer;
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private UserDetailsService userDetailsService;
    
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler ;
    
    /**
     * 记住我实现
     */
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl jdbcTokenRepositoryImpl = new JdbcTokenRepositoryImpl();
        jdbcTokenRepositoryImpl.setDataSource(dataSource);
        jdbcTokenRepositoryImpl.setCreateTableOnStartup(true);
        return jdbcTokenRepositoryImpl;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
 
        http.apply(tmlhSpringSocialConfigurer);
        
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                    .rememberMe()
                    .tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(tmlhSecurityProperties.getBrowser().getRememberMeSeconds())
                        .and()
                    .userDetailsService(userDetailsService)
                .logout().permitAll()
                    .invalidateHttpSession(true)
                    .logoutUrl(tmlhSecurityProperties.getBrowser().getLogout())
                    .deleteCookies("JSESSIONID")
                    .logoutSuccessHandler(logoutSuccessHandler)
                .and()
            .authorizeRequests()
            
            .antMatchers(
                SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
                SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*" ,
                tmlhSecurityProperties.getBrowser().getLoginPage(),
                tmlhSecurityProperties.getBrowser().getLoginProcessingUrl(),
                tmlhSecurityProperties.getBrowser().getSignUpUrl()
                ).permitAll()//不拦截请求
            
            .anyRequest()
            .authenticated()
                .and()
            .csrf().disable();//禁用csrf
        
        //解决bug Refused to display in a frame because it set 'X-Frame-Options' to 'DENY'
        http.headers().frameOptions().disable();
    }

}
