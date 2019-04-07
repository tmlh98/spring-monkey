package xyz.tmlh.forum.web.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import xyz.tmlh.core.model.ArticleModel;
import xyz.tmlh.core.model.CommentModel;
import xyz.tmlh.core.model.UserModel;
import xyz.tmlh.core.model.data.CommentDo;
import xyz.tmlh.core.service.ArticleService;
import xyz.tmlh.core.service.CommentService;
import xyz.tmlh.core.service.SocialService;
import xyz.tmlh.core.service.UserService;
import xyz.tmlh.forum.util.JsonUtils;
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
    
    @Autowired
    private CommentService commentService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private SocialService socialService;
    
    @GetMapping
    public String me(Model model) {
        model.addAttribute("fansCount", socialService.selectFansCount(CurrentUserUtils.getUser().getId()));
        model.addAttribute("followCount", socialService.selectFollowCount(CurrentUserUtils.getUser().getId()));
        return "user/me";
    }
    
    @GetMapping("/article/{id}")
    public String editArticle(@PathVariable("id")Integer id ,Model model) {
        model.addAttribute("article", articleService.getById(id));
        return "user/article-edit";
    }
    
    
    @ResponseBody
    @PostMapping("/article/publish")
    public ResultBean questionArticle(String articleStr) {
        ArticleModel article = JsonUtils.jsonToPojo(articleStr, ArticleModel.class);
        article.setUser(CurrentUserUtils.getUser());
        articleService.save(article );
        return ResultBean.success().putResult("articleId", article.getId());
    }
    
    @ResponseBody
    @PutMapping("/article/edit")
    public ResultBean editArticle(String articleStr) {
        ArticleModel article = JsonUtils.jsonToPojo(articleStr, ArticleModel.class);
        article.setUser(CurrentUserUtils.getUser());
        articleService.updateById(article );
        return ResultBean.success().putResult("articleId", article.getId());
    }
    
    @ResponseBody
    @DeleteMapping("/article/{id}")
    public ResultBean deleteArticle(@PathVariable("id") Integer id) {
        articleService.removeById(id);
        return ResultBean.success("删除成功!");
    }
    
    @ResponseBody
    @PostMapping("/comment/publish")
    public ResultBean commentPublish(CommentModel comment) {
        UserModel user = CurrentUserUtils.getUser();
        comment.setUserId(user.getId());
        commentService.save(comment);
        return ResultBean.success().putResult("comment", new CommentDo(comment, user));
    }
    
    @ResponseBody
    @PutMapping("/update")
    public ResultBean updateMsg(String email , String signature) {
        UserModel user = new UserModel();
        user.setId(CurrentUserUtils.getUser().getId());
        user.setEmail(email);
        user.setSignature(signature);
        userService.updateById(user);
        return ResultBean.success();
    }
    
}
