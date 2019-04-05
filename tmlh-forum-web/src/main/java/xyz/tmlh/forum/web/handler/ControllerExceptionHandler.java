package xyz.tmlh.forum.web.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import xyz.tmlh.forum.web.WebConstans;
import xyz.tmlh.security.browser.suport.ResultBean;
import xyz.tmlh.security.exception.UserNotFoundException;


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
    
}
