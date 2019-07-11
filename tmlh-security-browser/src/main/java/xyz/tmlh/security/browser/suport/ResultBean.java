package xyz.tmlh.security.browser.suport;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * <p>
 *      默认的返回结果集容器
 * </p>
 *
 * @author TianXin
 * @since 2018年12月27日上午9:44:29
 */
public class ResultBean {

    private static final String CODE_SUCCESS = "success";

    private static final String CODE_FAIL = "fail";
    
    private String message = CODE_SUCCESS;
    
    /**
     * 0√  1×
     */
    private Integer code = 0;
    
    private Map<String, Object> result = null;

    public ResultBean() {
        this.message = CODE_SUCCESS;
    }
    
    public ResultBean(String message) {
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

    public ResultBean setMessage(String message) {
        this.message = message;
        return this;
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
        if(result == null) {
            result = new HashMap<>(1);
        }
        this.result.put(key, value);
        return this;
    }

    public ResultBean msg(String message) {
       this.message = message;
       return this;
    }
    
}
