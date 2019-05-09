package xyz.tmlh.forum.web.suport;

import java.util.HashMap;
import java.util.Map;

import xyz.tmlh.forum.web.socket.TmlhWebSocket;

/**
 * <p>
 *    登陆的用户详情
 * </p>
 *
 * @author TianXin
 * @since 2019年5月8日下午7:36:13
 */
public class LoginUsers {
    
    public static Map<Integer , TmlhWebSocket> userMap = new HashMap<>();
    
    /**
     * 当前在线人数
      *
      * @param @return    参数
      * @return int    返回类型
      * @throws
     */
    public static int size() {
        return userMap.size();
    }
    
    /**
     * 根据用户id判断当前用户是否在线
      *
      * @param @param userModel
      * @param @return    参数
      * @return boolean    返回类型
      * @throws
     */
    public static boolean contains(Integer id) {
        return userMap.containsKey(id);
    }
    
}
