package xyz.tmlh.security.properties;


/**
 * <p>
 *      qq配置类    
 * </p>
 *
 * @author TianXin
 * @since 2019年3月22日上午11:38:28
 */
public class QQProperties{
	
	private String providerId = "qq";
	private String appId;
	private String appSecret;

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
	
	
}
