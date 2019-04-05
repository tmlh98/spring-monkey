package xyz.tmlh.core.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import xyz.tmlh.core.model.ArticleModel;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author TianXin
 * @since 2019-04-01
 */
public interface ArticleService extends IService<ArticleModel> {

    IPage<ArticleModel> selectUserPage(IPage<ArticleModel> page, Wrapper<ArticleModel> wapper);

}
