package xyz.tmlh.security.browser.authentication.mamage;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * <p>
 *    授权管理器
 * </p>
 *
 * @author TianXin
 * @since 2019年8月16日
 */
public interface AuthorizeConfigManager {

    /**
      * http.authorizeRequests()
      * @param @param authorizeRequests    参数
      * @return void    返回类型
      * @throws
      */
    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests);

}
