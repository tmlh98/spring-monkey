package xyz.tmlh.core.service;

import xyz.tmlh.core.model.CommentModel;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户评论表 服务类
 * </p>
 *
 * @author TianXin
 * @since 2019-04-06
 */
public interface CommentService extends IService<CommentModel> {

    List<CommentModel> findAll(Wrapper<CommentModel> wrapper);

}
