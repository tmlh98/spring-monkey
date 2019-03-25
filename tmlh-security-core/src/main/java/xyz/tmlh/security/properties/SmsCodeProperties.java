package xyz.tmlh.security.properties;

/**  
 * 短信验证码配置类
 * @CreateInformation Created by TianXin on 2018年12月30日. 
 */
public class SmsCodeProperties {

    private int length = 6;
    
    private int expireIn = 300;
    
    private String url ;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getExpireIn() {
        return expireIn;
    }

    public void setExpireIn(int expireIn) {
        this.expireIn = expireIn;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    
}
