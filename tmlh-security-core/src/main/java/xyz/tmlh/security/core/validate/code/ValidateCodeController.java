package xyz.tmlh.security.core.validate.code;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;


/**
 * <p>
 *   ValidateCodeController
 * </p>
 *
 * @author TianXin
 * @since 2019年1月9日下午1:02:25
 */
@RestController
public class ValidateCodeController {
    
    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;
    
    /**
     * 创建验证码时,根据不同验证码类型调用不同的实现
     * @throws Exception 
     */
    @GetMapping("/code/{type}")
    public void createValidateCode(@PathVariable String type ,  HttpServletRequest request , HttpServletResponse response) throws Exception {
        validateCodeProcessors.get(type + ValidateCodeProcessor.SUFFIX_VALIDATECODE )
            .create(new ServletWebRequest(request , response));
    }

    
}
