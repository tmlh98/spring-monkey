package xyz.tmlh.security.core.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * <p>
 *      缺少配置
 * </p>
 *
 * @author TianXin
 * @since 2019年3月20日下午7:27:48
 */
public class NotFoundImplementException extends AuthenticationException {

    private static final long serialVersionUID = -6016223148496492722L;

    /** 
     * <p>Title: </p> 
     * <p>Description: </p> 
     * @param msg 
     */
    public NotFoundImplementException(String msg) {
        super(msg);
    }

}
