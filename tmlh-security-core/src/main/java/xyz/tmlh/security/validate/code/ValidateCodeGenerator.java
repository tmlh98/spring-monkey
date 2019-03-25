package xyz.tmlh.security.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * 验证码生成器
 * @CreateInformation Created by TianXin on 2018年12月30日.
 */
public interface ValidateCodeGenerator {
    
    /**
     * 生成验证码
     */
    ValidateCode generate(ServletWebRequest request);

}
