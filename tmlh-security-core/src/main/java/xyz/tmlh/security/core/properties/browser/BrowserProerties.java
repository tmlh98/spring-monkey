package xyz.tmlh.security.core.properties.browser;

/**
 * 
 * <p>
 *   BrowserProerties
 * </p>
 *
 * @author TianXin
 * @since 2019年7月10日下午1:37:43
 */
public class BrowserProerties {

    private String loginPage = "/signin";
    
    /**
     * form表单用户名参数名
     */
    private String usernameParameter = "username";
    
    /**
     * form表单密码参数名
     */
    private String passwordParameter = "password";
    
    /**
     * 认证的url
     */
    private String loginProcessingUrl = "/security/login";
    
    private String signUpUrl = "/signup";
    
    private String logout = "/logout";
    
    /**
     * 当出现错误的请求时 , 跳转的策略(首页或者登陆页)
     */
    private String redirectUrl = "/";
    /**
     * 登陆类型,默认使用json
     */
    private LoginType loginType = LoginType.JSON;
    
    private int rememberMeSeconds = 3600 * 24 * 20;
   
    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public LoginType getLoginType() {
        return loginType;
    }

    public void setLoginType(LoginType loginType) {
        this.loginType = loginType;
    }

    public int getRememberMeSeconds() {
        return rememberMeSeconds;
    }

    public void setRememberMeSeconds(int rememberMeSeconds) {
        this.rememberMeSeconds = rememberMeSeconds;
    }

    public String getSignUpUrl() {
        return signUpUrl;
    }

    public void setSignUpUrl(String signUpUrl) {
        this.signUpUrl = signUpUrl;
    }

    public String getLogout() {
        return logout;
    }

    public void setLogout(String logout) {
        this.logout = logout;
    }

    public String getUsernameParameter() {
        return usernameParameter;
    }

    public void setUsernameParameter(String usernameParameter) {
        this.usernameParameter = usernameParameter;
    }

    public String getPasswordParameter() {
        return passwordParameter;
    }

    public void setPasswordParameter(String passwordParameter) {
        this.passwordParameter = passwordParameter;
    }

    public String getLoginProcessingUrl() {
        return loginProcessingUrl;
    }

    public void setLoginProcessingUrl(String loginProcessingUrl) {
        this.loginProcessingUrl = loginProcessingUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }
    
}
