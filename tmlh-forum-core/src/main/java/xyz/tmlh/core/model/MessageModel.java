package xyz.tmlh.core.model;

import com.baomidou.mybatisplus.annotation.TableName;

import xyz.tmlh.core.enums.MessageStatus;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *  消息Model
 * </p>
 *
 * @author TianXin
 * @since 2019-05-08
 */
@TableName("tbl_message")
public class MessageModel implements Serializable {

    private static final long serialVersionUID = -1047791147959554617L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String content;

    /**
     * 发送者用户id
     */
    private Integer sender;

    /**
     * 接收者用户id
     */
    private Integer receiver;

    /**
     * 0 ：未读，1:以读
     */
    private MessageStatus status;
    
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;
    
    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }

    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

}
