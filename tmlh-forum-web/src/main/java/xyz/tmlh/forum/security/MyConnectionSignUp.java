package xyz.tmlh.forum.security;


import java.time.LocalDateTime;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import xyz.tmlh.core.model.UserModel;
import xyz.tmlh.core.service.UserService;
import xyz.tmlh.security.exception.UserNotFoundException;
import xyz.tmlh.security.social.qq.api.QQ;
import xyz.tmlh.security.social.qq.api.QQUserInfo;

/**
 * <p>
 *    期望第一次注册的用户也能进入系统
 * </p>
 *
 * @author TianXin
 * @since 2019年3月23日下午9:27:43
 */
@Component
public class MyConnectionSignUp implements ConnectionSignUp {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyConnectionSignUp.class);

    @Autowired
    private UserService userSrvice;
    
    private String userId;
    
    private String providerId;

    @Override
    public String execute(Connection<?> connection) {
        this.userId = connection.getKey().toString();
        this.providerId = connection.getKey().getProviderId(); 
        
        UserModel user = userSrvice.getOne(new LambdaQueryWrapper<UserModel>().eq(UserModel::getUserconnectionId, userId));
        if (user == null) {
            if (StringUtils.equalsIgnoreCase(providerId, "qq")) {
                user = getQQUser(connection);
            } else if (StringUtils.equalsIgnoreCase(providerId, "gitee")){
                user = getGiteeUser(connection);
            }else {
                user = getGitHubUser(connection);
            }
            userSrvice.save(user);
        }

        LOGGER.info("用户 : {} , 注册成功  !",connection.getDisplayName());
        // 根据社交用户信息默认创建用户并返回用户唯一标识
        return userId;
    }

    
    private UserModel getGiteeUser(Connection<?> connection) {
        String detail = "Gitee profileUrl :" + connection.getProfileUrl();
        return new UserModel(userId, connection.getDisplayName(), connection.getImageUrl(), LocalDateTime.now(), providerId ,detail );
    }

    private UserModel getGitHubUser(Connection<?> connection) {
        UserProfile userInfo = connection.fetchUserProfile();
        String username = connection.getDisplayName();
        String imageUrl = connection.getImageUrl();
        String detail = "Github profileUrl :" + connection.getProfileUrl();
        return new UserModel(userId, username, imageUrl, LocalDateTime.now(), providerId, detail, null , userInfo.getEmail());
    }

    private UserModel getQQUser(Connection<?> connection) {
        QQ qq  = (QQ)connection.getApi();
        QQUserInfo userInfo = qq.getUserInfo();
        if (userInfo == null) {
            throw new UserNotFoundException("无法获取qq用户信息！");
        }
        return new UserModel(userId, userInfo.getNickname(), userInfo.getFigureurl_qq_2(), LocalDateTime.now(), providerId, userInfo.getYear() + " " + userInfo
            .getProvince() + " " + userInfo.getCity(), userInfo.getGender());
    }

}
