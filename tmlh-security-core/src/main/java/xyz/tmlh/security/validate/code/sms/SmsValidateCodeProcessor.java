package xyz.tmlh.security.validate.code.sms;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import xyz.tmlh.security.properties.SecurityConstants;
import xyz.tmlh.security.validate.code.ValidateCode;
import xyz.tmlh.security.validate.code.impl.AbstractValidateCodeProcessor;

/**  
 * 短信验证码处理器
 * @CreateInformation Created by TianXin on 2019年1月2日. 
 */
@Component
public class SmsValidateCodeProcessor extends AbstractValidateCodeProcessor<ValidateCode> {

    /**
     * 短信验证码发送器
     */
    @Autowired
    private SmsCodeSender smsCodeSender;
    
    @Override
    protected void send(ServletWebRequest request, ValidateCode validateCode) throws IOException, ServletRequestBindingException {
        String paramName = SecurityConstants.DEFAULT_PARAMETER_NAME_MOBILE;
        String mobile = ServletRequestUtils.getRequiredStringParameter(request.getRequest(), paramName);
        smsCodeSender.send(mobile, validateCode.getCode());

    }

}
