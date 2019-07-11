package xyz.tmlh.forum.core.service;

import xyz.tmlh.forum.core.model.CommentModel;
import xyz.tmlh.forum.core.model.MessageModel;
import xyz.tmlh.forum.core.model.SocialModel;
import xyz.tmlh.forum.core.model.data.MessageDo;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author TianXin
 * @since 2019-05-08
 */
public interface MessageService extends IService<MessageModel> {

    /**
      * 处理评论文章消息
      * @param @param comment    参数
      * @return void    返回类型
      * @throws
      */
    void handle(CommentModel comment);

    /**
      * 处理关注的消息
      * @param @param social    参数
      * @return void    返回类型
      * @throws
      */
    void handle(SocialModel social);

    /**
      * 自定义查询全部消息方法
      * @param @param wrapper
      * @param @return    参数
      * @return List<MessageDo>    返回类型
      * @throws
      */
    List<MessageDo> findList(Wrapper<MessageModel> wrapper);

    
    
}
