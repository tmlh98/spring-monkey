package xyz.tmlh.core.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * <p>
 *  描述用户状态
 * </p>
 *
 * @author TianXin
 * @since 2019-04-02
 */
public enum PublishType {

    ARTICLE("article", "文章"),
    QUESTION("question" , "问答 ");
    
    @EnumValue//标记数据库存的值
    private final String value;
    private final String desc;
    
    private PublishType(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }
    
    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }
    
    
}
