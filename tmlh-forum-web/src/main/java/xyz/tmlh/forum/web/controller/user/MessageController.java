package xyz.tmlh.forum.web.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import xyz.tmlh.forum.core.enums.MessageStatus;
import xyz.tmlh.forum.core.model.MessageModel;
import xyz.tmlh.forum.core.model.data.MessageDo;
import xyz.tmlh.forum.core.service.MessageService;
import xyz.tmlh.forum.web.util.user.CurrentUserUtils;
import xyz.tmlh.security.browser.suport.ResultBean;

/**
 * <p>
 *    
 * </p>
 *
 * @author TianXin
 * @since 2019年5月12日下午4:34:06
 */
@Api("消息推送服务")
@PreAuthorize("hasRole('ROLE_USER')")
@RequestMapping("/user/message")
@RestController
public class MessageController {
    
    @Autowired
    private MessageService messageService;

    @ApiOperation("查询当前用户未读消息数")
    @GetMapping("/count")
    public ResultBean notifyMsg() {
        LambdaQueryWrapper<MessageModel> wrapper = new LambdaQueryWrapper<MessageModel>();
        wrapper.eq(MessageModel::getReceiver, CurrentUserUtils.getUserId())
               .eq(MessageModel::getStatus, MessageStatus.UNREAD)
               .orderByAsc(MessageModel::getCreateTime);
        
        int count = messageService.count(wrapper );
        return ResultBean.success("你收到"+count+"条消息!").putResult("length", count);
    }
    
    @ApiOperation("查询当前用户全部消息列表")
    @GetMapping("/list")
    public ResultBean list() {
        LambdaQueryWrapper<MessageModel> wrapper = new LambdaQueryWrapper<MessageModel>();
        wrapper.eq(MessageModel::getReceiver, CurrentUserUtils.getUserId())
               .orderByDesc(MessageModel::getCreateTime);
        
        List<MessageDo> messageList = messageService.findList(wrapper );
        
        return ResultBean.success().putResult("messageList", messageList);
    }
    
    @ApiOperation("读取消息")
    @PutMapping("/read")
    public ResultBean readMsg() {
        LambdaQueryWrapper<MessageModel> wrapper = new LambdaQueryWrapper<MessageModel>();
        wrapper.eq(MessageModel::getReceiver, CurrentUserUtils.getUserId())
               .eq(MessageModel::getStatus, MessageStatus.UNREAD);
        
        messageService.update(new MessageModel(MessageStatus.INREAD), wrapper);
        return ResultBean.success();
    }
    
}
