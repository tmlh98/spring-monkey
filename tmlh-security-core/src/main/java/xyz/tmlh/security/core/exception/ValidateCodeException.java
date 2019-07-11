package xyz.tmlh.security.core.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * <p>
 *  验证码异常    
 * </p>
 *
 * @author TianXin
 * @since 2019年3月20日下午7:27:48
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = -6016223148496492732L;

    /** 
     * <p>Title: </p> 
     * <p>Description: </p> 
     * @param msg 
     */
    public ValidateCodeException(String msg) {
        super(msg);
    }

}
