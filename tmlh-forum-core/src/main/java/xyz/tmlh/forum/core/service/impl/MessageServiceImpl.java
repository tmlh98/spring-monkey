package xyz.tmlh.forum.core.service.impl;

import xyz.tmlh.forum.core.enums.MessageType;
import xyz.tmlh.forum.core.mapper.MessageMapper;
import xyz.tmlh.forum.core.model.ArticleModel;
import xyz.tmlh.forum.core.model.CommentModel;
import xyz.tmlh.forum.core.model.MessageModel;
import xyz.tmlh.forum.core.model.SocialModel;
import xyz.tmlh.forum.core.model.data.MessageDo;
import xyz.tmlh.forum.core.service.ArticleService;
import xyz.tmlh.forum.core.service.CommentService;
import xyz.tmlh.forum.core.service.MessageService;
import xyz.tmlh.forum.core.suport.CharacterConstans;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author TianXin
 * @since 2019-05-08
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, MessageModel> implements MessageService {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    
    @Override
    public void handle(CommentModel comment) {
        //评论回复
        ArticleModel articleModel = articleService.getById(comment.getArticleId());
        String title = articleModel.getTitle();
        String content = "<a href='article/"+articleModel.getId()+"'>"+CharacterConstans.LT2
            +title+ CharacterConstans.GT2  +"</a>";
        MessageType type;
        Integer receiver = null;
        if(comment.getCommentId() == null) {
            type = MessageType.COMMENT_ARTICLE;
            receiver = articleModel.getUser().getId();
        }else {
            type = MessageType.COMMENT_REPLY;
            receiver = commentService.getById(comment.getCommentId() ).getUserId();
        }
        
        baseMapper.insert(new MessageModel(content, comment.getUserId(),receiver, type));
    }

    @Override
    public void handle(SocialModel social) {
        String content = "";
        baseMapper.insert(new MessageModel(content, social.getUserId(),social.getFollow(), MessageType.ATTENTION));

    }

    @Override
    public List<MessageDo> findList(Wrapper<MessageModel> wrapper) {
        return baseMapper.selectDoList(wrapper);
    }

    

}
