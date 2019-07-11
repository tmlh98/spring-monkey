package xyz.tmlh.security.browser.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.event.EventListener;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * <p>
 *    注解形式的监听 异步监听日志事件
 * </p>
 *
 * @author TianXin
 * @since 2019年7月11日上午11:31:26
 */
@ConditionalOnBean(LocalLogExecutor.class)
@Component
public class SysLogListener {


    @Autowired
    private LocalLogExecutor localLogExecutor;
    
    @Async
    @Order
    @EventListener(SysLogEvent.class)
    public void saveSysLog(SysLogEvent event) {
        ISysLogTemplate sysLog = (ISysLogTemplate)event.getSource();
        localLogExecutor.saveLog(sysLog);
    }
}