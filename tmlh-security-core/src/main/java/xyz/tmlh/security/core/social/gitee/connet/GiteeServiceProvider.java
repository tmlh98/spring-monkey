package xyz.tmlh.security.core.social.gitee.connet;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;
import org.springframework.social.oauth2.OAuth2Template;

import xyz.tmlh.security.core.social.gitee.api.Gitee;
import xyz.tmlh.security.core.social.gitee.api.GiteeTemplate;

/**
 * <p>
 *  Gitee ServiceProvider implementation. 
 * </p>
 *
 * @author TianXin
 * @since 2019年4月26日上午8:57:12
 */
public class GiteeServiceProvider extends AbstractOAuth2ServiceProvider<Gitee> {

    private static final String URL_AUTHORIZE = "https://gitee.com/oauth/authorize";
    
    /**
     * 获取access_token 也就是令牌
     */
    private static final String URL_ACCESS_TOKEN = "https://gitee.com/oauth/token";

    
    public GiteeServiceProvider(String clientId, String clientSecret) {
        super(createOAuth2Template(clientId, clientSecret));
    }

    private static OAuth2Template createOAuth2Template(String clientId, String clientSecret) {
        OAuth2Template oAuth2Template = new OAuth2Template(clientId, clientSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN);
        oAuth2Template.setUseParametersForClientAuthentication(true);
        return oAuth2Template;
    }

    public Gitee getApi(String accessToken) {
        return new GiteeTemplate(accessToken);
    } 



}
