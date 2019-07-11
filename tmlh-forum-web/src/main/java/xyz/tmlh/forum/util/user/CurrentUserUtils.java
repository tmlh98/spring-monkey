package xyz.tmlh.forum.util.user;

import xyz.tmlh.core.model.UserModel;
import xyz.tmlh.forum.util.scope.SessionUtil;
import xyz.tmlh.security.core.exception.UserNotFoundException;

/**
 * <p>
 *    获取当前用户信息
 * </p>
 *
 * @author TianXin
 * @since 2019年3月26日下午4:25:21
 */
public class CurrentUserUtils {
    
    public static final String CURR_LOGIN_USER = "loginUser";
    
    /**
     * 获取当前系统用户名
     *
     * @param @return    参数
     * @return String    返回类型
     * @throws
     */
    public static String getUserName() {
        return getUser().getUsername();
    }
    /**
     * 获取当前系统id
     *
     * @param @return    参数
     * @return String    返回类型
     * @throws
     */
    public static Integer getUserId() {
        return getUser().getId();
    }
    
    /**
     * 获取 UserModel
      *
      * @param @return    参数
      * @return UserModel    返回类型
      * @throws
     */
    public static UserModel getUser() {
        Object user = SessionUtil.getAttribute(CURR_LOGIN_USER);
        if(null == user) {
            throw new UserNotFoundException("user not found ！");
        }
        return (UserModel)user;  
    }
    
    /**
     * 向session 中设置用户
     *
     * @throws
     */
    public static void setUser(UserModel user) {
        SessionUtil.setAttribute(CURR_LOGIN_USER, user);
    }
    
    /**
     * 从session 中删除
     * 
     * @throws
     */
    public static void removeUser() {
        SessionUtil.remove(CURR_LOGIN_USER);
    }
    
    /**
     * 用户是否存在
      *
      * @param @return    参数
      * @return boolean    返回类型
      * @throws
     */
    public static boolean isExistUser() {
        return SessionUtil.getAttribute(CURR_LOGIN_USER) != null;
    }
    
}
