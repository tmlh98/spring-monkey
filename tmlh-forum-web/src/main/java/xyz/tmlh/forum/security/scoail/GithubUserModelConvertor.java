package xyz.tmlh.forum.security.scoail;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Component;

import xyz.tmlh.core.model.UserModel;

/**
 * <p>
 *    
 * </p>
 *
 * @author TianXin
 * @since 2019年6月15日下午9:06:04
 */
@Component
public class GithubUserModelConvertor implements UserModelConvertor{

    /* (非 Javadoc) 
     * <p>Title: convertor</p> 
     * <p>Description: </p> 
     * @param connection
     * @return 
     * @see xyz.tmlh.forum.security.scoail.UserModelConvertor#convertor(org.springframework.social.connect.Connection) 
     */ 
    @Override
    public UserModel convertor(Connection<?> connection) {
        String userId = connection.getKey().toString();
        String providerId = connection.getKey().getProviderId(); 

        UserProfile userInfo = connection.fetchUserProfile();
        String username = connection.getDisplayName();
        String imageUrl = connection.getImageUrl();
        
        String profileUrl = connection.getProfileUrl();
        UserModel userModel = new UserModel(userId, 
            username, imageUrl, providerId, profileUrl);
        userModel.setEmail(userInfo.getEmail());
        return  userModel;
    }
    
    
    

}
