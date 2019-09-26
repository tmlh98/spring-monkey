package xyz.tmlh.forum.web.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import xyz.tmlh.forum.core.model.SocialModel;
import xyz.tmlh.forum.core.service.MessageService;
import xyz.tmlh.forum.core.service.SocialService;
import xyz.tmlh.forum.web.util.user.CurrentUserUtils;
import xyz.tmlh.security.browser.log.SysLog;
import xyz.tmlh.security.browser.support.ResultBean;

/**
 * <p>
 *    用户关系
 * </p>
 *
 * @author TianXin
 * @since 2019年4月7日下午12:45:42
 */
@Api("用户关系控制器")
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/user/social")
@RestController
public class UserSocialController {
    
    @Autowired
    private SocialService socialService;
    
    @Autowired
    private MessageService messageService;

    
    @SysLog("关注一个用户")
    @ApiOperation(value = "关注一个用户" )
    @PostMapping("/{id}")
    public ResultBean follweUser(@ApiParam("被关注的用户id")@PathVariable("id")Integer id) {
        if(CurrentUserUtils.getUser().getId() == id) {
            return ResultBean.fail("不能关注自己");
        }
        
        if(socialService.checkFollwe(id)) {
            return ResultBean.fail("你已关注当前用户!");
        }
        
        SocialModel social = new SocialModel(CurrentUserUtils.getUser().getId(), id);
        socialService.save(social);
        
        messageService.handle(social);
        return ResultBean.success("关注成功!");
    }
    
    @SysLog("取消关注一个用户")
    @ApiOperation(value = "取消关注一个用户" )
    @DeleteMapping("/{id}")
    public ResultBean unFollweUser(@ApiParam("取消关注的用户id")@PathVariable("id")Integer id) {
        LambdaQueryWrapper<SocialModel> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SocialModel::getUserId, CurrentUserUtils.getUser().getId());
        queryWrapper.eq(SocialModel::getFollow, id);
        socialService.remove(queryWrapper );
        return ResultBean.success("取消成功!");
    }
    
    
}
