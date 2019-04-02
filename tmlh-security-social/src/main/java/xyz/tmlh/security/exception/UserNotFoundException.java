package xyz.tmlh.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * <p>
 *  用户找不到
 * </p>
 *
 * @author TianXin
 * @since 2019年3月20日下午7:27:48
 */
public class UserNotFoundException extends AuthenticationException {

    private static final long serialVersionUID = -6016223148496492722L;

    /** 
     * <p>Title: </p> 
     * <p>Description: </p> 
     * @param msg 
     */
    public UserNotFoundException(String msg) {
        super(msg);
    }

}
