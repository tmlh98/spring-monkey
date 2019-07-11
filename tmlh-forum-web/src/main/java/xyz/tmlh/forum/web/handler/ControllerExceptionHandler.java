package xyz.tmlh.forum.web.handler;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import xyz.tmlh.forum.core.exception.ServiceException;
import xyz.tmlh.forum.core.exception.ValidateException;
import xyz.tmlh.forum.web.WebConstans;
import xyz.tmlh.security.browser.suport.ResultBean;
import xyz.tmlh.security.core.exception.UserNotFoundException;


/**
 * <p>
 *    控制器异常拦截器
 * </p>
 *
 * @author TianXin
 * @since 2019年3月25日下午1:34:18
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    
    @ExceptionHandler(ValidateException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean handlerValidateException(ValidateException ex ) {
        
        if(LOGGER.isErrorEnabled()) {
            LOGGER.error("----------------Validate 验证失败 -----------------");
            LOGGER.error(ex.getErrors().toString());
            LOGGER.error("----------------异常信息 ----------------");
        }
        StringBuilder sBuilder = new StringBuilder();
        for (ObjectError error : ex.getErrors()) {
            sBuilder.append(error.getDefaultMessage() + " , ");
        }
        return ResultBean.fail(sBuilder.toString().substring(0 , sBuilder.toString().length() - 2 ));
    }
    
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResultBean processValidationError(BindException ex) {
        LOGGER.error(ex.getMessage(), ex);
        String result = ex
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(ObjectError::getDefaultMessage)
                .collect(Collectors.joining(","));
                
        return ResultBean.fail().msg(result);
    }
    
    
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultBean handlerException(Exception ex ) {
        
        if(LOGGER.isErrorEnabled()) {
            LOGGER.error("----------------异常信息 -----------------");
            LOGGER.error(ex.getLocalizedMessage() , ex);
            LOGGER.error("----------------异常信息 ----------------");
        }
        
        return ResultBean.fail(ex.getMessage());
    }
    
    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFoundException(UserNotFoundException ex ) {
        LOGGER.error(ex.getMessage());
        return WebConstans.REDIRECT_PREFIX + "login";
    }
    
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(ServiceException.class)
    public ResultBean serviceException(ServiceException ex ) {
        if(LOGGER.isWarnEnabled()) {
            LOGGER.warn(ex.getMessage());
        }
        return ResultBean.fail(ex.getMessage());
    }
    
}
