package xyz.tmlh.security.browser.log;

import org.springframework.context.ApplicationEvent;

/**
 * <p>
 *    
 * </p>
 *
 * @author TianXin
 * @since 2019年7月11日上午11:29:54
 */
public class SysLogEvent extends ApplicationEvent{
    
    private static final long serialVersionUID = -5421370820213016057L;

    /** 
     * <p>Title: </p> 
     * <p>Description: </p> 
     * @param sysLog 
     */
    public SysLogEvent(ISysLogTemplate sysLog) {
        super(sysLog);
    }

}
