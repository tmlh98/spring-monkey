package xyz.tmlh.forum.core.mapper;

import xyz.tmlh.forum.core.model.MessageModel;
import xyz.tmlh.forum.core.model.data.MessageDo;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author TianXin
 * @since 2019-05-08
 */
public interface MessageMapper extends BaseMapper<MessageModel> {

    /**
      *
      * @param @param wrapper
      * @param @return    参数
      * @return List<MessageDo>    返回类型
      * @throws
      */
    List<MessageDo> selectDoList( @Param(Constants.WRAPPER) Wrapper<MessageModel> wrapper);

}
