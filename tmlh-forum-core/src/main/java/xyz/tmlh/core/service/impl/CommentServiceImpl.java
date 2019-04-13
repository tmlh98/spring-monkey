package xyz.tmlh.core.service.impl;

import xyz.tmlh.core.model.ArticleModel;
import xyz.tmlh.core.model.CommentModel;
import xyz.tmlh.core.model.data.CommentDo;
import xyz.tmlh.core.mapper.CommentMapper;
import xyz.tmlh.core.service.ArticleService;
import xyz.tmlh.core.service.CommentService;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private ArticleService articleService;
    
    @Override
    public List<CommentModel> findAll(Wrapper<CommentModel> wrapper) {
        return baseMapper.findAll(wrapper);
    }

    @Override
    public long selectByUser(Integer userId) {
        List<ArticleModel> articleList = articleService.list(new LambdaQueryWrapper<ArticleModel>().eq(ArticleModel::getUser, userId) );
        long count = articleList.stream().mapToInt(e ->{
            LambdaQueryWrapper<CommentModel> wrapper = new LambdaQueryWrapper<CommentModel>();
            wrapper.eq(CommentModel::getArticleId, e.getId());
            return baseMapper.selectCount(wrapper);
        }).count();
        return count;
    }

    @Override
    public IPage<CommentDo> findPage(IPage<CommentModel> page, Wrapper<CommentModel> wapper) {
        return baseMapper.selectCommentDoPage(page, wapper);
    }

}
