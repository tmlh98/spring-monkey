package xyz.tmlh.core.model.data;

import xyz.tmlh.core.model.UserModel;

/**
 * <p>
 *    
 * </p>
 *
 * @author TianXin
 * @since 2019年4月7日下午1:09:09
 */
public class SocialDo {
    
    /**
     * 当前用户
     */
    private UserModel user;
    
    private UserModel relationUser;

    public UserModel getUser() {
        return user;
    }

    public void setUser(UserModel user) {
        this.user = user;
    }

    public UserModel getRelationUser() {
        return relationUser;
    }

    public void setRelationUser(UserModel relationUser) {
        this.relationUser = relationUser;
    }

    
}
