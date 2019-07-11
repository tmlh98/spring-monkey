package xyz.tmlh.security.core.social.gitee.connet;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import xyz.tmlh.security.core.social.gitee.api.Gitee;
import xyz.tmlh.security.core.social.gitee.api.GiteeUserInfo;

/**
 * <p>
 *  GiteeApapter
 * </p>
 *
 * @author TianXin
 * @since 2019年4月25日下午8:17:06
 */
public class GiteeApapter implements ApiAdapter<Gitee>{

    @Override
    public boolean test(Gitee api) {
        return true;
    }

    @Override
    public void setConnectionValues(Gitee api, ConnectionValues values) {
        GiteeUserInfo userInfo = api.getUserInfo();
        values.setProviderUserId(userInfo.getId());      
        values.setDisplayName(userInfo.getName());
        values.setProfileUrl(userInfo.getHtml_url());
        values.setImageUrl(userInfo.getAvatar_url());
    }

    @Override
    public UserProfile fetchUserProfile(Gitee api) {
        return null;

    }

    @Override
    public void updateStatus(Gitee api, String message) {
        
    }

}
