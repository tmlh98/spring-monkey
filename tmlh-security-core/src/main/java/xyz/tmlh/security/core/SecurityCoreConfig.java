package xyz.tmlh.security.core;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import xyz.tmlh.security.core.properties.TmlhSecurityProperties;

/**
 * 
 * <p>
 *   SecurityCoreConfig
 * </p>
 *
 * @author TianXin
 * @since 2018年12月29日下午1:50:59
 */
@Configuration
@EnableConfigurationProperties(TmlhSecurityProperties.class)
public class SecurityCoreConfig {

}
