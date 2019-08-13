package xyz.tmlh.forum.web.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import xyz.tmlh.forum.web.util.GetMapperUtil;
import xyz.tmlh.security.browser.BrowserSecurityConfigAdapter;

/**
 * <p>
 *    自定义请求处理
 * </p>
 *
 * @author TianXin
 * @since 2019年4月1日下午6:19:37
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends BrowserSecurityConfigAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(getUrls())
            .permitAll()//不拦截请求
        .anyRequest(); 
        
        super.configure(http);
    }
    

    private List<String> getUrlList(){
        List<String> urls = new ArrayList<>();
        urls.add("/favicon.ico");
        urls.add("/webjars/**");
        urls.add("/asserts/**");
        urls.add("/images/**");
//        urls.add(WebConstans.URL_WEBSOCKET);
        return urls;
    }
    
    private String[] getUrls() {
        List<String> urls = getUrlList();
        urls.addAll(GetMapperUtil.getMapperValue());
        return urls.stream().toArray(String[]::new);
    }
    
}
