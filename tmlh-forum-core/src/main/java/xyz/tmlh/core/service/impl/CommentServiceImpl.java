package xyz.tmlh.core.service.impl;

import xyz.tmlh.core.model.CommentModel;
import xyz.tmlh.core.mapper.CommentMapper;
import xyz.tmlh.core.service.CommentService;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户评论表 服务实现类
 * </p>
 *
 * @author TianXin
 * @since 2019-04-06
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, CommentModel> implements CommentService {

    @Override
    public List<CommentModel> findAll(Wrapper<CommentModel> wrapper) {
        return baseMapper.findAll(wrapper);
    }

}
