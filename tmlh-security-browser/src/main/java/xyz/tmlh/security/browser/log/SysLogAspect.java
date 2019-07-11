package xyz.tmlh.security.browser.log;

import java.lang.reflect.Method;
import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import xyz.tmlh.security.browser.util.LogUtil;


/**
 * 系统日志，切面处理类
 */
@Aspect
@Component
@ConditionalOnBean(SysLogListener.class)
public class SysLogAspect {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(SysLogAspect.class);

    private ThreadLocal<Long> startTime = new ThreadLocal<>();
	
	@Pointcut("@annotation(xyz.tmlh.security.browser.log.SysLog)")
	public void logPointCut() {}
	
	/**
     * 注入ApplicationContext对象调用publishEvent方法完成事件发布
     **/
    @Autowired
    private ApplicationContext applicationContext;

	@Around("logPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
	    startTime.set(System.currentTimeMillis());
	    Object result = null;
	    ISysLogTemplate sysLog = new ISysLogTemplate();
	    try {
	        result = point.proceed();
        } catch (Exception e) {
            // @ControllerAdvice 的异常不处理
            sysLog.setExMsg(e.getMessage());
            sysLog.setExDetail(LogUtil.getStackTrace(e));
        }
		
	    long time = System.currentTimeMillis() - startTime.get();
	    sysLog.setExecuteTime(time);
	    
	    genSysLogDetail(point, time , sysLog);
		applicationContext.publishEvent(new SysLogEvent(sysLog));
		return result;
	}

	private void genSysLogDetail(ProceedingJoinPoint joinPoint, long time  , ISysLogTemplate sysLog) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		SysLog log = method.getAnnotation(SysLog.class);
		
		if(log != null){
		  //注解上的描述
            sysLog.setDescription(log.value());
		}

		//请求的方法名
		String className = joinPoint.getTarget().getClass().getName();
		String methodName = signature.getName();

		sysLog.setMethodName(className + "." + methodName + "()");
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
		sysLog.setExecuteTime(time);
	}

	
}