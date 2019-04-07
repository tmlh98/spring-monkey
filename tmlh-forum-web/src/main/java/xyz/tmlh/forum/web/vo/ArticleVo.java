package xyz.tmlh.forum.web.vo;

import org.springframework.beans.BeanUtils;

import xyz.tmlh.core.enums.PublishType;
import xyz.tmlh.core.model.ArticleModel;
import xyz.tmlh.core.model.UserModel;
import xyz.tmlh.forum.util.LocalDateTimeUtil;

/**
 * <p>
 *    文章详情页面vo
 * </p>
 *
 * @author TianXin
 * @since 2019年4月5日下午9:57:01
 */
public class ArticleVo {
    
    private Integer id;

    /**
     * 用户id，外键
     */
    private Integer userId;

    /**
     * 文章分类
     */
    private String catalogName;
    
    /**
     * 发布类型
     */
    private PublishType publishType;

    /**
     * 标题
     */
    private String title;

    /**
     * 关键字
     */
    private String keywords;

    /**
     * 描述
     */
    private String description;

    /**
     * 内容
     */
    private String content;

    /**
     * 点击量
     */
    private Integer clickNum;

    /**
     * 发表时间
     */
    private Long createTime;

    /**
     * 修改时间
     */
    private Long updateTime;
    
    
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

    public ArticleVo(ArticleModel article, UserModel user) {
        BeanUtils.copyProperties(user, this);
        BeanUtils.copyProperties(article, this);
        this.createTime = LocalDateTimeUtil.toTimestamp(article.getCreateTime());
        this.updateTime = LocalDateTimeUtil.toTimestamp(article.getUpdateTime());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public PublishType getPublishType() {
        return publishType;
    }

    public void setPublishType(PublishType publishType) {
        this.publishType = publishType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getClickNum() {
        return clickNum;
    }

    public void setClickNum(Integer clickNum) {
        this.clickNum = clickNum;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
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

     
    
    
}
