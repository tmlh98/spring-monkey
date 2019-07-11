package xyz.tmlh.forum.web.security.scoail;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import xyz.tmlh.forum.core.model.UserModel;
import xyz.tmlh.forum.core.service.UserService;

/**
 * <p>
 *    期望第一次注册的用户也能进入系统
 * </p>
 *
 * @author TianXin
 * @since 2019年3月23日下午9:27:43
 */
@Component
public class TmlhConnectionSignUp implements ConnectionSignUp {

    private static final Logger LOGGER = LoggerFactory.getLogger(TmlhConnectionSignUp.class);

    @Autowired
    private UserService userSrvice;
    
    @Autowired
    private Map<String, UserModelConvertor> userModelConvertorMap;

    @Override
    public String execute(Connection<?> connection) {
        String userId = connection.getKey().toString();
        String providerId = connection.getKey().getProviderId(); 
        
        UserModel user = userSrvice.getOne(new LambdaQueryWrapper<UserModel>().eq(UserModel::getUserconnectionId, userId));
        if (user == null) {
            UserModel userModel = userModelConvertorMap.get(providerId + UserModelConvertor.SUFFIX_BEANNAME).conver(connection);
            userSrvice.save(userModel);
            LOGGER.info("用户 : {} , 注册成功  !",connection.getDisplayName());
        }

        // 根据社交用户信息默认创建用户并返回用户唯一标识
        return userId;
    }


}
