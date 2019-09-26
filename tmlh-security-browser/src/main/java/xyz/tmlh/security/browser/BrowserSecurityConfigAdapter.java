package xyz.tmlh.security.browser;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

import xyz.tmlh.security.browser.authentication.manage.AuthorizeConfigManager;
import xyz.tmlh.security.core.properties.session.SessionProperties;
import xyz.tmlh.security.core.support.SecurityConstants;
import xyz.tmlh.security.core.validate.code.ValidateCodeFilter;

/**
 * <p>
 *      默认的实现web配置实现
 * </p>
 *
 * @author TianXin
 * @since 2019年4月8日下午4:29:50
 */
public class BrowserSecurityConfigAdapter extends BrowserLoginSecurityConfig {
    
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
    
    @Autowired
    private SessionInformationExpiredStrategy sessionInformationExpiredStrategy ;
    
    @Autowired
    private AuthorizeConfigManager authorizeConfigManager ;
    
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
        
        SessionProperties session = tmlhSecurityProperties.getSession();
        
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                .rememberMe()
                    .tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(tmlhSecurityProperties.getBrowser().getRememberMeSeconds())
                        .and()
                    .userDetailsService(userDetailsService)
                .sessionManagement()
                    .invalidSessionUrl(SecurityConstants.DEFAULT_SESSION_INVALID_URL)
                    .maximumSessions(session.getMaximumSessions())//最大的并发数
                    .maxSessionsPreventsLogin(session.isMaxSessionsPreventsLogin())//之后的登录是否踢掉之前的登录
                    .expiredSessionStrategy(sessionInformationExpiredStrategy)
                        .and()
                        .and()
                .logout()
                    .invalidateHttpSession(true)
                    .logoutUrl(tmlhSecurityProperties.getBrowser().getLogout())
                    .deleteCookies(SecurityConstants.JSESSIONID)
                    .logoutSuccessHandler(logoutSuccessHandler);
             
        authorizeConfigManager.config(http.authorizeRequests());
    }

}