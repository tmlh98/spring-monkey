package xyz.tmlh.security.core.validate.code.support;

import java.io.Serializable;
import java.time.LocalDateTime;

/**  
 * 短信验证码
 * @CreateInformation Created by TianXin on 2018年12月29日. 
 */
public class ValidateCode implements Serializable{
    
    private static final long serialVersionUID = -4875210536735286285L;

    /**
     * 验证码
     */
    private String code;
    
    /**
     * 过期时间
     */
    private LocalDateTime expireTime;

    public ValidateCode(String code) {
        this.code = code;
    }
    
    public ValidateCode(int expireIn) {
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    public ValidateCode( String code, int expireIn){
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }
    
    public ValidateCode(String code, LocalDateTime expireTime){
        this.code = code;
        this.expireTime = expireTime;
    }
   
    /**
     * 验证码是否过期
     */
    public boolean isExpried() {
        return LocalDateTime.now().isAfter(expireTime);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(LocalDateTime expireTime) {
        this.expireTime = expireTime;
    }
    
}
