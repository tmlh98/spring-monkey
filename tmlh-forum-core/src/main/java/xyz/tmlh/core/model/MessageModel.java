package xyz.tmlh.core.model;

import com.baomidou.mybatisplus.annotation.TableName;

import xyz.tmlh.core.enums.MessageStatus;
import xyz.tmlh.core.enums.MessageType;

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

    /**
     * 内容
     */
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
    private MessageType type;
    
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

    
    public MessageModel() {
        super();
    }
    public MessageModel(MessageStatus status) {
        super();
        this.status = status;
    }

    public MessageModel(String content, Integer sender, Integer receivere) {
        super();
        this.content = content;
        this.sender = sender;
        this.receiver = receivere;
    }
    
    public MessageModel(String content, Integer sender, Integer receiver, MessageType type) {
        super();
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.type = type;
    }

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

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    
}
