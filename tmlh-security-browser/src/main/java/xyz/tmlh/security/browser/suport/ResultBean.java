/*   
 * @Title: ResultBean.java 
 * @Package com.tx.blog.common.entity 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author A18ccms A18ccms_gmail_com   
 * @date 2018年12月27日 下午7:22:29 
 * @version V1.0   
 */ 
package xyz.tmlh.security.browser.suport;

import java.util.HashMap;
import java.util.Map;

/** 
 * 结果bean 
 * Created by TianXin on 2018年12月27日. 
 */
public class ResultBean {

    private static final String CODE_SUCCESS = "success";

    private static final String CODE_FAIL = "fail";
    
    private String message = CODE_SUCCESS;
    
    /**
     * 0√  1×
     */
    private Integer code;
    
    private Map<String, Object> result = new HashMap<>();

    public ResultBean() {
        this.code = 0;
        this.message = CODE_SUCCESS;
    }
    
    public ResultBean(String message) {
        this.code = 0;
        this.message = message;
    }
    
    public ResultBean(String message,Integer code) {
        super();
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Map<String, Object> getResult() {
        return result;
    }

    public void setResult(Map<String, Object> result) {
        this.result = result;
    }
    
    public static ResultBean success() {
        return new ResultBean();
    }
    
    public static ResultBean success(String message) {
        return new ResultBean(message);
    }
    
    public static ResultBean fail() {
        return new ResultBean(CODE_FAIL , 1);
    }
    
    public static ResultBean fail(String message) {
        return new ResultBean(message  , 1 );
    }
    
    public ResultBean result(Map<String, Object> result) {
        this.result = result;
        return this;
    }
    
    public ResultBean putResult(String key, Object value) {
        this.result.put(key, value);
        return this;
    }

    public ResultBean msg(String message) {
       this.message = message;
       return this;
    }
    
}
