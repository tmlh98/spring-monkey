package xyz.tmlh.security.core.properties.social;

/**
 * <p>
 *  social 配置   
 * </p>
 *
 * @author TianXin
 * @since 2019年3月22日上午11:39:40
 */
public class SocialProperties {
	
	private String filterProcessesUrl = "/auth";

	private QQProperties qq = new QQProperties();
	
	private GitHubProperties github = new GitHubProperties();
	
	private GiteeProperties gitee = new GiteeProperties();

	public QQProperties getQq() {
		return qq;
	}

	public void setQq(QQProperties qq) {
		this.qq = qq;
	}

	public String getFilterProcessesUrl() {
		return filterProcessesUrl;
	}

	public void setFilterProcessesUrl(String filterProcessesUrl) {
		this.filterProcessesUrl = filterProcessesUrl;
	}

    public GitHubProperties getGithub() {
        return github;
    }

    public void setGithub(GitHubProperties github) {
        this.github = github;
    }

    public GiteeProperties getGitee() {
        return gitee;
    }

    public void setGitee(GiteeProperties gitee) {
        this.gitee = gitee;
    }
	

}
