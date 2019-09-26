package xyz.tmlh.security.browser.authentication.manage;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * 
 * <p>
 *    授权配置提供商，各个模块和业务系统可以通过实现此接口向系统添加授权配置。
 * </p>
 *
 * @author TianXin
 * @since 2019年8月16日
 */
public interface AuthorizeConfigProvider {
    
    /**
     * 在整个授权配置中，
     *  应该有且仅有一个针对anyRequest的配置，如果所有的实现都没有针对anyRequest的配置，
     *  系统会自动增加一个anyRequest().authenticated()的配置。如果有多个针对anyRequest
     *  的配置，则会抛出异常。
      *
      * @param @param config
      * @param @return    参数
      * @return boolean    返回类型
      * @throws 返回的boolean表示配置中是否有针对anyRequest的配置。
     */
	boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests);

}
