package xyz.tmlh.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import xyz.tmlh.security.core.properties.browser.BrowserProerties;
import xyz.tmlh.security.core.properties.code.ValidateCodeProperties;
import xyz.tmlh.security.core.properties.session.SessionProperties;
import xyz.tmlh.security.core.properties.social.SocialProperties;

/**  
 *  Created by TianXin on 2018年12月29日. 
 */
@Configuration
@ConfigurationProperties(prefix = "tmlh.security")
public class TmlhSecurityProperties {

    private BrowserProerties browser = new BrowserProerties();
    
    private ValidateCodeProperties code = new ValidateCodeProperties();
    
    private SocialProperties social = new SocialProperties();
    
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
