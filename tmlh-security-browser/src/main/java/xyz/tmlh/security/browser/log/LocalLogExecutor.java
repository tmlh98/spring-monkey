package xyz.tmlh.security.browser.log;

/**
 * <p>
 *    实现此接口将日志同步到数据库
 * </p>
 *
 * @author TianXin
 * @since 2019年7月11日下午12:30:06
 */
public interface LocalLogExecutor {

    /**
     * 将日志同步到数据库
      *
      * @param @param sysLog    参数
      * @return void    返回类型
      * @throws
     */
    void saveLog(ISysLogTemplate sysLog);
    
}
