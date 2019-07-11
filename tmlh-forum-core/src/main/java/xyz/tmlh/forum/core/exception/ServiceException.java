package xyz.tmlh.forum.core.exception;

/**
 * <p>
 *    业务异常
 * </p>
 *
 * @author TianXin
 * @since 2019年4月7日下午2:14:20
 */
public class ServiceException extends Exception {

    private static final long serialVersionUID = 8243573209422891575L;

    public ServiceException(String message) {
        super(message);
    }
    
}
