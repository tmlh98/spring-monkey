package xyz.tmlh.forum.web.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.tmlh.core.model.UserModel;
import xyz.tmlh.core.service.SocialService;
import xyz.tmlh.core.service.UserService;
import xyz.tmlh.forum.util.user.CurrentUserUtils;

/**
 * <p>
 *    
 * </p>
 *
 * @author TianXin
 * @since 2019年4月6日下午7:32:59
 */
@RequestMapping("/user")
@Controller
public class UserDataController {
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private SocialService socialService;
    
    @GetMapping("/{id}")
    public String user(@PathVariable("id")Integer id , Model model) {
        UserModel user = userService.getById(id);
        model.addAttribute("user", user);
        boolean isFollow = false;
        if(CurrentUserUtils.isExistUser()) {
            isFollow = socialService.selectFollow(CurrentUserUtils.getUser().getId() , id);
        }
        model.addAttribute("isFollow", isFollow);
        
        model.addAttribute("fansList", socialService.selectFansList(id));
        model.addAttribute("followList", socialService.selectFollowList(id));
      
        return "user/user";
    }
    
}
