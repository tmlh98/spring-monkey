package xyz.tmlh.core.service;

import xyz.tmlh.core.model.SysLogModel;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author TianXin
 * @since 2019-04-14
 */
public interface SysLogService extends IService<SysLogModel> {

    /**
      *
      * @param @param page
      * @param @param wapper
      * @param @return    参数
      * @return IPage<SysLogModel>    返回类型
      * @throws
      */
    IPage<SysLogModel> findPage(IPage<SysLogModel> page, Wrapper<SysLogModel> wapper);

    /**
      * 首页访问量
      * @param @return    参数
      * @return Object    返回类型
      * @throws
      */
    int findHomeFlux();

}
