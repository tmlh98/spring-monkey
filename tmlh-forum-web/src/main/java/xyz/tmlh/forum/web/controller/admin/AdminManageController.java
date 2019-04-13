package xyz.tmlh.forum.web.controller.admin;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import xyz.tmlh.core.enums.PublishType;
import xyz.tmlh.core.enums.StatusEnum;
import xyz.tmlh.core.model.ArticleModel;
import xyz.tmlh.core.model.CommentModel;
import xyz.tmlh.core.model.UserModel;
import xyz.tmlh.core.model.data.CommentDo;
import xyz.tmlh.core.service.ArticleService;
import xyz.tmlh.core.service.CommentService;
import xyz.tmlh.core.service.SocialService;
import xyz.tmlh.core.service.UserService;
import xyz.tmlh.forum.web.controller.vo.UserVo;
import xyz.tmlh.security.browser.suport.ResultBean;

/**
 * <p>
 *    
 * </p>
 *
 * @author TianXin
 * @since 2019年4月14日上午1:37:55
 */
@Api("系统管理")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/admin")
@RestController
public class AdminManageController {

    
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminManageController.class);


    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @Autowired
    private SocialService socialService;

    @ApiOperation("用户列表搜索")
    @GetMapping("/user/page")
    public ResultBean userPage(@RequestParam(defaultValue="1")int currPage ,@RequestParam(defaultValue="10") int pageSize,
            @RequestParam(required=false)String username,@RequestParam(required=false)String source) {
        LOGGER.info("search condtion ,username: {} ,source: {} " , username , source);
        IPage<UserModel> page = new Page<>(currPage, pageSize);
        LambdaQueryWrapper<UserModel> wapper = new LambdaQueryWrapper<UserModel>();
        if(StringUtils.isNotBlank(username)  ) {
            wapper.like(UserModel::getUsername, username);
        }
        if(StringUtils.isNotBlank(source )) {
            wapper.eq(UserModel::getSource, source);
        }
        wapper.orderByDesc(UserModel::getCreateTime);
        
        IPage<UserModel> userPage = userService.page(page ,wapper);
        List<UserVo> userVos = userPage.getRecords().stream().map(u -> {
            UserVo userVo = new UserVo(u);
            userVo.setFansCount( socialService.selectFansCount(u.getId()));
            userVo.setArticleCount(articleService.selectByUser(u.getId(), null));
            return userVo;
        }).collect(Collectors.toList());
        IPage<UserVo> userVoPage = new Page<>();
        BeanUtils.copyProperties(userPage, userVoPage);
        userVoPage.setRecords(userVos);
        return ResultBean.success().putResult("userPage", userVoPage);
    }
    
    @ApiOperation("用户冻结或解冻")
    @PutMapping("/user/freeze/{id}")
    public ResultBean userFreeze(@PathVariable Integer id , StatusEnum statusEnum) {
        Assert.notNull(id, "id is null");
        LOGGER.info("useriId : {} , statusEnum: {}" , id ,statusEnum);
        UserModel userModel = new UserModel(id);
        userModel.setState(statusEnum);
        userService.updateById(userModel);
        return ResultBean.success();
    }
    
    
    @ApiOperation("文章列表搜索")
    @GetMapping("/article/page")
    public ResultBean articlePage(@RequestParam(defaultValue="1")int currPage ,@RequestParam(defaultValue="10") int pageSize,
            @RequestParam(required=false) String username,@RequestParam(required=false)String title ,
        @RequestParam(required=false) PublishType publishType) {
        ResultBean resultBean = new ResultBean();
        IPage<ArticleModel> page = new Page<>(currPage, pageSize);
        QueryWrapper<ArticleModel> wapper = new QueryWrapper<ArticleModel>();
        if(StringUtils.isNotBlank(title) ) {
            wapper.like("acl.title", title);
        }
        if(publishType != null) {
            wapper.like("acl.publish_type", publishType);
        }
        if(StringUtils.isNotBlank(username)) {
            wapper.like("u.username", username);
        }
        wapper.orderByDesc("acl.create_time");
        IPage<ArticleModel> articlePage = articleService.selectUserPage(page ,wapper);
        resultBean.putResult("articlePage", articlePage);
        return resultBean;
    }
    
    @ApiOperation("文章列表删除")
    @DeleteMapping("/article/{id}")
    public ResultBean articleRemove(@PathVariable Integer id) {
        Assert.notNull(id, "id is null");
        articleService.removeById(id);
        return ResultBean.success("删除成功!");
    }
    
    @ApiOperation("评论列表搜索")
    @GetMapping("/comment/page")
    public ResultBean commentPage(@RequestParam(defaultValue="1")int currPage ,@RequestParam(defaultValue="10") int pageSize,
        @RequestParam(required=false) String username,@RequestParam(required=false)String content) {
        ResultBean resultBean = new ResultBean();
        IPage<CommentModel> page = new Page<>(currPage, pageSize);
        QueryWrapper<CommentModel> wapper = new QueryWrapper<CommentModel>();
        if(StringUtils.isNotBlank(username)) {
            wapper.like("u.username", username);
        }
        if(StringUtils.isNotBlank(content)) {
            wapper.like("com.content", content);
        }
        wapper.orderByDesc("com.create_time");
        IPage<CommentDo> commentPage = commentService.findPage(page, wapper);
        resultBean.putResult("commentPage", commentPage);
        return resultBean;
    }
    
    @ApiOperation("评论列表删除")
    @DeleteMapping("/comment/{id}")
    public ResultBean commentRemove(@PathVariable Integer id) {
        Assert.notNull(id, "id is null");
        commentService.removeById(id);
        return ResultBean.success("删除成功!");
    }
    
    
}
