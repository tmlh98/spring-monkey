package xyz.tmlh.forum.web.log;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import xyz.tmlh.forum.core.mapper.SysLogMapper;
import xyz.tmlh.forum.core.model.SysLogModel;
import xyz.tmlh.forum.web.util.ip.IPUtils;
import xyz.tmlh.forum.web.util.scope.RequestUtils;
import xyz.tmlh.security.browser.log.ISysLogTemplate;
import xyz.tmlh.security.browser.log.LocalLogExecutor;

/**
 * <p>
 *    处理系统日志
 * </p>
 *
 * @author TianXin
 * @since 2019年7月11日下午12:37:34
 */
@Component
public class SysLogExecutor implements LocalLogExecutor{
    
    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void saveLog(ISysLogTemplate sysLog) {
        SysLogModel log = new SysLogModel();
        //获取request
        HttpServletRequest request = RequestUtils.getHttpServletRequest();
        //设置IP地址
        log.setIp(IPUtils.getIpAddr(request));
        log.setUrl(request.getRequestURI());
        
        
        log.setCreateTime(sysLog.getCreateTime());
        log.setOperation(sysLog.getDescription());
        log.setTime(sysLog.getExecuteTime());
        log.setMethod(sysLog.getMethodName());
        log.setParams(sysLog.getParams());
        
        sysLogMapper.insert(log);
        
    }

}
