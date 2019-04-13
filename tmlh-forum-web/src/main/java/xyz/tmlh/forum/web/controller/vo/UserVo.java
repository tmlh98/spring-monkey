package xyz.tmlh.forum.web.controller.vo;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.beans.BeanUtils;

import com.fasterxml.jackson.annotation.JsonFormat;

import xyz.tmlh.core.enums.StatusEnum;
import xyz.tmlh.core.model.UserModel;

/**
 * <p>
 *    用户列表展式
 * </p>
 *
 * @author TianXin
 * @since 2019年4月13日下午8:26:47
 */
public class UserVo implements Serializable{
    
    private static final long serialVersionUID = 8841491573292012677L;

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 社交账户userId
     */
    private String userconnectionId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户邮箱
     */
    private String email;

    /**
     * 头像
     */
    private String imageUrl;

    /**
     * 注册时间
     */
    private LocalDateTime createTime;

    /**
     * 最后一次登录时间
     */
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastLogin;

    /**
     * 用户状态  0:正常 1:冻结 2:注销
     */
    private StatusEnum state;

    /**
     * 来源
     */
    private String source;

    /**
     * 信息
     */
    private String detail;

    /**
     * 签名
     */
    private String signature;
    /**
     *  性别。 如果获取不到则默认返回”男”
     */
    private String gender;
    
    private Integer fansCount;
    
    private Integer articleCount;

    public UserVo(UserModel u) {
        BeanUtils.copyProperties(u, this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserconnectionId() {
        return userconnectionId;
    }

    public void setUserconnectionId(String userconnectionId) {
        this.userconnectionId = userconnectionId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public StatusEnum getState() {
        return state;
    }

    public void setState(StatusEnum state) {
        this.state = state;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getFansCount() {
        return fansCount;
    }

    public void setFansCount(Integer fansCount) {
        this.fansCount = fansCount;
    }


    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }
    
    
    
    
}
