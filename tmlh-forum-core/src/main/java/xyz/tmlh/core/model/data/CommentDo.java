package xyz.tmlh.core.model.data;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import xyz.tmlh.core.model.CommentModel;
import xyz.tmlh.core.model.UserModel;

/**
 * <p>
 *    评论DO
 * </p>
 *
 * @author TianXin
 * @since 2019年4月6日下午4:07:15
 */
public class CommentDo implements Serializable{

    private static final long serialVersionUID = -2557615099998143725L;

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

    public CommentDo() {
        super();
    }
    
    
    public CommentDo(CommentModel comment ,UserModel user) {
        BeanUtils.copyProperties(comment, this);
        this.userId = user.getId();
        this.userImageUrl = user.getImageUrl();
        this.username = user.getUsername();
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

    
}
