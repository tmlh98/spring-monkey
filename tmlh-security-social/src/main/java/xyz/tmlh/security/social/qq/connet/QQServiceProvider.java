package xyz.tmlh.security.social.qq.connet;

import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

import xyz.tmlh.security.social.qq.api.QQ;
import xyz.tmlh.security.social.qq.api.QQImpl;

/**
 * <p>
 *    QQ服务的供应商处理,连接服务提供商</br>
 *    <S> QQ Api 
 * </p>
 *
 * @author TianXin
 * @since 2019年3月23日下午6:08:56
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ>{

    private String appId;
    
    private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";
    
    /**
     * 获取access_token 也就是令牌
     */
    private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

    public QQServiceProvider(String appId ,String appSecret) {
        super(new QQOAuth2Template(appId, appSecret, URL_AUTHORIZE, URL_ACCESS_TOKEN));
        this.appId = appId;
    }

    /**
     * 返回qq的实现 , 多实例
     */
    @Override
    public QQ getApi(String accessToken) {
        return new QQImpl(accessToken, appId);
    }

}
