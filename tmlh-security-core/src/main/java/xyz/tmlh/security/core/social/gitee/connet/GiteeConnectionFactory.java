package xyz.tmlh.security.core.social.gitee.connet;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import xyz.tmlh.security.core.social.gitee.api.Gitee;

/**
 * <p>
 * GiteeConnectionFactory
 * </p>
 *
 * @author TianXin
 * @since 2019年4月26日上午9:07:08
 */
public class GiteeConnectionFactory extends OAuth2ConnectionFactory<Gitee> {

    public GiteeConnectionFactory(String providerId, String clientId, String clientSecret) {
        super(providerId, new GiteeServiceProvider(clientId, clientSecret), new GiteeApapter());
    }

}
