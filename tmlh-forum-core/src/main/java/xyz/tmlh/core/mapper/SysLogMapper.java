package xyz.tmlh.core.mapper;

import xyz.tmlh.core.model.SysLogModel;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author TianXin
 * @since 2019-04-14
 */
public interface SysLogMapper extends BaseMapper<SysLogModel> {

    /**
      * 自定义查询
      * @param @param page
      * @param @param wapper
      * @param @return    参数
      * @return IPage<SysLogModel>    返回类型
      * @throws
      */
    IPage<SysLogModel> findPage(IPage<SysLogModel> page,@Param(Constants.WRAPPER) Wrapper<SysLogModel> wapper);

}
