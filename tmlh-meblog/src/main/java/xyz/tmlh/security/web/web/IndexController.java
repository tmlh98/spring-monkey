package xyz.tmlh.security.web.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 *    
 * </p>
 *
 * @author TianXin
 * @since 2019年3月23日下午10:55:19
 */
@Controller
public class IndexController {

    @GetMapping("/signUp")
    public String sign(){
        return "demo-signUp";
    }
}
