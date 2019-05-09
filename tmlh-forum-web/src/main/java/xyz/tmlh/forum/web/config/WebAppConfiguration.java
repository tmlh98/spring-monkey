package xyz.tmlh.forum.web.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import xyz.tmlh.core.CoreApplication;
import xyz.tmlh.core.model.UserModel;
import xyz.tmlh.forum.util.validate.Captcha;
import xyz.tmlh.forum.util.validate.GifCaptcha;
import xyz.tmlh.security.SecurityCoreConfig;
import xyz.tmlh.security.browser.BrowserSecurityConfig;
import xyz.tmlh.security.properties.SecurityProperties;

/**
 * Created by TianXin on 2019年1月18日下午6:10:27.
 */
@ComponentScan(basePackageClasses = {BrowserSecurityConfig.class, SecurityCoreConfig.class, CoreApplication.class})
@Configuration
public class WebAppConfiguration {

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

    /*
     * WebSocket
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}
