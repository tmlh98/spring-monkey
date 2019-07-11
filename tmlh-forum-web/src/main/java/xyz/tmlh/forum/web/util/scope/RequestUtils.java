package xyz.tmlh.forum.web.util.scope;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * <p>
 *  获取request的工具   
 * </p>
 *
 * @author TianXin
 * @since 2019年3月26日下午4:30:58
 */
public class RequestUtils {

	public static HttpServletRequest getHttpServletRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}
	
	public static ServletWebRequest getServletWebRequest() {
	    return new ServletWebRequest(getHttpServletRequest());
	}
	
	
}
