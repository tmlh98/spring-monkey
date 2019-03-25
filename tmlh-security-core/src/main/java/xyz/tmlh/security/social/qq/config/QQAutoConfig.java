package xyz.tmlh.security.social.qq.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactory;

import xyz.tmlh.security.properties.QQProperties;
import xyz.tmlh.security.properties.SecurityProperties;
import xyz.tmlh.security.social.qq.connet.QQConnectionFactory;

/**
 * <p>
 *    QQ登陆的配置类</br>
 *    当配置了tmlh.security.social.qq.app-id才希望生效
 * </p>
 *
 * @author TianXin
 * @since 2019年3月22日上午11:41:29
 */
@Configuration
@ConditionalOnProperty(prefix = "tmlh.security.social.qq", name = "appId")
public class QQAutoConfig extends SocialAutoConfigurerAdapter {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(QQAutoConfig.class);
    
	@Autowired
	private SecurityProperties securityProperties;

	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
	    LOGGER.info("QQ登陆配置生效!");
	    QQProperties qqConfig = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
	}

}
