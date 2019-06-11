package xyz.tmlh.core.service;

import xyz.tmlh.core.model.SocialModel;
import xyz.tmlh.core.model.data.SocialDo;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author TianXin
 * @since 2019-04-07
 */
public interface SocialService extends IService<SocialModel> {

    /**
     * 用户关注人数
      *
      * @param @param userId
      * @param @param relationType
      * @param @return    参数
      * @return int    返回类型
      * @throws
     */
    int selectFollowCount(Integer userId);
    
    
    /**
     * 用户粉丝的人数
     *
     * @param @param userId
     * @param @param relationType
     * @param @return    参数
     * @return int    返回类型
     * @throws
     */
    int selectFansCount(Integer follow);

    /**
      *是否关注
      * @param @param user
      * @param @param id
      * @param @return    参数
      * @return boolean    返回类型
      * @throws
      */
    boolean selectFollow(Integer userId, Integer id);
    
    
    /**
     * 查询用户的关注列表
      *
      * @param @param userId
      * @param @return    参数
      * @return int    返回类型
      * @throws
     */
    List<SocialDo> selectFollowList(Integer userId);
    
    /**
     * 查询用户的粉丝列表
      *
      * @param @param userId
      * @param @return    参数
      * @return List<UserModel>    返回类型
      * @throws
     */
    List<SocialDo> selectFansList(Integer userId);


    /**
      * 检查是否已经关注用户
      *
      * @param @param id 被关注用户id
      * @param @return    参数
      * @return boolean    返回类型
      * @throws
      */
    boolean checkFollwe(Integer id);
    
}
