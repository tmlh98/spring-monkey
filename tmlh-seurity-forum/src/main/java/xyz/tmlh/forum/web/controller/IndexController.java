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
    
    @GetMapping("/signUp")
    public String sign(){
        return "demo-signUp";
    }
    
    @GetMapping("/admin/login")
    public String login(){
        return "login";
    }
    
}
