/**   
 * @Title: ExceptionHandler.java 
 * @Package com.tx.blog.web.handler 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author A18ccms A18ccms_gmail_com   
 * @date 2018年12月27日 下午12:33:35 
 * @version V1.0   
 */ 
package xyz.tmlh.security.browser.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import xyz.tmlh.security.browser.suport.ResultBean;


/**  
 * 控制器异常拦截器
 * Created by TianXin on 2018年12月27日. 
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    private final static Logger LOGGER = LoggerFactory.getLogger(ControllerExceptionHandler.class);
    
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResultBean handlerException(RuntimeException ex ) {
        
        if(LOGGER.isErrorEnabled()) {
            LOGGER.error("----------------异常信息 -----------------");
            LOGGER.error(ex.getLocalizedMessage() , ex);
            LOGGER.error("----------------异常信息 ----------------");
        }
        
        return ResultBean.fail(ex.getMessage());
    }
    
}
