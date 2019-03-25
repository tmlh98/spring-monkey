package xyz.tmlh.security.common.aspect;

import org.aspectj.lang.annotation.Pointcut;


/**
 * 系统日志，切面处理类
 */
//@Aspect
//@Component
public class LogAspect {
    
	@Pointcut("@annotation(xyz.tmlh.security.common.annonation.Log)")
	public void logPointCut() { 
		
	}

 
	
}
