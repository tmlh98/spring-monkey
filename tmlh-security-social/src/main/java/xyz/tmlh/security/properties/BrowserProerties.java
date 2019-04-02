package xyz.tmlh.security.properties;

/**  
 * @CreateInformation Created by TianXin on 2018年12月29日. 
 */
public class BrowserProerties {

    private String loginPage = "/sign-in.html";
    
    private String signUpUrl = "/sign-up.html";
    
    private String logout = "/logout";
    
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

    

    
}
