package xyz.tmlh.security.core.suport;

/**
 * <p>
 *    SocialUserInfo
 * </p>
 *
 * @author TianXin
 * @since 2019年3月23日下午11:01:05
 */
public class SocialUserInfo {
	
	private String providerId;
	
	private String providerUserId;
	
	/**
	 * 用户名
	 */
	private String nickname;
	
	/**
	 * 头像
	 */
	private String headimg;

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProviderUserId() {
		return providerUserId;
	}

	public void setProviderUserId(String providerUserId) {
		this.providerUserId = providerUserId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadimg() {
		return headimg;
	}

	public void setHeadimg(String headimg) {
		this.headimg = headimg;
	}
	
}
