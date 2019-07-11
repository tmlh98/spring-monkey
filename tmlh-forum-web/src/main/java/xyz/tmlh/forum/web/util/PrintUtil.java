package xyz.tmlh.forum.web.util;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * <p>
 *  打印bean的工具类   
 * </p>
 *
 * @author TianXin
 * @since 2019年3月26日下午4:30:48
 */
public class PrintUtil {
    
    public static String printBean(Object obj){
        return ReflectionToStringBuilder.toString(obj, ToStringStyle.MULTI_LINE_STYLE);
    }
    
}