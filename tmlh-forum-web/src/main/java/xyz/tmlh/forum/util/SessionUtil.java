package xyz.tmlh.forum.util;

import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;

/**
 * <p>
 *    操作session
 * </p>
 *
 * @author TianXin
 * @since 2019年4月1日下午8:31:38
 */
public class SessionUtil {
    
    /**
     * 操作session的工具类
     */
    private static SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    
    public static void setAttribute(String key , Object value) {
        sessionStrategy.setAttribute(RequestUtils.getServletWebRequest(), key, value);
    }
    
    
    public static Object getAttribute(String key) {
        return sessionStrategy.getAttribute(RequestUtils.getServletWebRequest(), key);
    }
    
    public static void remove(String key) {
        sessionStrategy.removeAttribute(RequestUtils.getServletWebRequest(), key);
    }
    
    
    
}
