package xyz.tmlh.security.core.validate.code.image;

import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.web.context.request.ServletWebRequest;

import xyz.tmlh.security.core.validate.code.AbstractValidateCodeProcessor;
import xyz.tmlh.security.core.validate.code.support.ImageCode;

/**
 * 
 * <p>
 *   图片验证码处理器
 * </p>
 *
 * @author TianXin
 * @since 2019年7月10日下午2:24:31
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
