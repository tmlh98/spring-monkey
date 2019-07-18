package xyz.tmlh.forum.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import xyz.tmlh.forum.web.util.PrintUtil;

/**
 * <p>
 *  dug
 * </p>
 *
 * @author TianXin
 * @since 2019年7月17日下午7:33:06
 */
public class DebugInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(DebugInterceptor.class);

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        logger.info(PrintUtil.printBean(SecurityContextHolder.getContext().getAuthentication()));
    }

}
