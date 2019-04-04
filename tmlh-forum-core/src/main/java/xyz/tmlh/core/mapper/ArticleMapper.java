package xyz.tmlh.core.mapper;


import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

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

    
    Page<ArticleModel> selectPage(@Param(Constants.WRAPPER) Wrapper<ArticleModel> wrapper);

}
