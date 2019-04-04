package xyz.tmlh.forum.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import xyz.tmlh.core.model.ArticleModel;
import xyz.tmlh.core.service.ArticleService;
import xyz.tmlh.security.browser.suport.ResultBean;

/**
 * <p>
 *    文章
 * </p>
 *
 * @author TianXin
 * @since 2019年4月2日下午7:50:47
 */
@Controller("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    
    @ResponseBody
    @GetMapping("/")
    public ResultBean list(@RequestParam(defaultValue="1")int currPage ,@RequestParam(defaultValue="10") int pageSize) {
        ResultBean resultBean = new ResultBean();
        IPage<ArticleModel> page = new Page<>(currPage, pageSize);
        QueryWrapper<ArticleModel> wapper = new QueryWrapper<ArticleModel>();
        wapper.orderByDesc("update_time");
        IPage<ArticleModel> articlePage = articleService.page(page ,wapper);
        resultBean.putResult("articlePage", articlePage);
        return resultBean;
    }
    
    
    
}
