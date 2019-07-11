package xyz.tmlh.security.core.validate.code.suport;

import java.awt.image.BufferedImage;

/**  
 * 图形验证码
 * @CreateInformation Created by TianXin on 2018年12月29日. 
 */
public class ImageCode extends ValidateCode{
    
    /**
     * 图片
     */
    private BufferedImage image;
    
    
    public ImageCode(String code, int expireIn) {
        super(code, expireIn);
    }
    
    public ImageCode(int expireIn) {
        super(expireIn);
    }
    
    public ImageCode(String code) {
        super(code);
    }
    
    public ImageCode(BufferedImage image , String code, int expireTime) {
        super(code, expireTime);
        this.image = image;
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
}
