package xyz.tmlh.security.social.qq.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.social.SocialAutoConfigurerAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.social.connect.ConnectionFactory;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;

import xyz.tmlh.security.properties.QQProperties;
import xyz.tmlh.security.properties.SecurityProperties;
import xyz.tmlh.security.social.qq.connet.QQConnectionFactory;
/*
 * 需要预先建立表
 * create table UserConnection (userId varchar(255) not null,
    providerId varchar(255) not null,
    providerUserId varchar(255),
    rank int not null,
    displayName varchar(255),
    profileUrl varchar(512),
    imageUrl varchar(512),
    accessToken varchar(512) not null,
    secret varchar(512),
    refreshToken varchar(512),
    expireTime bigint,
    primary key (userId, providerId, providerUserId));
    create unique index UserConnectionRank on UserConnection(userId, providerId, rank);
 * 
 */
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
	
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private ConnectionSignUp myConnectionSignUp;

	@Override
	protected ConnectionFactory<?> createConnectionFactory() {
	    LOGGER.info("QQ登陆配置生效!");
	    QQProperties qqConfig = securityProperties.getSocial().getQq();
        return new QQConnectionFactory(qqConfig.getProviderId(), qqConfig.getAppId(), qqConfig.getAppSecret());
	}
	
    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
        JdbcUsersConnectionRepository repository = 
            new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, Encryptors.noOpText());
        repository.setTablePrefix("tbl_");
        if(myConnectionSignUp != null) {
            repository.setConnectionSignUp(myConnectionSignUp);
        }
        return repository;
    }

}
