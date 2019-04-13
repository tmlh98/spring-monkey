package xyz.tmlh.core.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import xyz.tmlh.core.enums.PublishType;
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

    /**
      * 查询用户的文章数
      * @param @return    参数
      * @return int    返回类型
      * @throws
     */
    int selectByUser(Integer userId , PublishType publishType);
}
