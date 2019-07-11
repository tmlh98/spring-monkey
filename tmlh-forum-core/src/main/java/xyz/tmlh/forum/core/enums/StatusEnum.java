package xyz.tmlh.forum.core.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * <p>
 *  描述用户状态
 * </p>
 *
 * @author TianXin
 * @since 2019-04-02
 */
public enum StatusEnum {

    NORMAL(0 , "正常 "),
    FREEZE(1 , "冻结 "),
    CANCEL (2 , "注销 ");
    
    @EnumValue//标记数据库存的值
    private final int code;
    private final String desc;
    
    private StatusEnum(int code, String desc) {
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
