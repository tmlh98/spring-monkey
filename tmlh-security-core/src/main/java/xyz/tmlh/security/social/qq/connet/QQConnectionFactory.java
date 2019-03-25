package xyz.tmlh.security.social.qq.connet;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;

import xyz.tmlh.security.social.qq.api.QQ;

/**
 * <p>
 *    QQ的连接工厂
 * </p>
 *
 * @author TianXin
 * @since 2019年3月23日下午6:33:59
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ> {

    public QQConnectionFactory(String providerId, String appId , String appSecret) {
        super(providerId, new QQServiceProvider(appId, appSecret), new QQAdapter());
    }

}
