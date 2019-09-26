package xyz.tmlh.security.browser.authentication.manage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

import xyz.tmlh.security.core.properties.TmlhSecurityProperties;
import xyz.tmlh.security.core.support.SecurityConstants;

/**
 * <p>
 *    默认的放行策略
 * </p>
 *
 * @author TianXin
 * @since 2019年8月16日
 */
public class BrowserAuthorizeConfigProvider implements AuthorizeConfigProvider{

    
    @Autowired
    private TmlhSecurityProperties tmlhSecurityProperties;
    
    /* (非 Javadoc) 
     * <p>Title: config</p> 
     * <p>Description: </p> 
     * @param authorizeRequests
     * @return 
     * @see xyz.tmlh.security.browser.authentication.mamage.AuthorizeConfigProvider#config(org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry) 
     */ 
    @Override
    public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests) {
        authorizeRequests.antMatchers(
            SecurityConstants.DEFAULT_SESSION_INVALID_URL,
            SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
            SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*" ,
            tmlhSecurityProperties.getBrowser().getLoginPage(),
            tmlhSecurityProperties.getBrowser().getLoginProcessingUrl(),
            tmlhSecurityProperties.getBrowser().getSignUpUrl()
            ).permitAll();//不拦截请求
        
        return false;
    }

}
