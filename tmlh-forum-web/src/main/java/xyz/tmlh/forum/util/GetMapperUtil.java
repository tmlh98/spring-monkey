package xyz.tmlh.forum.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

import xyz.tmlh.forum.web.controller.IndexController;

/**
 * <p>
 *    获取@GetMapper 的值
 * </p>
 *
 * @author TianXin
 * @since 2019年4月1日下午6:50:28
 */
public class GetMapperUtil {

    /**
     * 获取类方法所以@GetMapper 的value值
     * @author TianXin
     * @created 2019年4月2日 上午9:58:34
     * @return
     */
    public static List<String> getGetMapperValue() {
        List<String> urls = new ArrayList<>();
        Class<IndexController> clazz = IndexController.class;
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            GetMapping mapping = method.getAnnotation(GetMapping.class);
            if(mapping != null) {
                urls.addAll(Arrays.asList(mapping.value()));
            }
        }
        return urls;
    }
}
