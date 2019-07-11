package xyz.tmlh.security.browser.log;

import java.time.LocalDateTime;

/**
 * <p>
 *    基本的日志模板
 * </p>
 *
 * @author TianXin
 * @since 2019年7月11日上午11:34:59
 */
public class ISysLogTemplate {

    /**
     * 执行时间
     */
    private long executeTime;
    
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    
    /**
     * 类名
     */
    private String className;
    
    /**
     * 方法名
     */
    private String methodName;
    
    /**
     * 方法的全部参数
     */
    private String params;
    
    /**
     * 注解对应的描述
     */
    private String description;
    
    /**
     * 异常详情信息 堆栈信息
     */
    private String exDetail;

    /**
     * e.getMessage
     */
    private String exMsg;

    public long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExDetail() {
        return exDetail;
    }

    public void setExDetail(String exDetail) {
        this.exDetail = exDetail;
    }

    public String getExMsg() {
        return exMsg;
    }

    public void setExMsg(String exMsg) {
        this.exMsg = exMsg;
    }

    @Override
    public String toString() {
        return "ISysLogTemplate [executeTime=" + executeTime + ", createTime=" + createTime + ", className=" + className + ", methodName=" + methodName
            + ", params=" + params + ", description=" + description + ", exDetail=" + exDetail + ", exMsg=" + exMsg + "]";
    }

    
    
}
