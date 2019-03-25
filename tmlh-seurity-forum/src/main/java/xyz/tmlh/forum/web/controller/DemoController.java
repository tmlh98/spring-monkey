package xyz.tmlh.forum.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * <p>
 * 
 * </p>
 *
 * @author TianXin
 * @since 2019年3月23日下午10:37:59
 */
@RequestMapping("/user")
@RestController
public class DemoController {

    @Autowired
    private ProviderSignInUtils providerSignInUtils;

    @PostMapping("/regist")
    public String regist(String username,String password ,  HttpServletRequest request) {
        // 不管是注册用户还是绑定用户，都会拿到一个用户唯一标识。
        String userId = username;
        providerSignInUtils.doPostSignUp(userId, new ServletWebRequest(request));
        System.out.println("regist");
        return "XX";
    }

    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user) {
        System.out.println(user);
        return user;
    }
}
