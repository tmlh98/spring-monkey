package xyz.tmlh.forum.security.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import xyz.tmlh.security.core.properties.TmlhSecurityProperties;
import xyz.tmlh.security.core.validate.code.ValidateCodeGenerator;
import xyz.tmlh.security.core.validate.code.suport.ImageCode;
import xyz.tmlh.security.core.validate.code.suport.ValidateCode;

/**
 * <p>
 *   重写验证码生成器
 * </p>
 *
 * @author TianXin
 * @since 2019年1月18日下午4:43:34
 */
@Component
public class ImageValidateCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private TmlhSecurityProperties tmlhSecurityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        // 这里不使用BufferedImage的形式
        return new ImageCode(tmlhSecurityProperties.getCode().getImage().getExpireIn());
    }

}
