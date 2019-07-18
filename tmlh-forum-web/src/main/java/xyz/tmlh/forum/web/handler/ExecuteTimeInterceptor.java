package xyz.tmlh.forum.web.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * <p>
 *    接口执行时间监控
 * </p>
 *
 * @author TianXin
 * @since 2019年7月17日下午7:28:03
 */
public class ExecuteTimeInterceptor implements HandlerInterceptor {

    private final static Logger LOGGER = LoggerFactory.getLogger(ExecuteTimeInterceptor.class);

    private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("executeTime");

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        startTimeThreadLocal.set(System.currentTimeMillis());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
            Exception ex) {
        long currentTime = System.currentTimeMillis();
        long executeTime = currentTime - startTimeThreadLocal.get();

        LOGGER.info("请求：{} 执行了 {} 毫秒", request.getRequestURI(), executeTime);
    }

}