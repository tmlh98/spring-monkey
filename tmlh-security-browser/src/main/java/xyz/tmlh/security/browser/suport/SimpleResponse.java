package xyz.tmlh.security.browser.suport;

/**
 * 简单的响应页面
 * 
 * Created by TianXin on 2018年12月29日.
 */
public class SimpleResponse {

    private Object content;

    public SimpleResponse(Object content) {
        this.content = content;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}
