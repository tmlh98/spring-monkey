package xyz.tmlh.forum.web.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

/**
 * <p>
 *    后台页面跳转操作
 * </p>
 *
 * @author TianXin
 * @since 2019年4月13日下午6:32:46
 */
@Api("后台页面跳转请求")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@Controller
@RequestMapping("/admin")
public class AdminSkipController {

    
    @GetMapping("/main" )
    public String main() {
        return "admin/main";
    }
    
    @GetMapping("/article")
    public String article() {
        return "admin/article/list";
    }
    
    @GetMapping("/user")
    public String user() {
        return "admin/user/list";
    }
    @GetMapping("/comment")
    public String comment() {
        return "admin/comment/list";
    }
    @GetMapping("/swagger")
    public String swagger() {
        return "admin/build/swagger";
    }
    
    @GetMapping("/druid")
    public String druid() {
        return "admin/build/druid";
    }
    
    
}
