package xyz.tmlh.security.validate.code.impl;

import java.io.IOException;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.ServletWebRequest;

import xyz.tmlh.security.exception.ValidateCodeException;
import xyz.tmlh.security.suport.SecurityConstants;
import xyz.tmlh.security.validate.code.ValidateCode;
import xyz.tmlh.security.validate.code.ValidateCodeGenerator;
import xyz.tmlh.security.validate.code.ValidateCodeProcessor;
import xyz.tmlh.security.validate.code.ValidateCodeType;

/**
 * 抽象的验证码处理器
 * 
 * @CreateInformation Created by TianXin on 2019年1月1日.
 */
public abstract class AbstractValidateCodeProcessor<C extends ValidateCode> implements ValidateCodeProcessor {

    /**
     * 操作session的工具类
     */
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    /**
     * 收集系统中所有的 {@link ValidateCodeGenerator} 接口的实现。
     */
    @Autowired
    private Map<String, ValidateCodeGenerator> validateCodeGenerators;

    @Override
    public void create(ServletWebRequest request) throws Exception {
        C validateCode = generate(request);
        save(request, validateCode);
        send(request, validateCode);

    }

    /**
     * 发送验证码 , 由子类实现
     * 
     * @throws IOException
     * @throws ServletRequestBindingException
     */
    protected abstract void send(ServletWebRequest request, C validateCode) throws IOException, ServletRequestBindingException;

    /**
     * 将验证码保存进session
     */
    protected void save(ServletWebRequest request, C validateCode) {
        sessionStrategy.setAttribute(request, getSessionKey(request), validateCode);
    }

    /**
     * 生成校验码
     * 
     * @param request
     * @return
     */
    @SuppressWarnings("unchecked")
    private C generate(ServletWebRequest request) {
        String type = getValidateCodeType(request).toString().toLowerCase();
        String generatorName = type + ValidateCodeGenerator.class.getSimpleName();
        ValidateCodeGenerator validateCodeGenerator = validateCodeGenerators.get(generatorName);
        if (validateCodeGenerator == null) {
            throw new ValidateCodeException("验证码生成器" + generatorName + "不存在");
        }
        return (C)validateCodeGenerator.generate(request);
    }

    /**
     * 根据请求的url获取校验码的类型
     * 
     * @param request
     * @return
     */
    private ValidateCodeType getValidateCodeType(ServletWebRequest request) {
        String type = StringUtils.substringBefore(getClass().getSimpleName(),  ValidateCodeProcessor.SUFFIX_VALIDATECODE);
        return ValidateCodeType.valueOf(type.toUpperCase());
    }

    /**
     * 构建验证码放入session时的key
     * 
     * @param request
     * @return
     */
    private String getSessionKey(ServletWebRequest request) {
        return SESSION_KEY_PREFIX + getValidateCodeType(request).toString().toUpperCase();
    }

}
