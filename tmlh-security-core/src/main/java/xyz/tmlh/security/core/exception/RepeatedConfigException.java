package xyz.tmlh.security.core.exception;

/**
 * <p>
 *    存在重叠的配置异常
 * </p>
 *
 * @author TianXin
 * @since 2019年8月16日
 */
public class RepeatedConfigException extends RuntimeException{

    private static final long serialVersionUID = 2935731015891015027L;

    public RepeatedConfigException(String msg) {
        super(msg);
    }

    
}
