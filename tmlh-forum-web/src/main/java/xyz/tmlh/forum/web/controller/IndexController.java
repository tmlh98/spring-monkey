package xyz.tmlh.forum.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import xyz.tmlh.core.enums.PublishType;
import xyz.tmlh.core.model.UserModel;
import xyz.tmlh.core.service.UserService;
import xyz.tmlh.forum.util.user.CurrentUserUtils;
import xyz.tmlh.security.exception.UserNotFoundException;

/**
 * <p>
 *    跳转策略
 * </p>
 *
 * @author TianXin
 * @since 2019年3月25日上午11:42:08
 */
@Controller
public class IndexController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping({"/" ,"/index", "/index.html"})
    public String index(Model model) {
        List<UserModel> userList = userService.list();
        model.addAttribute("userList", userList);
        return "index";
    }
    
    @GetMapping({"/login" , "/user/login"})
    public String login() {
        return "user/login";
    }
    
    @GetMapping("/user/question/publish")
    public String questionPublish(Model model) {
        if (!CurrentUserUtils.isExistUser()) {
            throw new UserNotFoundException("user not found ！");
        }
        
        model.addAttribute("publishType", PublishType.QUESTION.toString());
        return "user/article-publish";
    }
    
    @GetMapping("/user/article/publish")
    public String articlePublish(Model model) {
        if (!CurrentUserUtils.isExistUser()) {
            throw new UserNotFoundException("user not found ！");
        }
        
        model.addAttribute("publishType", PublishType.ARTICLE.toString());
        return "user/article-publish";
    }
    
}
