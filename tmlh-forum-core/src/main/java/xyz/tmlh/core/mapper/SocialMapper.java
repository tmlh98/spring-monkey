package xyz.tmlh.core.mapper;

import xyz.tmlh.core.model.SocialModel;
import xyz.tmlh.core.model.data.SocialDo;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author TianXin
 * @since 2019-04-07
 */
public interface SocialMapper extends BaseMapper<SocialModel> {
    
    @Select("SELECT COUNT(follow) FROM tbl_social WHERE user_id = #{userId}")
    int selectFollowCount(Integer userId);
    
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

    
    @Select("SELECT COUNT(user_id) FROM tbl_social WHERE follow = #{follow}")
    int selectFansCount(Integer follow);
    
}
