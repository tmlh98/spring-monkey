package xyz.tmlh.core.model.data;

import com.fasterxml.jackson.annotation.JsonFormat;

import xyz.tmlh.core.enums.MessageType;
import xyz.tmlh.core.suport.CharacterConstans;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 消息载体
 * </p>
 *
 * @author TianXin
 * @since 2019-05-08
 */
public class MessageDo implements Serializable {

    private static final long serialVersionUID = -1047791147959551617L;

    /**
     * 消息id
     */
    private Integer id;

    private String content;

    /**
     * 发送者用户id
     */
    private Integer sender;

    /**
     * 发送者用户名
     */
    private String senderName;

    /**
     * 发送者用户名
     */
    private String senderImageUrl;

    /**
     * 接收者用户头像
     */
    private Integer receiver;

    /**
     * 接收者用户名
     */
    private String receiverName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime;

    private MessageType type;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public String getDetail() {
        String detail = "";
        if (type == MessageType.ATTENTION) {
            detail = CharacterConstans.aLabel("/user/" + sender, senderName) + "关注了你!";
        } else if (type == MessageType.COMMENT_ARTICLE) {
            detail = CharacterConstans.aLabel("/user/" + sender, senderName) + "回复了你的文章" + content;
        } else if (type == MessageType.COMMENT_REPLY) {
            detail = CharacterConstans.aLabel("/user/" + sender, senderName) + "回复了你的评论" + content;
        }
        return detail;
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

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getSenderImageUrl() {
        return senderImageUrl;
    }

    public void setSenderImageUrl(String senderImageUrl) {
        this.senderImageUrl = senderImageUrl;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

}
