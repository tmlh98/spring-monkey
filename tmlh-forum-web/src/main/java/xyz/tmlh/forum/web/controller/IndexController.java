package xyz.tmlh.forum.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    
    @GetMapping({"/" , "/index.html"})
    public String index() {
        return "index";
    }
    
    @GetMapping({"/login" , "/user/login"})
    public String login() {
        return "user/login";
    }
    
    @GetMapping({"/user/article/publish" , "/user/question/publish"})
    public String addArticle() {
        return "user/article-add";
    }
    
    @GetMapping({"/user"})
    public String user() {
        return "user/user";
    }
    
}
