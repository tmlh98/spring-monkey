package xyz.tmlh.security.core.properties.social;


/**
 * <p>
 *      github配置类    
 * </p>
 *
 * @author TianXin
 * @since 2019年3月22日上午11:38:28
 */
public class GitHubProperties extends AppSocialProperties{

    /* (非 Javadoc) 
     * <p>Title: getProviderId</p> 
     * <p>Description: </p> 
     * @return 
     * @see xyz.tmlh.security.properties.social.AppSocialProperties#getProviderId() 
     */ 
    @Override
    public String getProviderId() {
        return "github";
    }
	
	 
	
}
