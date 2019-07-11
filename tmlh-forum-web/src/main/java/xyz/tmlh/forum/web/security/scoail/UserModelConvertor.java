package xyz.tmlh.forum.web.security.scoail;

import org.springframework.social.connect.Connection;

import xyz.tmlh.forum.core.model.UserModel;

/**
 * <p>
 *    社交数据用户信息转化器
 * </p>
 *
 * @author TianXin
 * @since 2019年6月15日下午8:45:12
 */
public interface UserModelConvertor {

    String SUFFIX_BEANNAME = "UserModelConvertor";
    
    /**
     * 将Connection转化为UserModel
      *
      * @param @param connection
      * @param @return    参数
      * @return UserModel    返回类型
      * @throws
     */
    UserModel conver(Connection<?> connection);
    
    
}
