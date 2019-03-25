package xyz.tmlh.forum.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**  
 * spring mvc配置
 * Created by TianXin on 2018年12月26日. 
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter  {

    /**
     * 添加跳转视图
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
    }
    
}
