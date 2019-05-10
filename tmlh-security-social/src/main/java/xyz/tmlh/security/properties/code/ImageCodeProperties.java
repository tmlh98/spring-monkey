package xyz.tmlh.security.properties.code;

/**  
 * 图片验证码配置类
 * @CreateInformation Created by TianXin on 2018年12月30日. 
 */
public class ImageCodeProperties extends SmsCodeProperties{

    private int width = 67;
    
    private int height = 23;

    public ImageCodeProperties() {
        setLength(4);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }



}
