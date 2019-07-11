package xyz.tmlh.security.core.validate.code.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import xyz.tmlh.security.core.validate.code.ValidateCodeGenerator;
import xyz.tmlh.security.core.validate.code.ValidateCodeProcessor;
import xyz.tmlh.security.core.validate.code.image.ImageValidateCodeGenerator;
import xyz.tmlh.security.core.validate.code.image.ImageValidateCodeProcessor;
import xyz.tmlh.security.core.validate.code.sms.DefaultSmsCodeSender;
import xyz.tmlh.security.core.validate.code.sms.SmsCodeSender;
import xyz.tmlh.security.core.validate.code.sms.SmsValidateCodeGenerator;

/**
 * 
 * <p>
 *   用户可重写图形验证码逻辑
 * </p>
 *
 * @author TianXin
 * @since 2019年7月10日下午1:40:39
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeProcessor")
    public ValidateCodeProcessor imageValidateCodeProcessor() {
        return new ImageValidateCodeProcessor();
    }

    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ValidateCodeGenerator imageCodeGenerator = new ImageValidateCodeGenerator();
        return imageCodeGenerator;
    }
    
    @Bean
    @ConditionalOnMissingBean(name = "smsValidateCodeGenerator")
    public ValidateCodeGenerator smsValidateCodeGenerator() {
        return new SmsValidateCodeGenerator();
    }
    
    @Bean
    @ConditionalOnMissingBean
    public SmsCodeSender defaultSmsCodeSender() {
        return new DefaultSmsCodeSender();
    }
}
