package xyz.tmlh.security;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import xyz.tmlh.security.properties.TmlhSecurityProperties;

/**  
 * @CreateInformation Created by TianXin on 2018年12月29日. 
 */
@Configuration
@EnableConfigurationProperties(TmlhSecurityProperties.class)
public class SecurityCoreConfig {

}
