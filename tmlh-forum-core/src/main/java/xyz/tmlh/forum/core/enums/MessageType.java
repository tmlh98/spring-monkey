package xyz.tmlh.forum.core.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * <p>
 *  消息类型
 * </p>
 *
 * @author TianXin
 * @since 2019-04-02
 */
public enum MessageType {

    COMMENT_ARTICLE("COMMENT_ARTICLE", "评论 文章"), 
    COMMENT_REPLY("COMMENT_REPLY", "评论 回复"), 
    ATTENTION("ATTENTION", "关注");

    @EnumValue // 标记数据库存的值
    private final String code;
    private final String desc;
    
    private MessageType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public String getCode() {
        return code;
    }
    public String getDesc() {
        return desc;
    }

   

}
