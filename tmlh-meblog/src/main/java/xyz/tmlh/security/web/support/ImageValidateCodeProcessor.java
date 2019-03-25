package xyz.tmlh.security.web.support;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.ServletWebRequest;

import xyz.tmlh.security.properties.SecurityProperties;
import xyz.tmlh.security.validate.code.ImageCode;
import xyz.tmlh.security.validate.code.impl.AbstractValidateCodeProcessor;
import xyz.tmlh.security.web.util.validate.code.Captcha;

/**  
 * 重写图片验证码处理器
 * Created by TianXin on 2019年1月18日下午5:55:53. 
 */
@Component
public class ImageValidateCodeProcessor extends AbstractValidateCodeProcessor<ImageCode>{

    private final static Logger LOGGER = LoggerFactory.getLogger(ImageValidateCodeProcessor.class);
    
    @Autowired
    private Captcha captcha;
    
    @Autowired
    private SecurityProperties securityProperties;
    
    @Override
    protected void send(ServletWebRequest request, ImageCode validateCode) throws IOException, ServletRequestBindingException {
        HttpServletResponse response = request.getResponse();
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");
            // 输出
            captcha.out(response.getOutputStream());
            
            save(request , new ImageCode(captcha.text().toLowerCase(),securityProperties.getCode().getImage().getExpireIn()));
            
        } catch (Exception e) {
            LOGGER.error("获取验证码异常：" + e.getMessage() , e);
        }
    }
    

}
