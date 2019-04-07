package xyz.tmlh.core.mapper;

import xyz.tmlh.core.model.SocialModel;

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
    
    @Select("SELECT COUNT(user_id) FROM tbl_social WHERE follow = #{follow}")
    int selectFansCount(Integer follow);
    
}
