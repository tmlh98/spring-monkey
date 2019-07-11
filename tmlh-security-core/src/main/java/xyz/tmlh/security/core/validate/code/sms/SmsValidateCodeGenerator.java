package xyz.tmlh.security.core.validate.code.sms;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.ServletWebRequest;

import xyz.tmlh.security.core.properties.TmlhSecurityProperties;
import xyz.tmlh.security.core.validate.code.ValidateCodeGenerator;
import xyz.tmlh.security.core.validate.code.suport.ValidateCode;

/** 
 * 短信验证码生成器 
 * @CreateInformation Created by TianXin on 2019年1月2日. 
 */
public class SmsValidateCodeGenerator implements ValidateCodeGenerator{

    @Autowired
    private TmlhSecurityProperties tmlhSecurityProperties;

    
    /* (非 Javadoc) 
     * <p>Title: generate</p> 
     * <p>Description: </p> 
     * @param request
     * @return 
     * @see xyz.tmlh.security.validate.code.ValidateCodeGenerator#generate(org.springframework.web.context.request.ServletWebRequest) 
     */ 
    @Override
    public ValidateCode generate(ServletWebRequest request) {
        String code = RandomStringUtils.randomNumeric(tmlhSecurityProperties.getCode().getSms().getLength());
        return new ValidateCode(code, tmlhSecurityProperties.getCode().getSms().getExpireIn());

    }

}
