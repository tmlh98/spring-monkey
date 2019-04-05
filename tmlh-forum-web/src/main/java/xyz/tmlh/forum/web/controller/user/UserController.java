package xyz.tmlh.forum.web.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.tmlh.core.model.ArticleModel;
import xyz.tmlh.core.service.ArticleService;
import xyz.tmlh.forum.util.user.CurrentUserUtils;
import xyz.tmlh.security.browser.suport.ResultBean;

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
    private ArticleService articleService;
    
    @GetMapping
    public String me() {
        return "user/user";
    }
    
    @GetMapping("/{id}")
    public String user(@PathVariable("id")Integer id) {
        return "user/user";
    }
    
    @ResponseBody
    @PostMapping("/article/publish")
    public ResultBean questionArticle(ArticleModel article) {
        article.setUserId(CurrentUserUtils.getUser().getId());
        articleService.save(article );
        return ResultBean.success().putResult("articleId", article.getId());
    }
    
}
