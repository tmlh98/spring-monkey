package xyz.tmlh.security.browser.authentication.suport;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import xyz.tmlh.security.core.exception.NotFoundImplementException;


/**
 * <p>
 *      默认登出处理
 * </p>
 *
 * @author TianXin
 * @since 2019年7月10日下午1:11:01
 */
public class DefaultLogoutSuccessHandler implements LogoutSuccessHandler {

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) 
        throws IOException, ServletException {
        
        throw new NotFoundImplementException("请实现" + getClass().getSimpleName());
    }

}
