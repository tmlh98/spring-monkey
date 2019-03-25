package xyz.tmlh.security.common.base;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;


/**  
 * Created by TianXin on 2018年12月26日. 
 */
public class BaseEntity implements Serializable{
    
    private static final long serialVersionUID = -2920949355251635613L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Integer id;
    
    /**
     * 创建时间
     */
    private Date createTime;

     
    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Date getCreateTime() {
        return createTime;
    }


    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "BaseEntity [id=" + id + ", createTime=" + createTime + "]";
    }
    

}
