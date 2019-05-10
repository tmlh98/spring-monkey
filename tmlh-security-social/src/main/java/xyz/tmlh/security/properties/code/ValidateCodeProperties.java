package xyz.tmlh.security.properties.code;

/**
 * 验证码配置类  
 * @CreateInformation Created by TianXin on 2018年12月30日. 
 */
public class ValidateCodeProperties {

    private ImageCodeProperties image = new ImageCodeProperties();
    
    private SmsCodeProperties sms = new SmsCodeProperties();

    public ImageCodeProperties getImage() {
        return image;
    }

    public void setImage(ImageCodeProperties image) {
        this.image = image;
    }

    public SmsCodeProperties getSms() {
        return sms;
    }

    public void setSms(SmsCodeProperties sms) {
        this.sms = sms;
    }

    
}

