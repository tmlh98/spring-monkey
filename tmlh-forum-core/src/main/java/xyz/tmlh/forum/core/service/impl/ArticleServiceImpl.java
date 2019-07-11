package xyz.tmlh.forum.core.service.impl;

import xyz.tmlh.forum.core.enums.PublishType;
import xyz.tmlh.forum.core.mapper.ArticleMapper;
import xyz.tmlh.forum.core.model.ArticleModel;
import xyz.tmlh.forum.core.service.ArticleService;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author TianXin
 * @since 2019-04-01
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, ArticleModel> implements ArticleService {

    @Override
    public IPage<ArticleModel> selectUserPage(IPage<ArticleModel> page, Wrapper<ArticleModel> wapper) {
        return baseMapper.selectUserPage(page, wapper);
    }

    @Override
    public int selectByUser(Integer userId, PublishType publishType) {
        LambdaQueryWrapper<ArticleModel> wapper = new LambdaQueryWrapper<ArticleModel>();
        wapper.eq(ArticleModel::getUser, userId);
        if(publishType != null) {
            wapper.eq(ArticleModel::getPublishType, publishType);
        }
        return baseMapper.selectCount(wapper);
    }

}
