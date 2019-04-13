package xyz.tmlh.core.service.impl;

import xyz.tmlh.core.model.AdminModel;
import xyz.tmlh.core.mapper.AdminMapper;
import xyz.tmlh.core.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author TianXin
 * @since 2019-04-13
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, AdminModel> implements AdminService {

}
