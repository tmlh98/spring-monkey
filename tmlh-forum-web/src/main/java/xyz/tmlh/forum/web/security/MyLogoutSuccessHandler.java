package xyz.tmlh.forum.web.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import xyz.tmlh.forum.web.util.user.CurrentUserUtils;

/**
 * 自定义登出处理
 * Created by TianXin on 2019年1月21日下午5:33:27.
 */
@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(MyLogoutSuccessHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) 
        throws IOException, ServletException {
        
        try {
            UserDetails user = (UserDetails)authentication.getPrincipal();
            
            //删除session
            CurrentUserUtils.removeUser();
            LOGGER.info("USER : " + user.getUsername() + " LOGOUT SUCCESS !  ");
        } catch (Exception e) {
            LOGGER.info("LOGOUT EXCEPTION , e : {} ", e);
        }
        response.sendRedirect("/user/login");

    }

}
