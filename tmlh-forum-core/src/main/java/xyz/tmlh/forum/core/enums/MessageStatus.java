package xyz.tmlh.forum.core.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * <p>
 * 描述用户状态
 * </p>
 *
 * @author TianXin
 * @since 2019-04-02
 */
public enum MessageStatus {

    /**
     * 未读
     */
    UNREAD(0, "未读 "), 
    
    /**
     * 已读
     */
    INREAD(1, "已读");

    @EnumValue // 标记数据库存的值
    private final int code;
    private final String desc;

    private MessageStatus(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

}
