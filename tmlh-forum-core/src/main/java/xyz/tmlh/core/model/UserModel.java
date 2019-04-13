package xyz.tmlh.core.model;

import com.baomidou.mybatisplus.annotation.TableName;

import xyz.tmlh.core.enums.StatusEnum;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author TianXin
 * @since 2019-04-01
 */
@TableName("tbl_user")
public class UserModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户id
     */
    @TableId(value = "id", type = IdType.AUTO)
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
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 最后一次登录时间
     */
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
    public UserModel(Integer id) {
        this.id = id;
    } 
    public UserModel() {
    } 
    
    public UserModel(Integer id, LocalDateTime lastLogin) {
        super();
        this.id = id;
        this.lastLogin = lastLogin;
    }
    public UserModel(String userconnectionId, String username, String imageUrl, LocalDateTime lastLogin, String source, String detail, String gender) {
        super();
        this.userconnectionId = userconnectionId;
        this.username = username;
        this.imageUrl = imageUrl;
        this.lastLogin = lastLogin;
        this.source = source;
        this.detail = detail;
        this.gender = gender;
    }
    public UserModel(String userconnectionId, String username, String imageUrl, LocalDateTime lastLogin, String source, String detail, String gender, String email) {
        super();
        this.userconnectionId = userconnectionId;
        this.username = username;
        this.imageUrl = imageUrl;
        this.lastLogin = lastLogin;
        this.source = source;
        this.detail = detail;
        this.detail = detail;
        this.email = email;
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
        return  signature;
    }

    public void setSignature(String signature) {
        this. signature =  signature;
    }
    

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

}