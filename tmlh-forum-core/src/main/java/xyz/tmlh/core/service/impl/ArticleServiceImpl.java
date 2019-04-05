package xyz.tmlh.core.service.impl;

import xyz.tmlh.core.mapper.ArticleMapper;
import xyz.tmlh.core.model.ArticleModel;
import xyz.tmlh.core.service.ArticleService;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
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

}
