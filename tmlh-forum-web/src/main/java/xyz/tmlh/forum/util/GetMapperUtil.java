package xyz.tmlh.forum.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import xyz.tmlh.forum.web.controller.ArticleController;
import xyz.tmlh.forum.web.controller.IndexController;
import xyz.tmlh.forum.web.controller.user.UserDataController;

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
     * 获取RequestMapper's url
     * @author TianXin
     * @created 2019年4月2日 上午9:58:34
     * @return
     */
    public static List<String> getMapperValue() {
        List<String> urls = getMapperValue(IndexController.class);
        urls.addAll(getMapperValue(ArticleController.class));
        urls.addAll(getMapperValue(UserDataController.class));
        return urls;
    }
    
    
    /**
     * 获取RequestMapper's url
     * @author TianXin
     * @created 2019年4月2日 上午9:58:34
     * @return
     */
    public static List<String> getMapperValue(Class<?> clazz) {
        List<String> urls = new ArrayList<>();
        RequestMapping requestMapping = clazz.getAnnotation(RequestMapping.class);
        String  prefixUrl= "";
        if(requestMapping != null) {
            String[] typeUrls = requestMapping.value();
            prefixUrl = typeUrls[0];
        }
        Method[] methods = clazz.getMethods();
        for (Method method : methods) {
            GetMapping mapping = method.getAnnotation(GetMapping.class);
            if(mapping != null) {
                String[] methodUrls = mapping.value();
                for (String methodUrl : methodUrls) {
                    urls.add(prefixUrl + methodUrl);
                }
            }
        }
        return urls;
    }
    
    
}
