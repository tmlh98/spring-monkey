package xyz.tmlh.security.validate.code.sms;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import xyz.tmlh.security.properties.SecurityProperties;
import xyz.tmlh.security.validate.code.ValidateCode;
import xyz.tmlh.security.validate.code.ValidateCodeGenerator;

/** 
 * 短信验证码生成器 
 * @CreateInformation Created by TianXin on 2019年1月2日. 
 */
@Component
public class SmsValidateCodeGenerator implements ValidateCodeGenerator{

    @Autowired
    private SecurityProperties securityProperties;

    
    /* (非 Javadoc) 
     * <p>Title: generate</p> 
     * <p>Description: </p> 
     * @param request
     * @return 
     * @see xyz.tmlh.security.validate.code.ValidateCodeGenerator#generate(org.springframework.web.context.request.ServletWebRequest) 
     */ 
    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(securityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, securityProperties.getCode().getSms().getExpireIn());

    }

}
