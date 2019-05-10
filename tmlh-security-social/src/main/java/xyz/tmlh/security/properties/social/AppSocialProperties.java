package xyz.tmlh.security.properties.social;

/**
 * <p>
 *   AppSocialProperties
 * </p>
 *
 * @author TianXin
 * @since 2019年5月9日下午4:42:55
 */
public abstract class AppSocialProperties {
    
    @SuppressWarnings("unused")
    private String providerId;
    private String appId;
    private String appSecret;

    /**
     * 必须实现获取服务商标识方法
     * 
     * @return 
     * @return String
     */
    public abstract String getProviderId();

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
