package xyz.tmlh.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * <p>
 *   校验码处理器,封装不同的验证码处理器 
 * </p>
 *
 * @author TianXin
 * @since 2019年7月10日下午1:40:05
 */
public interface ValidateCodeProcessor {
    
    String SUFFIX_VALIDATECODE = "ValidateCodeProcessor";

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_PRE_CODE_";
    
    /**
     * 创建验证码
     */
    void create(ServletWebRequest request) throws Exception;
    
}
