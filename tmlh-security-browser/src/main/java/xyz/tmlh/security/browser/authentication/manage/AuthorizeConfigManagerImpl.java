package xyz.tmlh.security.browser.authentication.manage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

import xyz.tmlh.security.core.exception.RepeatedConfigException;

/**
 * <p>
 *  AuthorizeConfigManagerImpl
 * </p>
 *
 * @author TianXin
 * @since 2019年8月16日
 */
@Component
public class AuthorizeConfigManagerImpl implements AuthorizeConfigManager {

    @Autowired
    List<AuthorizeConfigProvider> authorizeConfigProviders;

    /* (非 Javadoc) 
     * <p>Title: config</p> 
     * <p>Description: </p> 
     * @param authorizeRequests 
     * @see xyz.tmlh.security.browser.authentication.mamage.AuthorizeConfigManager#config(org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer.ExpressionInterceptUrlRegistry) 
     */
    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests) {

        boolean existAnyRequestConfig = false;

        for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
            boolean currentIsAnyRequestConfig = authorizeConfigProvider.config(authorizeRequests);
            if (existAnyRequestConfig && currentIsAnyRequestConfig) {

                throw new RepeatedConfigException("重复的anyRequest配置:" + authorizeConfigProvider
                        .getClass().getSimpleName());

            } else if (currentIsAnyRequestConfig) {
                existAnyRequestConfig = true;
            }
        }

        if (!existAnyRequestConfig) {
            authorizeRequests.anyRequest().authenticated();
        }

    }

}
