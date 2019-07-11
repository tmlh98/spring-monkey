package xyz.tmlh.forum.core.service.impl;

import xyz.tmlh.forum.core.mapper.SocialMapper;
import xyz.tmlh.forum.core.model.SocialModel;
import xyz.tmlh.forum.core.model.data.SocialDo;
import xyz.tmlh.forum.core.service.SocialService;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author TianXin
 * @since 2019-04-07
 */
@Service
public class SocialServiceImpl extends ServiceImpl<SocialMapper, SocialModel> implements SocialService {

    @Override
    public int selectFollowCount(Integer userId) {
        return baseMapper.selectFollowCount(userId);
    }
    @Override
    public int selectFansCount(Integer follow) {
        return baseMapper.selectFansCount(follow);
    }
    
    @Override
    public boolean selectFollow(Integer userId, Integer id) {
        LambdaQueryWrapper<SocialModel> wrapper = new LambdaQueryWrapper<SocialModel>();;
        wrapper.eq(SocialModel::getUserId, userId);
        wrapper.eq(SocialModel::getFollow, id);
        return baseMapper.selectOne(wrapper ) != null;
    }
    
    @Override
    public List<SocialDo> selectFollowList(Integer userId) {
        return baseMapper.selectFollowList(userId);
    }
     
    @Override
    public List<SocialDo> selectFansList(Integer userId) {
        return baseMapper.selectFansList(userId);
    }
    
    @Override
    public boolean checkFollwe(Integer id) {
        LambdaQueryWrapper<SocialModel> wrapper = Wrappers.lambdaQuery();
        SocialModel socialModel = baseMapper.selectOne(wrapper.eq(SocialModel::getFollow, id));
        if(socialModel == null) {
            return false;
        }
        return true;
    }

}
