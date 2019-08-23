package xyz.tmlh.forum.core.service.impl;

import xyz.tmlh.forum.core.mapper.SysLogMapper;
import xyz.tmlh.forum.core.model.SysLogModel;
import xyz.tmlh.forum.core.service.SysLogService;
import xyz.tmlh.forum.core.support.SysUrlConstans;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.Arrays;

import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author TianXin
 * @since 2019-04-14
 */
@Service
public class SysLogServiceImpl extends ServiceImpl<SysLogMapper, SysLogModel> implements SysLogService {
    
    @Override
    public IPage<SysLogModel> findPage(IPage<SysLogModel> page, Wrapper<SysLogModel> wapper) {
        return baseMapper.findPage(page, wapper);
    }

    @Override
    public int findHomeFlux() {
        LambdaQueryWrapper<SysLogModel> queryWrapper = new LambdaQueryWrapper<SysLogModel>();
        queryWrapper.in(SysLogModel::getUrl, Arrays.asList(SysUrlConstans.INDEX_1,SysUrlConstans.INDEX_2,SysUrlConstans.INDEX_3));
        return baseMapper.selectCount(queryWrapper );
    }

}
