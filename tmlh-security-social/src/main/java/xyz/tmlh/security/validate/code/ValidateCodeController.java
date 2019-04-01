package xyz.tmlh.security.validate.code;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;


/**  
 * @CreateInformation Created by TianXin on 2018年12月29日. 
 */
@RestController
public class ValidateCodeController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(ValidateCodeController.class);
    
    @Autowired
    private Map<String, ValidateCodeProcessor> validateCodeProcessors;
    
    /**
     * 创建验证码时,根据不同验证码类型调用不同的实现
     * @throws Exception 
     */
    @GetMapping("/code/{type}")
    public void createValidateCode(@PathVariable String type ,  HttpServletRequest request , HttpServletResponse response) throws Exception {
        LOGGER.info(type + "ValidateCodeProcessor" );
        validateCodeProcessors.get(type + "ValidateCodeProcessor" ).create(new ServletWebRequest(request , response));
    }

    
}
