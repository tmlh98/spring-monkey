package xyz.tmlh.forum.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.web.context.request.NativeWebRequest;
/**
 * <p>
 *    应用程序执行first的connectionSignUp类和signInAdapter后，
 *    第一个应用程序应该执行signInAdapter，在那里试图找到，如果用户已经存在：
 * </p>
 *
 * @author TianXin
 * @since 2019年4月11日上午10:22:36
 */
//@Service
public class SimpleSignInAdapter implements SignInAdapter {

    @Override
    public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
        System.out.println("SimpleSignInAdapter 's  user -----------------------------" );
        return userId;
    }

}