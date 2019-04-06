package xyz.tmlh.core.model;

import com.baomidou.mybatisplus.annotation.TableName;

import xyz.tmlh.core.enums.PublishType;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 *  文章
 * </p>
 *
 * @author TianXin
 * @since 2019-04-01
 */
@TableName(value="tbl_article" , resultMap="xyz.tmlh.core.mapper.ArticleMapper.articleMap")
public class ArticleModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id，外键
     */
    @TableField(el="user.id")
    private UserModel user;

    /**
     * 文章分类
     */
    @TableField(el="catalog.id")
    private CatalogModel catalog;
    
    /**
     * 文章分类
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
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    public ArticleModel() {
        super();
    }
    
    public ArticleModel(Integer id, Integer clickNum) {
        super();
        this.id = id;
        this.clickNum = clickNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

 
    public CatalogModel getCatalog() {
        return catalog;
    }

    public void setCatalog(CatalogModel catalog) {
        this.catalog = catalog;
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
    
    

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public PublishType getPublishType() {
        return publishType;
    }

    public void setPublishType(PublishType publishType) {
        this.publishType = publishType;
    }

    @Override
    public String toString() {
        return "ArticleModel [id=" + id + ", user=" + user + ", catalog=" + catalog + ", publishType=" + publishType + ", title=" + title
            + ", keywords=" + keywords + ", description=" + description + ", content=" + content + ", clickNum=" + clickNum + ", createTime=" + createTime
            + ", updateTime=" + updateTime + "]";
    }

    
}
