package xyz.tmlh.security.social.gitee.api;

/**
 * <p>
 *  GiteeUserInfo
 * </p>
 *
 * @author TianXin
 * @since 2019年4月25日下午8:06:57
 */
public class GiteeUserInfo {

//    "id": 1976774,
    private String id ;
//    "login": "tmlh98",
    private String login ;
//    "name": "TianXin",
    private String name ;
//    "avatar_url": "https://avatar.gitee.com/uploads/74/1976774_tmlh98.png?1534158392",
    private String avatar_url ;
//    "url": "https://gitee.com/api/v5/users/tmlh98",
    private String url ;
//    "html_url": "https://gitee.com/tmlh98",
    private String html_url ;
//    "followers_url": "https://gitee.com/api/v5/users/tmlh98/followers",
    private String followers_url ;
//    "following_url": "https://gitee.com/api/v5/users/tmlh98/following_url{/other_user}",
    private String following_url ;
//    "gists_url": "https://gitee.com/api/v5/users/tmlh98/gists{/gist_id}",
    private String gists_url ;
//    "starred_url": "https://gitee.com/api/v5/users/tmlh98/starred{/owner}{/repo}",
    private String starred_url ;
//    "subscriptions_url": "https://gitee.com/api/v5/users/tmlh98/subscriptions",
    private String subscriptions_url ;
//    "organizations_url": "https://gitee.com/api/v5/users/tmlh98/orgs",
    private String organizations_url ;
//    "repos_url": "https://gitee.com/api/v5/users/tmlh98/repos",
    private String repos_url ;
//    "events_url": "https://gitee.com/api/v5/users/tmlh98/events{/privacy}",
    private String events_url ;
//    "received_events_url": "https://gitee.com/api/v5/users/tmlh98/received_events",
    private String received_events_url ;
//    "type": "User",
    private String type ;
//    "site_admin": false,
    private String site_admin ;
//    "blog": "",
    private String blog ;
//    "weibo": "",
    private String weibo ;
//    "bio": "",
    private String bio ;
//    "public_repos": 1,
    private String public_repos ;
//    "public_gists": 0,
    private String public_gists ;
//    "followers": 0,
    private String followers ;
//    "following": 6,
    private String following ;
//    "stared": 1,
    private String stared ;
//    "watched": 17,
    private String watched ;
//    "created_at": "2018-06-05T19:17:05+08:00",
    private String created_at ;
//    "updated_at": "2019-04-03T21:03:55+08:00"
    private String updated_at ;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAvatar_url() {
        return avatar_url;
    }
    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getHtml_url() {
        return html_url;
    }
    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }
    public String getFollowers_url() {
        return followers_url;
    }
    public void setFollowers_url(String followers_url) {
        this.followers_url = followers_url;
    }
    public String getFollowing_url() {
        return following_url;
    }
    public void setFollowing_url(String following_url) {
        this.following_url = following_url;
    }
    public String getGists_url() {
        return gists_url;
    }
    public void setGists_url(String gists_url) {
        this.gists_url = gists_url;
    }
    public String getStarred_url() {
        return starred_url;
    }
    public void setStarred_url(String starred_url) {
        this.starred_url = starred_url;
    }
    public String getSubscriptions_url() {
        return subscriptions_url;
    }
    public void setSubscriptions_url(String subscriptions_url) {
        this.subscriptions_url = subscriptions_url;
    }
    public String getOrganizations_url() {
        return organizations_url;
    }
    public void setOrganizations_url(String organizations_url) {
        this.organizations_url = organizations_url;
    }
    public String getRepos_url() {
        return repos_url;
    }
    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }
    public String getEvents_url() {
        return events_url;
    }
    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }
    public String getReceived_events_url() {
        return received_events_url;
    }
    public void setReceived_events_url(String received_events_url) {
        this.received_events_url = received_events_url;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getSite_admin() {
        return site_admin;
    }
    public void setSite_admin(String site_admin) {
        this.site_admin = site_admin;
    }
    public String getBlog() {
        return blog;
    }
    public void setBlog(String blog) {
        this.blog = blog;
    }
    public String getWeibo() {
        return weibo;
    }
    public void setWeibo(String weibo) {
        this.weibo = weibo;
    }
    public String getBio() {
        return bio;
    }
    public void setBio(String bio) {
        this.bio = bio;
    }
    public String getPublic_repos() {
        return public_repos;
    }
    public void setPublic_repos(String public_repos) {
        this.public_repos = public_repos;
    }
    public String getPublic_gists() {
        return public_gists;
    }
    public void setPublic_gists(String public_gists) {
        this.public_gists = public_gists;
    }
    public String getFollowers() {
        return followers;
    }
    public void setFollowers(String followers) {
        this.followers = followers;
    }
    public String getFollowing() {
        return following;
    }
    public void setFollowing(String following) {
        this.following = following;
    }
    public String getStared() {
        return stared;
    }
    public void setStared(String stared) {
        this.stared = stared;
    }
    public String getWatched() {
        return watched;
    }
    public void setWatched(String watched) {
        this.watched = watched;
    }
    public String getCreated_at() {
        return created_at;
    }
    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }
    public String getUpdated_at() {
        return updated_at;
    }
    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
    
    
    
}
