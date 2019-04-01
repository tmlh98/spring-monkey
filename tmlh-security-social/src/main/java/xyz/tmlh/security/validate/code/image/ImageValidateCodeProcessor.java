package xyz.tmlh.security.validate.code.image;

import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.web.context.request.ServletWebRequest;

import xyz.tmlh.security.validate.code.ImageCode;
import xyz.tmlh.security.validate.code.impl.AbstractValidateCodeProcessor;

/**  
 * 图片验证码处理器
 * @CreateInformation Created by TianXin on 2019年1月2日. 
 */
public class ImageValidateCodeProcessor extends AbstractValidateCodeProcessor<ImageCode>{

    
    /**
     * 发送图形验证码，将其写到响应中
     */
    @Override
    protected void send(ServletWebRequest request, ImageCode imageCode) throws IOException {
        ImageIO.write(imageCode.getImage(), "jpg", request.getResponse().getOutputStream());
    }
    

}
