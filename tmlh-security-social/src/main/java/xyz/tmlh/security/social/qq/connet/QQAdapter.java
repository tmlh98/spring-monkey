package xyz.tmlh.security.social.qq.connet;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

import xyz.tmlh.security.social.qq.api.QQ;
import xyz.tmlh.security.social.qq.api.QQUserInfo;

/**
 * <p>
 *    QQ的适配器,适配spring Social默认的返回信息
 * </p>
 *
 * @author TianXin
 * @since 2019年3月23日下午6:23:31
 */
public class QQAdapter implements ApiAdapter<QQ> {

    /**
     * 测试qq的api是否可用
     */
    @Override
    public boolean test(QQ api) {
        return true;
    }

    @Override
    public void setConnectionValues(QQ api, ConnectionValues values) {
        QQUserInfo userInfo = api.getUserInfo();
        
        values.setDisplayName(userInfo.getNickname());
        values.setImageUrl(userInfo.getFigureurl_1());
        values.setProfileUrl(null);//主页地址
        values.setProviderUserId(userInfo.getOpenId());
        
    }

    /**
     * 用于绑定解绑
     */
    @Override
    public UserProfile fetchUserProfile(QQ qq) {
        return null;
    }

    @Override
    public void updateStatus(QQ api, String message) {
        //do nothing
        
    }

}
