package xyz.tmlh.forum.util;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * <p>
 * Title: ReflectionToStringUtil
 * </p>
 * <p>
 * Description: 打印bean的工具类
 * </p>
 * 
 * @author TianXin
 * @created 2019年3月5日 下午12:13:43
 * @modified [who date description]
 * @check [who date description]
 */
public class PrintUtil {
    
    public static String printBean(Object obj){
        return ReflectionToStringBuilder.toString(obj, ToStringStyle.MULTI_LINE_STYLE);
    }
    
}