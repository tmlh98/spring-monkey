package xyz.tmlh.forum.web.controller.vo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import xyz.tmlh.forum.core.model.data.CommentDo;

/**
 * <p>
 *  用户评论表
 * </p>
 *
 * @author TianXin
 * @since 2019-04-06
 */
public class CommentVo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 文章id
     */
    private Integer articleId;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 创建时间
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    /**
     * 评论id
     */
    private Integer commontId;
    
    /**
     * 用户id 
     */
    private Integer userId;
    
    /**
     * 用户头像
     */
    private String userImageUrl;
    
    /**
     * 用户名
     */
    private String username;
    
    private List<CommentDo> commentChildList;

    
    public CommentVo() {
        super();
    }

    public CommentVo(CommentDo comment , List<CommentDo> commentChildList) {
        BeanUtils.copyProperties(comment , this);
        this.commentChildList = commentChildList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public Integer getCommontId() {
        return commontId;
    }

    public void setCommontId(Integer commontId) {
        this.commontId = commontId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<CommentDo> getCommentChildList() {
        return commentChildList;
    }

    public void setCommentChildList(List<CommentDo> commentChildList) {
        this.commentChildList = commentChildList;
    }

    
    
     
}
