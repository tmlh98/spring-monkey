package xyz.tmlh.security.social.github.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.github.api.GitHub;

import xyz.tmlh.security.properties.TmlhSecurityProperties;
import xyz.tmlh.security.properties.social.GitHubProperties;
import xyz.tmlh.security.social.SocialConfig;
import xyz.tmlh.security.social.github.connet.GitHubConnectionFactory;

/**
 * <p>
 *  github 的自动配置类    
 * </p>
 *
 * @author TianXin
 * @since 2019年4月10日下午2:08:22
 */
@EnableSocial
@Configuration
@ConditionalOnClass(SocialConfig.class)
@ConditionalOnProperty(prefix = "tmlh.security.social.github", name = "app-id")
public class GitHubAutoConfig extends SocialConfig{

    private static final Logger LOGGER = LoggerFactory.getLogger(GitHubAutoConfig.class);

    @Autowired
    protected TmlhSecurityProperties tmlhSecurityProperties;
    
    @Bean
    @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
    public GitHub gitHub(ConnectionRepository repository) {
        Connection<GitHub> connection = repository.findPrimaryConnection(GitHub.class);
        return connection != null ? connection.getApi() : null;
    }
    
    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment) {
        super.addConnectionFactories(connectionFactoryConfigurer, environment);
        GitHubProperties github = tmlhSecurityProperties.getSocial().getGithub();
        GitHubConnectionFactory gitHubConnectionFactory = new GitHubConnectionFactory(github.getProviderId(), github.getAppId(), github.getAppSecret());
        connectionFactoryConfigurer.addConnectionFactory(gitHubConnectionFactory);
        LOGGER.info("社交登陆github配置成功!");
    }
    

}