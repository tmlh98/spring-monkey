package xyz.tmlh.core.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 *      社交Model
 * </p>
 *
 * @author TianXin
 * @since 2019-04-07
 */
@TableName(value = "tbl_social")
public class SocialModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    
    private Integer userId;

    /**
     * 关联的用户
     */
    private Integer follow;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    public SocialModel(Integer userId, Integer follow) {
        super();
        this.userId = userId;
        this.follow = follow;
    }
    
    public SocialModel() {
        super();
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

    public Integer getFollow() {
        return follow;
    }

    public void setFollow(Integer follow) {
        this.follow = follow;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

   

}
