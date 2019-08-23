package xyz.tmlh.forum.web.security;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUser;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import xyz.tmlh.forum.core.enums.StatusEnum;
import xyz.tmlh.forum.core.model.AdminModel;
import xyz.tmlh.forum.core.model.UserModel;
import xyz.tmlh.forum.core.service.AdminService;
import xyz.tmlh.forum.core.service.UserService;
import xyz.tmlh.forum.web.util.user.CurrentUserUtils;
import xyz.tmlh.security.browser.log.SysLog;

/**
 * <p>
 *    用户登陆以后的操作
 * </p>
 *
 * @author TianXin
 * @since 2019年3月24日上午12:34:31
 */
@Component 
public class MyUserDetailsService implements UserDetailsService, SocialUserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MyUserDetailsService.class);
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private AdminService adminService;
    
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOGGER.info("表单登录用户名:" + username);
        AdminModel loginAdmin = adminService.getOne(new LambdaQueryWrapper<AdminModel>().eq(AdminModel::getUsername, username));
        if(loginAdmin == null) {
            throw new UsernameNotFoundException("找不到该账户信息！");//抛出异常，会根据配置跳到登录失败页面
        }
        
        LOGGER.info("username: {} , password :{}" , username , loginAdmin.getPassword());
        
        Collection<? extends GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        return new User(username, loginAdmin.getPassword(), true,true,true,true,authorities);
    }

    @SysLog
    @Override
    public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
        UserModel user = userService.getOne(new LambdaQueryWrapper<UserModel>()
            .eq(UserModel::getUserconnectionId, userId));
        if(StatusEnum.NORMAL != user.getState()) {
            throw new UsernameNotFoundException("该用户已被冻结!");
        }
        CurrentUserUtils.setUser(user);
        
        userService.updateById(new UserModel(user.getId() , user.getLastLogin()));
        
        LOGGER.info("社交登录用户 : {} 登陆成功" , user.getUsername());
        return new SocialUser(userId, "0",
            true, true, true, true,
            AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER"));
    }


}
