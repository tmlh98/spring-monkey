package xyz.tmlh.security.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import xyz.tmlh.security.properties.SecurityProperties;
import xyz.tmlh.security.web.util.validate.code.Captcha;
import xyz.tmlh.security.web.util.validate.code.GifCaptcha;

/**  
 * Created by TianXin on 2019年1月18日下午6:10:27. 
 */
@Configuration
public class WebConfiguration {

    
    @Autowired
    private SecurityProperties securityProperties;
    
    @Bean
    public Captcha captcha() {
        int width = securityProperties.getCode().getImage().getWidth();
        int height = securityProperties.getCode().getImage().getHeight();
        int len = securityProperties.getCode().getImage().getLength();
        return new GifCaptcha(width, height, len);
    }
    
    /*
     *  1问题名称：SpringBoot获取PUT方式提交参数为空
     *  2开发环境：SpringBoot 1.5.7 
     *  3解决方法：在WebMvcConfig中添加一个@Bean
     */
    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new HiddenHttpMethodFilter();
    }
    
    
    
    
}
