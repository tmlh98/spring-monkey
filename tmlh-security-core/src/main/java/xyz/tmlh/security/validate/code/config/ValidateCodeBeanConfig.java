package xyz.tmlh.security.validate.code.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import xyz.tmlh.security.validate.code.ValidateCodeGenerator;
import xyz.tmlh.security.validate.code.image.ImageValidateCodeGenerator;
import xyz.tmlh.security.validate.code.sms.SmsValidateCodeGenerator;

/**
 * @CreateInformation Created by TianXin on 2018年12月30日.
 */
@Configuration
public class ValidateCodeBeanConfig {

    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeGenerator")
    public ValidateCodeGenerator imageValidateCodeGenerator() {
        ValidateCodeGenerator imageCodeGenerator = new ImageValidateCodeGenerator();
        return imageCodeGenerator;
    }

    @Bean
    @ConditionalOnMissingBean(name = "imageValidateCodeProcessor")
    public ValidateCodeGenerator imageCodeProcessor() {
        ValidateCodeGenerator imageCodeGenerator = new ImageValidateCodeGenerator();
        return imageCodeGenerator;
    }
    
    @Bean
    @ConditionalOnMissingBean(name = "smsValidateCodeGenerator")
    public ValidateCodeGenerator smsValidateCodeGenerator() {
        return new SmsValidateCodeGenerator();
    }
}
