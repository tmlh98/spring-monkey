package xyz.tmlh.forum.web.controller.admin;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import xyz.tmlh.forum.core.model.SysLogModel;
import xyz.tmlh.forum.core.service.SysLogService;
import xyz.tmlh.security.browser.suport.ResultBean;

/**
 * <p>
 *    系统日志管理
 * </p>
 *
 * @author TianXin
 * @since 2019年4月14日下午10:02:06
 */

@Api("系统日志管理")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/sys/log")
@RestController
public class SysLogController {
    
    @Autowired
    private SysLogService sysLogService;

    @ApiOperation("系统日志列表搜索")
    @GetMapping("/page")
    public ResultBean userPage(@RequestParam(defaultValue = "1")int currPage ,
            @RequestParam(defaultValue="10") int pageSize , SysLogModel sysLog) {
        IPage<SysLogModel> page = new Page<>(currPage, pageSize);
        QueryWrapper<SysLogModel> wapper = new QueryWrapper<SysLogModel>();
        if(sysLog != null && StringUtils.isNotBlank(sysLog.getUsername())) {
            wapper.like("u.username", sysLog.getUsername());
        }
        if(sysLog != null && StringUtils.isNotBlank(sysLog.getUrl())) {
            wapper.like("l.url", sysLog.getUrl());
        }
        wapper.orderByDesc("l.create_time");
        
        IPage<SysLogModel> sysLogPage = sysLogService.findPage(page , wapper);
        return ResultBean.success().putResult("sysLogPage", sysLogPage);
    }
    
}
