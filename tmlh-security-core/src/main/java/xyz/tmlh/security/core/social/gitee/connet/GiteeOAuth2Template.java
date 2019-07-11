package xyz.tmlh.security.core.social.gitee.connet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.oauth2.AccessGrant;
import org.springframework.social.oauth2.OAuth2Template;
import org.springframework.util.MultiValueMap;

/**
 * <p>
 * GiteeOAuth2Template
 * </p>
 *
 * @author TianXin
 * @since 2019年4月26日上午9:14:18
 */
public class GiteeOAuth2Template extends OAuth2Template {
    
    
    private static final Logger LOGGER = LoggerFactory.getLogger(GiteeOAuth2Template.class);


    public GiteeOAuth2Template(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
        super(clientId, clientSecret, authorizeUrl, accessTokenUrl);
    }

    @Override
    protected AccessGrant postForAccessGrant(String accessTokenUrl, MultiValueMap<String, String> parameters) {
        String responseStr = getRestTemplate().postForObject(accessTokenUrl, parameters, String.class);

        LOGGER.info("获取accessToke的响应:{}", responseStr);

        return super.postForAccessGrant(accessTokenUrl, parameters);
    }

}
