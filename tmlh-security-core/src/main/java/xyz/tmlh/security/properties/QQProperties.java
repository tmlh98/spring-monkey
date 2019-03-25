package xyz.tmlh.security.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * <p>
 *      qq配置类    
 * </p>
 *
 * @author TianXin
 * @since 2019年3月22日上午11:38:28
 */
public class QQProperties extends SocialProperties {
	
	private String providerId = "qq";

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
	
}
