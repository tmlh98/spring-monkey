package xyz.tmlh.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import xyz.tmlh.security.core.properties.browser.BrowserProerties;
import xyz.tmlh.security.core.properties.code.ValidateCodeProperties;
import xyz.tmlh.security.core.properties.session.SessionProperties;
import xyz.tmlh.security.core.properties.social.SocialProperties;
import xyz.tmlh.security.core.support.PropertiesParam;

/**
 * 
 * <p>
 *    yml配置
 * </p>
 *
 * @author TianXin
 * @since 2018年12月29日
 */
@Configuration
@ConfigurationProperties(prefix = PropertiesParam.PREFIX_SECURITY)
public class TmlhSecurityProperties {

    /**
     * 浏览器
     */
    private BrowserProerties browser = new BrowserProerties();
    
    /**
     * 验证码
     */
    private ValidateCodeProperties code = new ValidateCodeProperties();
    
    /**
     * 第三方登录
     */
    private SocialProperties social = new SocialProperties();
    
    /**
     * session 管理
     */
    private SessionProperties session = new SessionProperties();

    public BrowserProerties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProerties browser) {
        this.browser = browser;
    }

    public ValidateCodeProperties getCode() {
        return code;
    }

    public void setCode(ValidateCodeProperties code) {
        this.code = code;
    }

    public SocialProperties getSocial() {
        return social;
    }

    public void setSocial(SocialProperties social) {
        this.social = social;
    }

    public SessionProperties getSession() {
        return session;
    }

    public void setSession(SessionProperties session) {
        this.session = session;
    }


    
}
