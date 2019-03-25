package xyz.tmlh.security.validate.code.sms;

/**  
 * @CreateInformation Created by TianXin on 2019年1月1日. 
 */
public interface SmsCodeSender {

    /**
     * 发送验证码
     */
    void send(String mobelString , String code);
    
}
