package xyz.tmlh.forum.security;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

/**
 * <p>
 *    期望第一次注册的用户也能进入系统
 * </p>
 *
 * @author TianXin
 * @since 2019年3月23日下午9:27:43
 */
//@Component 
public class MyConnectionSignUp implements ConnectionSignUp {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MyConnectionSignUp.class);

	@Override
	public String execute(Connection<?> connection) {
	    LOGGER.info("QQ用户:{} , 登陆" ,  connection.getDisplayName());
		//根据社交用户信息默认创建用户并返回用户唯一标识
		return connection.getDisplayName();
	}

}
