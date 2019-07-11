package xyz.tmlh.forum.web.security.scoail;

import java.time.LocalDateTime;

import org.springframework.social.connect.Connection;
import org.springframework.stereotype.Component;

import xyz.tmlh.forum.core.model.UserModel;
import xyz.tmlh.security.core.exception.UserNotFoundException;
import xyz.tmlh.security.core.social.qq.api.QQ;
import xyz.tmlh.security.core.social.qq.api.QQUserInfo;

/**
 * <p>
 *    
 * </p>
 *
 * @author TianXin
 * @since 2019年6月15日下午9:03:33
 */
@Component
public class QqUserModelConvertor implements UserModelConvertor{

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
        
        QQ qq  = (QQ)connection.getApi();
        QQUserInfo userInfo = qq.getUserInfo();
        if (userInfo == null) {
            throw new UserNotFoundException("无法获取qq用户信息！");
        }
        return new UserModel(userId, userInfo.getNickname(), userInfo.getFigureurl_qq_2(), LocalDateTime.now(), providerId, userInfo.getYear() + " " + userInfo
            .getProvince() + " " + userInfo.getCity(), userInfo.getGender());
    }

}
