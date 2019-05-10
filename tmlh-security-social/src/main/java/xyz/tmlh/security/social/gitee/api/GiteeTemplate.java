package xyz.tmlh.security.social.gitee.api;

import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

import xyz.tmlh.security.util.JsonUtils;

/**
 * <p>
 *  Gitee Impl
 * </p>
 *
 * @author TianXin
 * @since 2019年4月25日下午8:13:25
 */
public class GiteeTemplate extends AbstractOAuth2ApiBinding implements Gitee{
    
    /**
     * 获取授权用户的资料
     */
    private static final String URL_GET_USERINFO = "https://gitee.com/api/v5/user?access_token=%s";
    
    private String accessToken;
    
    public GiteeTemplate(String accessToken) {
        super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
        this.accessToken = accessToken;
    }

    @Override
    public GiteeUserInfo getUserInfo(){
        String response = "";
        try {
            String url = String.format(URL_GET_USERINFO, accessToken);
            response = getRestTemplate().getForObject(url, String.class);
        } catch (Exception e) {
            throw new RuntimeException("获取用户信息失败 !" ,e);
        }
        
        return JsonUtils.jsonToPojo(response, GiteeUserInfo.class);
    }

    
}
