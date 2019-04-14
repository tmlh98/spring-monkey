package xyz.tmlh.forum.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import xyz.tmlh.core.model.SysLogModel;
import xyz.tmlh.core.service.SysLogService;
import xyz.tmlh.forum.annotation.SysLog;
import xyz.tmlh.forum.util.ip.IPUtils;
import xyz.tmlh.forum.util.scope.RequestUtils;
import xyz.tmlh.forum.util.user.CurrentUserUtils;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;


/**
 * 系统日志，切面处理类
 */
@Aspect
@Component
public class SysLogAspect {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SysLogAspect.class);

    private ThreadLocal<Long> startTime = new ThreadLocal<>();
    
    @Autowired
    private SysLogService sysLogService;
	
	@Pointcut("@annotation(xyz.tmlh.forum.annotation.SysLog)")
	public void logPointCut() { 
		
	}

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
	    startTime.set(System.currentTimeMillis());
		//执行方法
		Object result = point.proceed();
		//执行时长(毫秒)
		long time = System.currentTimeMillis() - startTime.get();

		//保存日志
		saveSysLog(point, time);

		return result;
	}

	private void saveSysLog(ProceedingJoinPoint joinPoint, long time) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		SysLog log = method.getAnnotation(SysLog.class);
		
		SysLogModel sysLog = new SysLogModel();
		
		if(log != null){
		  //注解上的描述
            sysLog.setOperation(log.value());
		}
		
		if(CurrentUserUtils.isExistUser()) {
		    sysLog.setUserId(CurrentUserUtils.getUserId());
		}

		//请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();

		sysLog.setMethod(className + "." + methodName + "()");
		//请求的参数
		Object[] args = joinPoint.getArgs();
		try{
			//保存全部参数
			String params = new Gson().toJson(args);
			sysLog.setParams(params);
		}catch (Exception e){
		    LOGGER.info(e.getLocalizedMessage() ,e);
		}
		sysLog.setCreateTime(LocalDateTime.now());
		//获取request
        HttpServletRequest request = RequestUtils.getHttpServletRequest();
        //设置IP地址
        sysLog.setIp(IPUtils.getIpAddr(request));

        sysLog.setUrl(request.getRequestURI());
        
        sysLog.setTime(time);
        
        sysLogService.save(sysLog);
	}

	
}