package xyz.tmlh.forum.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import xyz.tmlh.core.model.ArticleModel;
import xyz.tmlh.core.model.UserModel;
import xyz.tmlh.core.service.ArticleService;
import xyz.tmlh.core.service.UserService;
import xyz.tmlh.forum.web.vo.ArticleVo;
import xyz.tmlh.security.browser.suport.ResultBean;

/**
 * <p>
 *    文章
 * </p>
 *
 * @author TianXin
 * @since 2019年4月2日下午7:50:47
 */
@RequestMapping("/article")
@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    
    @Autowired
    private UserService userService;
    
    @ResponseBody
    @GetMapping({"/",""})
    public ResultBean list(@RequestParam(defaultValue="1")int currPage ,@RequestParam(defaultValue="10") int pageSize) {
        ResultBean resultBean = new ResultBean();
        IPage<ArticleModel> page = new Page<>(currPage, pageSize);
        QueryWrapper<ArticleModel> wapper = new QueryWrapper<ArticleModel>();
        wapper.orderByDesc("update_time");
        IPage<ArticleModel> articlePage = articleService.selectUserPage(page ,wapper);
        resultBean.putResult("articlePage", articlePage);
        return resultBean;
    }
    
    @GetMapping("/{id}")
    public String article(@PathVariable("id")Integer id , Model model) {
        ArticleModel article = articleService.getById(id);
        UserModel user = userService.getById(article.getUserId());
        //更新点击数
        articleService.updateById(new ArticleModel(id, article.getClickNum() + 1 ));
        
        model.addAttribute("article", new ArticleVo(article, user));
        LambdaQueryWrapper<ArticleModel> wapper = new LambdaQueryWrapper<ArticleModel>()
            .eq(ArticleModel::getUserId, article.getUserId())
            .select(ArticleModel::getId , ArticleModel::getTitle)
            .orderByDesc(ArticleModel::getUpdateTime)
            .last("limit 10");
        model.addAttribute("articleList", articleService.list(wapper));
        return "article";
    }
    
}
