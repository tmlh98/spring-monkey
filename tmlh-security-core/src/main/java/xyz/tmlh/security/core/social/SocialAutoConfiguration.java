package xyz.tmlh.security.core.social;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.AuthenticationNameUserIdSource;
import org.springframework.social.security.SpringSocialConfigurer;

import xyz.tmlh.security.core.properties.TmlhSecurityProperties;
/**
 * <p>
 * 社交配置主类
 * </p>
 *
 * @author TianXin
 * @since 2019年3月23日下午6:36:37
 */
@EnableSocial
@Configuration
public class SocialAutoConfiguration extends SocialConfigurerAdapter {

    @Autowired
    protected TmlhSecurityProperties tmlhSecurityProperties;

    @Autowired
    private DataSource dataSource;

    @Autowired(required = false)
    private ConnectionSignUp connectionSignUp;

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator factoryLocator) {
        JdbcUsersConnectionRepository repository = new JdbcUsersConnectionRepository(dataSource, factoryLocator, Encryptors.noOpText());
        
        if(tmlhSecurityProperties.getSocial().getTablePrefix() != null) {
            repository.setTablePrefix(tmlhSecurityProperties.getSocial().getTablePrefix());
        }
        
        if (connectionSignUp != null) {
            repository.setConnectionSignUp(connectionSignUp);
        }

        return repository;
    }

    @Override
    public UserIdSource getUserIdSource() {
        return new AuthenticationNameUserIdSource();
    }
    
    @Bean
    public SpringSocialConfigurer tmlhSpringSocialConfigurer() {
        String filterProcessesUrl = tmlhSecurityProperties.getSocial().getFilterProcessesUrl();
        TmlhSpringSocialConfigurer configurer = new TmlhSpringSocialConfigurer(filterProcessesUrl);
        configurer.signupUrl(tmlhSecurityProperties.getBrowser().getSignUpUrl());
        return configurer;
    }
    

    /**
     * 处理注册流程的工具类
     * 
     * @param factoryLocator
     * @return
     */
    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator factoryLocator) {
        return new ProviderSignInUtils(factoryLocator, getUsersConnectionRepository(factoryLocator));
    }

}
