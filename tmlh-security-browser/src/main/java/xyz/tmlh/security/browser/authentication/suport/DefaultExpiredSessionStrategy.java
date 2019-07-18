package xyz.tmlh.security.browser.authentication.suport;

import java.io.IOException;

import javax.servlet.ServletException;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * <p>
 *    session并发登录失效策略
 * </p>
 *
 * @author TianXin
 * @since 2019年7月15日下午3:31:00
 */
public class DefaultExpiredSessionStrategy implements SessionInformationExpiredStrategy {

    @Override
    public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
        System.out.println("session 失效...");
    }

}
