package xyz.tmlh.security.core.validate.code.sms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** 
 * 默认的短信验证码发送器 
 * @CreateInformation Created by TianXin on 2019年1月1日. 
 */
public class DefaultSmsCodeSender implements SmsCodeSender{

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultSmsCodeSender.class);

    /* (非 Javadoc) 
     * <p>Title: send</p> 
     * <p>Description: </p> 
     * @param mobile
     * @param code 
     * @see xyz.tmlh.security.validate.code.sms.SmsCodeSender#send(java.lang.String, java.lang.String) 
     */ 
    @Override
    public void send(String mobile, String code) {
        LOGGER.info("请重写此方法, 向手机: {}, 发送验证码: {}" , mobile , code);
    }

}
