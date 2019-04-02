package xyz.tmlh.core.handler;
import java.time.LocalDateTime;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

/**
 * <p>
 * Title: MyMetaObjectHandler
 * </p>
 * <p>
 * Description:自动填充
 * </p>
 * 
 * @author TianXin
 * @created 2019年2月25日 下午1:39:22
 * @modified [who date description]
 * @check [who date description]
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    
    @Override
    public void insertFill(MetaObject metaObject) {
        Object createTime = getFieldValByName("createTime", metaObject);
        if(createTime == null) {
            this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        }
    }
    
    @Override
    public void updateFill(MetaObject metaObject) {
        Object updateTime = getFieldValByName("updateTime", metaObject);
        if(updateTime == null) {
            this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
        }
    }

}