package xyz.tmlh.forum.core.service.impl;

import xyz.tmlh.forum.core.mapper.CommentMapper;
import xyz.tmlh.forum.core.model.ArticleModel;
import xyz.tmlh.forum.core.model.CommentModel;
import xyz.tmlh.forum.core.model.data.CommentDo;
import xyz.tmlh.forum.core.service.ArticleService;
import xyz.tmlh.forum.core.service.CommentService;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.ArrayList;
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
    public List<CommentDo> findAll(Wrapper<CommentModel> wrapper) {
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

    @Override
    public void removeCascadeById(Integer id) {
        LambdaQueryWrapper<CommentModel> wrapper = new LambdaQueryWrapper<CommentModel>();
        wrapper.eq(CommentModel::getCommentId, id);
        wrapper.select(CommentModel::getId);
        List<CommentModel> commentIds= baseMapper.selectList(wrapper);
        baseMapper.deleteById(id);
        if(!commentIds.isEmpty()) {
            int[] ids = commentIds.stream().mapToInt(e -> e.getId()).toArray();
            ArrayList<Integer> idList = new ArrayList<>();
            for (int i : ids) {
                idList.add(i);
            }
            baseMapper.deleteBatchIds(idList);
        }
        
    }

}
