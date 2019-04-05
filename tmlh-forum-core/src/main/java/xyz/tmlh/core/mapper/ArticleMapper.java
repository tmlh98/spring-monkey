package xyz.tmlh.core.mapper;


import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;

import xyz.tmlh.core.model.ArticleModel;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author TianXin
 * @since 2019-04-01
 */
public interface ArticleMapper extends BaseMapper<ArticleModel> {

    IPage<ArticleModel> selectUserPage(IPage<ArticleModel> page,@Param(Constants.WRAPPER)  Wrapper<ArticleModel> wapper);

}
