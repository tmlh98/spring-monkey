package xyz.tmlh.forum.security.scoail;

import org.springframework.social.connect.Connection;
import org.springframework.stereotype.Component;

import xyz.tmlh.core.model.UserModel;

/**
 * <p>
 * 
 * </p>
 *
 * @author TianXin
 * @since 2019年6月15日下午9:05:45
 */
@Component
public class GiteeUserModelConvertor implements UserModelConvertor {

    /* (非 Javadoc) 
     * <p>Title: convertor</p> 
     * <p>Description: </p> 
     * @param connection
     * @return 
     * @see xyz.tmlh.forum.security.scoail.UserModelConvertor#convertor(org.springframework.social.connect.Connection) 
     */
    @Override
    public UserModel conver(Connection<?> connection) {
        String userId = connection.getKey().toString();
        String providerId = connection.getKey().getProviderId(); 
        String profileUrl = connection.getProfileUrl();
        

        return new UserModel(userId, connection.getDisplayName(), connection.getImageUrl(), providerId, profileUrl);

    }

}
