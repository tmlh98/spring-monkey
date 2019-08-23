package xyz.tmlh.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * <p>
 *      定制filterProcessesUrl
 * </p>
 *
 * @author TianXin
 * @since 2019年3月23日下午8:09:19
 */
public class TmlhSpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public TmlhSpringSocialConfigurer(String filterProcessesUrl) {
        this.filterProcessesUrl = filterProcessesUrl;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter)super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        return (T)filter;
    }
}
