package xyz.tmlh.core.service.impl;

import xyz.tmlh.core.model.MessageModel;
import xyz.tmlh.core.mapper.MessageMapper;
import xyz.tmlh.core.service.MessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author TianXin
 * @since 2019-05-08
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, MessageModel> implements MessageService {

}
