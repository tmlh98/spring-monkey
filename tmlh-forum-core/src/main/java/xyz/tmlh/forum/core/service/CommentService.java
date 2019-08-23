package xyz.tmlh.forum.core.service;

import xyz.tmlh.forum.core.model.CommentModel;
import xyz.tmlh.forum.core.model.data.CommentDo;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
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

    List<CommentDo> findAll(Wrapper<CommentModel> wrapper);
    
    IPage<CommentDo> findPage(IPage<CommentModel> page, Wrapper<CommentModel> wapper);


    /**
      * 查询用户所有的评论数
      * @param @param id
      * @param @return    参数
      * @return Object    返回类型
      * @throws
      */
    long selectByUser(Integer userId);

    /**
      *删除评论及子评论
      * @param @param id    参数
      * @return void    返回类型
      * @throws
      */
    void removeCascadeById(Integer id);

}
