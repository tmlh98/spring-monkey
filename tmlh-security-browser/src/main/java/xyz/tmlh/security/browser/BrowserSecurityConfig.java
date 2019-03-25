package xyz.tmlh.security.browser;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.social.security.SpringSocialConfigurer;

import xyz.tmlh.security.browser.authentication.TmlhAuthenticationFailureHandler;
import xyz.tmlh.security.browser.authentication.TmlhAuthenticationSuccessHandler;
import xyz.tmlh.security.properties.SecurityProperties;
import xyz.tmlh.security.validate.code.ValidateCodeFilter;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;
    
    @Autowired
    private TmlhAuthenticationSuccessHandler tmlhAuthenticationSuccessHandler;
    
    @Autowired
    private TmlhAuthenticationFailureHandler tmlhAuthenticationFailureHandler;
    
    @Autowired
    private ValidateCodeFilter validateCodeFilter;
    
    @Autowired
    private SpringSocialConfigurer tmlhSpringSocialConfigurer;
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private UserDetailsService myUserDetailsService;
    
    @Autowired
    private LogoutSuccessHandler logoutSuccessHandler ;
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
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
//        http.httpBasic()//使用httpBasic登陆
        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                    .formLogin().loginPage("/authentication/require")//自定义登陆页
                    .loginProcessingUrl("/authentication/form")//认证的url
                    .successHandler(tmlhAuthenticationSuccessHandler)//登陆成功处理器
                    .failureHandler(tmlhAuthenticationFailureHandler)//登陆失败处理器
                        .and()
                    .apply(tmlhSpringSocialConfigurer)
                        .and()
                .rememberMe()
                    .userDetailsService(myUserDetailsService)
                    .tokenRepository(persistentTokenRepository())
                    .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
                   .and()
                    .logout().permitAll().invalidateHttpSession(true).logoutUrl("/admin/logout")
                    .deleteCookies("JSESSIONID").logoutSuccessHandler(logoutSuccessHandler)
                .and()
            .authorizeRequests()
            .antMatchers("/authentication/require" ,
                "/code/*",
                "/" , "/index.html","/static/**","/user/regist","/user/me",
                securityProperties.getBrowser().getLoginPage(),
                securityProperties.getBrowser().getSignUpUrl()
                ).permitAll()//不拦截请求
            .anyRequest()
            .authenticated()
            .and().csrf().disable();//禁用csrf
        
        //解决bug Refused to display in a frame because it set 'X-Frame-Options' to 'DENY'
        http.headers().frameOptions().disable();
    }

}
