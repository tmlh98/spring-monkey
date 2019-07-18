package xyz.tmlh.forum.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import xyz.tmlh.forum.web.handler.DebugInterceptor;
import xyz.tmlh.forum.web.handler.ExecuteTimeInterceptor;

/**
 * <p>
 *    
 * </p>
 *
 * @author TianXin
 * @since 2019年7月18日上午9:16:48
 */
@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Autowired(required = false)
    private ExecuteTimeInterceptor executeTimeInterceptor;
    
    @Autowired(required = false)
    private DebugInterceptor debugInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        if(executeTimeInterceptor != null) {
            registry.addInterceptor(executeTimeInterceptor).addPathPatterns("/**");
            
        }
        if(debugInterceptor != null) {
            registry.addInterceptor(debugInterceptor).addPathPatterns("/**");
        }
    }
}
