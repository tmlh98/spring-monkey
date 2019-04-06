package xyz.tmlh.core.mapper;

import xyz.tmlh.core.model.CommentModel;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;

/**
 * <p>
 * 用户评论表 Mapper 接口
 * </p>
 *
 * @author TianXin
 * @since 2019-04-06
 */
public interface CommentMapper extends BaseMapper<CommentModel> {

    List<CommentModel> findAll(@Param(Constants.WRAPPER) Wrapper<CommentModel> wrapper);

}
