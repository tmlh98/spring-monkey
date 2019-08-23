package xyz.tmlh.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

import xyz.tmlh.security.core.validate.code.support.ValidateCode;

/**
 * 
 * <p>
 *   验证码生成器
 * </p>
 *
 * @author TianXin
 * @since 2019年7月10日下午1:39:53
 */
public interface ValidateCodeGenerator {
    
    /**
     * 生成验证码
     */
    ValidateCode generate(ServletWebRequest request);

}
