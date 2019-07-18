package xyz.tmlh.forum.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import xyz.tmlh.forum.web.handler.DebugInterceptor;
import xyz.tmlh.forum.web.handler.ExecuteTimeInterceptor;
import xyz.tmlh.forum.web.util.validate.Captcha;
import xyz.tmlh.forum.web.util.validate.GifCaptcha;
import xyz.tmlh.security.core.properties.TmlhSecurityProperties;

/**
 * Created by TianXin on 2019年1月18日下午6:10:27.
 */
@ComponentScan(basePackages= {"xyz.tmlh.security.core" , "xyz.tmlh.security.browser"})
@Configuration
public class WebAppConfiguration {

    @Autowired
    private TmlhSecurityProperties tmlhSecurityProperties;

    @Bean
    public Captcha captcha() {
        int width = tmlhSecurityProperties.getCode().getImage().getWidth();
        int height = tmlhSecurityProperties.getCode().getImage().getHeight();
        int len = tmlhSecurityProperties.getCode().getImage().getLength();
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
    
    @Bean
    @Profile("dev")
    public ExecuteTimeInterceptor executeTimeInterceptor() {
        return new ExecuteTimeInterceptor();
    }
    
    @Bean
    @Profile("dev")
    public DebugInterceptor debugInterceptor() {
        return new DebugInterceptor();
    }
    

    /*
     * WebSocket
     */
//    @Bean
//    public ServerEndpointExporter serverEndpointExporter() {
//        return new ServerEndpointExporter();
//    }

}
