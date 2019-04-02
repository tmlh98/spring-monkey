package xyz.tmlh.forum.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * <p>
 *    获取当前用户信息
 * </p>
 *
 * @author TianXin
 * @since 2019年3月26日下午4:25:21
 */
public class SecurityUserUtils {

    /**
     * 获取当前系统用户名
      *
      * @param @return    参数
      * @return String    返回类型
      * @throws
     */
    public String getUserName() {
        return getUserDetails().getUsername();
    }
    
    /**
     * 获取 UserDetails
      *
      * @param @return    参数
      * @return UserDetails    返回类型
      * @throws
     */
    public UserDetails getUserDetails() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();  
    }
    
    
}
