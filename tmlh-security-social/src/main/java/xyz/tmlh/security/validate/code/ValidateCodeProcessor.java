package xyz.tmlh.security.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/** 
 * 校验码处理器,封装不同的验证码处理器 
 * @CreateInformation Created by TianXin on 2019年1月1日. 
 */
public interface ValidateCodeProcessor {

    /**
     * 验证码放入session时的前缀
     */
    String SESSION_KEY_PREFIX = "SESSION_KEY_PRE_CODE_";
    
    /**
     * 创建验证码
     */
    void create(ServletWebRequest request) throws Exception;
    
}
