package xyz.tmlh.forum.security.validate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import xyz.tmlh.security.properties.SecurityProperties;
import xyz.tmlh.security.validate.code.ImageCode;
import xyz.tmlh.security.validate.code.ValidateCode;
import xyz.tmlh.security.validate.code.ValidateCodeGenerator;

/**
 * 重写验证码生成器 Created by TianXin on 2019年1月18日下午5:58:39.
 */
@Component
public class ImageValidateCodeGenerator implements ValidateCodeGenerator {

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public ValidateCode generate(ServletWebRequest request) {
        // 这里不使用BufferedImage的形式
        return new ImageCode(securityProperties.getCode().getImage().getExpireIn());
    }

}
