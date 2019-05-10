package xyz.tmlh.security.social.gitee.api;

import org.springframework.social.ApiBinding;

/**
 * <p>
 *  Gitee APi   
 * </p>
 *
 * @author TianXin
 * @since 2019年4月25日下午8:04:37
 */
public interface Gitee extends ApiBinding{

    GiteeUserInfo getUserInfo();
    
}
