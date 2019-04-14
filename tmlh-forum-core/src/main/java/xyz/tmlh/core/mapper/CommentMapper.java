package xyz.tmlh.core.mapper;

import xyz.tmlh.core.model.CommentModel;
import xyz.tmlh.core.model.data.CommentDo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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

    List<CommentDo> findAll(@Param(Constants.WRAPPER) Wrapper<CommentModel> wrapper);

    IPage<CommentDo> selectCommentDoPage(IPage<CommentModel> page, @Param(Constants.WRAPPER) Wrapper<CommentModel> wapper);

    
}
