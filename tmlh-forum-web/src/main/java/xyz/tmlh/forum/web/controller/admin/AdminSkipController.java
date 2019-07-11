package xyz.tmlh.forum.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import xyz.tmlh.forum.core.service.SysLogService;
import xyz.tmlh.forum.core.service.UserService;

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
    
    @Autowired
    private SysLogService sysLogService;
    
    @Autowired
    private UserService userService;

    @ApiOperation("跳转到管理主页")
    @GetMapping("/main" )
    public String main(Model model) {
        model.addAttribute("homeFlux", sysLogService.findHomeFlux());
        model.addAttribute("userCount", userService.count());
        model.addAttribute("loginUserCount", "?");
        return "admin/main";
    }
    
    @ApiOperation("跳转到文章管理")
    @GetMapping("/article")
    public String article() {
        return "admin/article/list";
    }
    
    @ApiOperation("跳转到用户管理")
    @GetMapping("/user")
    public String user() {
        return "admin/user/list";
    }
    
    @ApiOperation("跳转到回复管理")
    @GetMapping("/comment")
    public String comment() {
        return "admin/comment/list";
    }
    
    @ApiOperation("跳转到日志管理")
    @GetMapping("/syslog")
    public String syslog() {
        return "admin/log/list";
    }
    
    @ApiOperation("跳转到接口管理")
    @GetMapping("/swagger")
    public String swagger() {
        return "admin/build/swagger";
    }
    
    @ApiOperation("跳转到数据源监控")
    @GetMapping("/druid")
    public String druid() {
        return "admin/build/druid";
    }
    
    
}
