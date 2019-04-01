package xyz.tmlh.security.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurerAdapter;
import org.springframework.social.security.SpringSocialConfigurer;

import xyz.tmlh.security.properties.SecurityProperties;

/**
 * <p>
 * 社交配置主类
 * </p>
 *
 * @author TianXin
 * @since 2019年3月23日下午6:36:37
 */
@Configuration
@EnableSocial
public class SocialConfig extends SocialConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Bean
    public SpringSocialConfigurer tmlhSpringSocialConfigurer() {
        String filterProcessesUrl = securityProperties.getSocial().getFilterProcessesUrl();
        TmlhSpringSocialConfigurer configurer = new TmlhSpringSocialConfigurer(filterProcessesUrl);

        configurer.signupUrl(securityProperties.getBrowser().getSignUpUrl());
        return configurer;
    }

}
