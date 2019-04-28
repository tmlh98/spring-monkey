package xyz.tmlh.security.social.github.connet;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.github.api.GitHub;
import org.springframework.social.github.connect.GitHubServiceProvider;

/**
 * <p>
 *  定制  GitHubConnectionFactory
 * </p>
 *
 * @author TianXin
 * @since 2019年4月10日下午5:18:19
 */
public class GitHubConnectionFactory extends OAuth2ConnectionFactory<GitHub> {

	/**
	 * Creates a factory for GitHub connections.
	 * 
	 * @param clientId client ID
	 * @param clientSecret client secret
	 */
	public GitHubConnectionFactory(String providerId , String clientId, String clientSecret) {
		super(providerId, new GitHubServiceProvider(clientId, clientSecret), new GitHubAdapter());
	}

}
