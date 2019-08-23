package xyz.tmlh.security.browser.authentication.support;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.security.SocialUserDetails;
import org.springframework.social.security.SocialUserDetailsService;

import xyz.tmlh.security.core.exception.NotFoundImplementException;

/**
 * 
 * <p>
 *   不做任何处理，抛出异常
 * </p>
 *
 * @author TianXin
 * @since 2019年7月10日下午1:42:49
 */
public class DefaultUserDetailsService implements SocialUserDetailsService {
	@Override
	public SocialUserDetails loadUserByUserId(String userId) throws UsernameNotFoundException {
		throw new NotFoundImplementException("请配置 " + getClass().getSimpleName() +  "接口的实现.");
	}

}
