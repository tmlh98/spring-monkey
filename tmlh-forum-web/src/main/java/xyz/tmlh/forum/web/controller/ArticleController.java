package xyz.tmlh.forum.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import xyz.tmlh.core.model.ArticleModel;
import xyz.tmlh.core.service.ArticleService;

/**
 * <p>
 *    文章
 * </p>
 *
 * @author TianXin
 * @since 2019年4月2日下午7:50:47
 */
@Controller("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    
    @GetMapping
    public String list(int currPage , int pageSize , Model model) {
        
        IPage<ArticleModel> page = new Page<>(currPage, pageSize);
        LambdaQueryWrapper<ArticleModel> wapper = new LambdaQueryWrapper<ArticleModel>();
        wapper.orderByDesc(ArticleModel::getUpdateTime);
        IPage<ArticleModel> articlePage = articleService.page(page ,wapper );
        
        model.addAttribute("articlePage", articlePage);
        return "index";
    }
    
    
    
    
}
