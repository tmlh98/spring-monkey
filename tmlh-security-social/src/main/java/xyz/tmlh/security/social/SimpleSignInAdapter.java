package xyz.tmlh.security.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.SignInAdapter;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Service;
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
@Service
public class SimpleSignInAdapter implements SignInAdapter {

    @Autowired
    private SocialUserDetailsService socialUserDetailsService;

    @Override
    public String signIn(String userId, Connection<?> connection, NativeWebRequest request) {
        SocialUserDetails user = socialUserDetailsService.loadUserByUserId(userId);
        System.out.println("SimpleSignInAdapter 's  user " + user);
        if (user != null) {
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user
                .getAuthorities()));
            return user.getUsername();
        } else {
            return null;
        }
    }

}