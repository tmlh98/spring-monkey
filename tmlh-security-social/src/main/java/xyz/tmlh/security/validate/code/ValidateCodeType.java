package xyz.tmlh.security.validate.code;

import xyz.tmlh.security.suport.SecurityConstants;

/**  
 * 验证码的类型
 * @CreateInformation Created by TianXin on 2019年1月2日. 
 */
public enum ValidateCodeType {
    
    /**
     * 短信验证码
     */
    SMS {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_SMS;
        }
    },
    /**
     * 图片验证码
     */
    IMAGE {
        @Override
        public String getParamNameOnValidate() {
            return SecurityConstants.DEFAULT_PARAMETER_NAME_CODE_IMAGE;
        }
    };

    /**
     * 校验时从请求中获取的参数的名字
     * @return
     */
    public abstract String getParamNameOnValidate();
}
