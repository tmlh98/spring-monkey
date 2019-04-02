package xyz.tmlh.forum.security;
import java.time.LocalDateTime;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import xyz.tmlh.core.model.UserModel;
import xyz.tmlh.core.service.UserService;
import xyz.tmlh.forum.util.SessionUtil;
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
    
	@Override
	public String execute(Connection<?> connection) {
	    
	    String userId = connection.getKey().toString();
	    //切割出 source 和 openId
	    String[] strings = StringUtils.splitByWholeSeparatorPreserveAllTokens(userId, ":");
	    
	    QQUserInfo userInfo = (QQUserInfo)SessionUtil.getAttribute(strings[1]);
	    if(userInfo != null) {
	        UserModel user = userSrvice.getOne(new LambdaQueryWrapper<UserModel>().eq(UserModel::getUserconnectionId , userId));
	        if(user == null) {
	            user = new UserModel(userId, 
        	                userInfo.getNickname(), 
        	                userInfo.getFigureurl_qq_2(), 
        	                LocalDateTime.now(), 
        	                strings[0], 
        	                userInfo.getYear() + " " + userInfo.getProvince() + " " + userInfo.getCity(),
        	                userInfo.getGender());
	            
	            userSrvice.save(user);
	            SessionUtil.remove(strings[1]);
	            LOGGER.info("QQ用户:{} , 注册成功  !" ,  connection.getDisplayName());
	        }
	    }
	    
		//根据社交用户信息默认创建用户并返回用户唯一标识
		return connection.getKey().toString();
	}

}
