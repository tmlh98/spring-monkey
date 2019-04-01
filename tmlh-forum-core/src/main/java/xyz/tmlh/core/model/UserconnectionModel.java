package xyz.tmlh.core.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

/**
 * <p>
 *  社交用户信息表
 * </p>
 *
 * @author TianXin
 * @since 2019-04-01
 */
@TableName("tbl_userconnection")
public class UserconnectionModel implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识
     */
    @TableId(value = "userId", type = IdType.AUTO)
    private String userId;

    /**
     * 社交平台 (qq ,github)
     */
    @TableField("providerId")
    private String providerId;

    @TableField("providerUserId")
    private String providerUserId;

    private Integer rank;

    @TableField("displayName")
    private String displayName;

    @TableField("profileUrl")
    private String profileUrl;

    @TableField("imageUrl")
    private String imageUrl;

    @TableField("accessToken")
    private String accessToken;

    private String secret;

    @TableField("refreshToken")
    private String refreshToken;

    @TableField("expireTime")
    private Long expireTime;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public String getProviderUserId() {
        return providerUserId;
    }

    public void setProviderUserId(String providerUserId) {
        this.providerUserId = providerUserId;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Long expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        return "UserconnectionModel{" +
        "userId=" + userId +
        ", providerId=" + providerId +
        ", providerUserId=" + providerUserId +
        ", rank=" + rank +
        ", displayName=" + displayName +
        ", profileUrl=" + profileUrl +
        ", imageUrl=" + imageUrl +
        ", accessToken=" + accessToken +
        ", secret=" + secret +
        ", refreshToken=" + refreshToken +
        ", expireTime=" + expireTime +
        "}";
    }
}
