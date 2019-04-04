package xyz.tmlh.forum.web.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * <p>
 * 
 * </p>
 *
 * @author TianXin
 * @since 2019年3月23日下午10:37:59
 */
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;
    
    @GetMapping
    public String user() {
        return "user/user";
    }

    @PostMapping("/regist")
    public String regist(String username,String password ,  HttpServletRequest request) {
        // 不管是注册用户还是绑定用户，都会拿到一个用户唯一标识。
        String userId = username;
        providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
        System.out.println("regist");
        return "XX";
    }
    
    
}
