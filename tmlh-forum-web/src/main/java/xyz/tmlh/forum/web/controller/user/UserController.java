package xyz.tmlh.forum.web.controller.user;


import java.time.LocalDateTime;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import xyz.tmlh.forum.core.enums.PublishType;
import xyz.tmlh.forum.core.model.ArticleModel;
import xyz.tmlh.forum.core.model.CommentModel;
import xyz.tmlh.forum.core.model.UserModel;
import xyz.tmlh.forum.core.model.data.CommentDo;
import xyz.tmlh.forum.core.service.ArticleService;
import xyz.tmlh.forum.core.service.CatalogService;
import xyz.tmlh.forum.core.service.CommentService;
import xyz.tmlh.forum.core.service.MessageService;
import xyz.tmlh.forum.core.service.SocialService;
import xyz.tmlh.forum.core.service.UserService;
import xyz.tmlh.forum.web.util.user.CurrentUserUtils;
import xyz.tmlh.security.browser.log.SysLog;
import xyz.tmlh.security.browser.support.ResultBean;
import xyz.tmlh.security.core.util.JsonUtils;

/**
 * <p>
 * 
 * </p>
 *
 * @author TianXin
 * @since 2019年3月23日下午10:37:59
 */
@Api("用户管理")
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
    
    @Autowired
    private CatalogService catalogService;
    
    @Autowired
    private MessageService messageService;
    
    @GetMapping
    public String me(Model model) {
        model.addAttribute("fansList", socialService.selectFansList(CurrentUserUtils.getUser().getId()));
        model.addAttribute("followList", socialService.selectFollowList(CurrentUserUtils.getUser().getId()));
        
        
        model.addAttribute("articleCount" , articleService.selectByUser(CurrentUserUtils.getUser().getId(), PublishType.ARTICLE));
        model.addAttribute("questionCount" , articleService.selectByUser(CurrentUserUtils.getUser().getId(), PublishType.QUESTION));
        model.addAttribute("commentCount" , commentService.selectByUser(CurrentUserUtils.getUser().getId()));
        return "user/me";
    }
    
    @GetMapping("/article/{id}")
    public String editArticle(@PathVariable("id")Integer id ,ModelMap model) {
        model.addAttribute("article", articleService.getById(id));
        model.addAttribute("catalogList", catalogService.list());
        return "user/article-edit";
    }
    
    @SysLog("发布文章或问答")
    @ApiOperation("发布文章或问答")
    @ResponseBody
    @PostMapping("/article/publish")
    public ResultBean questionArticle(String articleStr) {
        ArticleModel article = JsonUtils.jsonToPojo(articleStr, ArticleModel.class);
        if(StringUtils.isBlank(article.getTitle())) {
            return ResultBean.fail().msg("标题不能为空!");
        }
        article.setUser(CurrentUserUtils.getUser());
        articleService.save(article );
        return ResultBean.success().putResult("articleId", article.getId());
    }
    
    @SysLog("修改文章")
    @ApiOperation("修改文章")
    @ResponseBody
    @PutMapping("/article/edit")
    public ResultBean editArticle(String articleStr) {
        ArticleModel article = JsonUtils.jsonToPojo(articleStr, ArticleModel.class);
        article.setUser(CurrentUserUtils.getUser());
        ArticleModel articleModel = articleService.getById(article.getId());
        if(articleModel.getUser().getId() != CurrentUserUtils.getUser().getId()) {
            return ResultBean.fail("只能修改自己的文章!");
        }
        article.setUpdateTime(LocalDateTime.now());
        articleService.updateById(article );
        return ResultBean.success().putResult("articleId", article.getId());
    }
    
    @SysLog("删除文章")
    @ApiOperation("删除文章")
    @ResponseBody
    @DeleteMapping("/article/{id}")
    public ResultBean deleteArticle(@PathVariable("id") Integer id) {
        ArticleModel articleModel = articleService.getById(id);
        if(articleModel.getUser().getId() != CurrentUserUtils.getUser().getId()) {
            return ResultBean.fail("只能删除自己的文章!");
        }
        articleService.removeById(id);
        return ResultBean.success("删除成功!");
    }
    
    @SysLog("修改用户信息")
    @ApiOperation("修改用户信息")
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
    
    @SysLog("发布评论")
    @ApiOperation("发布评论")
    @ResponseBody
    @PostMapping("/comment/publish")
    public ResultBean commentPublish(CommentModel comment) {
        UserModel user = CurrentUserUtils.getUser();
        comment.setUserId(user.getId());
        commentService.save(comment);
        messageService.handle(comment);
        return ResultBean.success().putResult("comment", new CommentDo(comment, user));
    }
   
    @SysLog("删除评论")
    @ApiOperation("删除评论")
    @ResponseBody
    @DeleteMapping("/comment/{id}")
    public ResultBean removeMsg(@PathVariable Integer id) {
        if(CurrentUserUtils.getUserId() != commentService.getById(id).getUserId()) {
            return ResultBean.fail("只能删除自己的评论!");
            
        }
        commentService.removeCascadeById(id);
        return ResultBean.success("删除成功！");
    }
    
}
