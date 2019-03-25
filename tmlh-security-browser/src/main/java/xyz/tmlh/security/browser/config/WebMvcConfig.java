package xyz.tmlh.security.browser.config;

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
        registry.addViewController("/singl.html").setViewName("singl");
        registry.addViewController("/admin/login").setViewName("admin/login");
//        registry.addViewController("/admin/article_list").setViewName("admin/article_list");
//        registry.addViewController("/admin/article_add").setViewName("admin/article_add");
    }
    
}
