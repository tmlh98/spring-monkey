package xyz.tmlh.forum.aspect;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.validation.BindingResult;

import xyz.tmlh.core.exception.ValidateException;

//@Aspect
//@Component
public class ValidateAspect {
	
	@Around("execution(* xyz.tmlh.forum.web.controller.**.*(..))")
	public Object handleValidateResult(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		for (Object arg : args) {
			if(arg instanceof BindingResult) {
				BindingResult errors = (BindingResult)arg;
				if (errors.hasErrors()) {
					throw new ValidateException(errors.getAllErrors());
				}
			}
		}
		Object result = pjp.proceed();
		return result;
	}

}