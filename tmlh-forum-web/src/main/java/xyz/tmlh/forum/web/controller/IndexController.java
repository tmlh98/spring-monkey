package xyz.tmlh.forum.web.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import xyz.tmlh.core.enums.PublishType;
import xyz.tmlh.core.model.UserModel;
import xyz.tmlh.core.service.CatalogService;
import xyz.tmlh.core.service.UserService;
import xyz.tmlh.forum.annotation.SysLog;
import xyz.tmlh.forum.util.scope.RequestUtils;
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
    
    @Autowired
    private CatalogService catalogService;
    
    @SysLog("首页")
    @GetMapping({"/" ,"/index", "/index.html"})
    public String index(Model model) {
        List<UserModel> userList = userService.list();
        model.addAttribute("userList", userList);
        return "index";
    }
    
    @SysLog("登陆页")
    @GetMapping({"/login" , "/user/login"})
    public String login() {
        return "user/login";
    }
    @GetMapping({"/admin" , "/admin/login"})
    public String adminLogin() {
        return "admin/login";
    }
    
    @GetMapping({"/user/question/publish" ,"/user/article/publish"})
    public String questionPublish(@RequestParam(required=false) Integer id,Model model) {
        if (!CurrentUserUtils.isExistUser()) {
            throw new UserNotFoundException("user not found ！");
        }
        
        String url = RequestUtils.getHttpServletRequest().getRequestURI();
        if(StringUtils.contains("/user/article/publish", url)) {
            model.addAttribute("publishType", PublishType.ARTICLE.toString());
        }else {
            model.addAttribute("publishType", PublishType.QUESTION.toString());
        }
        model.addAttribute("catalogList", catalogService.list());
        return "user/article-publish";
    }
    
}
