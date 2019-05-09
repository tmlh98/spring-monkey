package xyz.tmlh.forum.web.socket;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import xyz.tmlh.forum.util.user.CurrentUserUtils;
import xyz.tmlh.forum.web.WebConstans;
import xyz.tmlh.forum.web.suport.LoginUsers;

/**
 * <p>
 *    监听网站在线人数,及分发消息
 * </p>
 *
 * @author TianXin
 * @since 2019年5月8日下午6:45:24
 */
@Component
@ServerEndpoint(value = WebConstans.URL_WEBSOCKET ,configurator = HttpSessionConfigurator.class) 
public class TmlhWebSocket {
    
    private static final Logger logger = LoggerFactory.getLogger(TmlhWebSocket.class);

    // 保存所有在线socket连接
    private Map<String, TmlhWebSocket> webSocketMap = new LinkedHashMap<>();
    
    // 当前连接（每个websocket连入都会创建一个MyWebSocket实例
    private Session session;

    //创建连接
    @OnOpen
    public void onOpen(Session session ,EndpointConfig config) {
        this.session = session;
        webSocketMap.put(session.getId(), this);
        
        HttpSession httpSession= (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        if(httpSession.getAttribute(CurrentUserUtils.CURR_LOGIN_USER)!= null) {
            LoginUsers.userMap.put(CurrentUserUtils.getUserId() , this);
        }
    }

    // 接受消息
    @OnMessage
    public void onMessage(String message, Session session) {
        logger.info("收到客户端{}消息：{}", session.getId(), message);
    }

    // 处理错误
    @OnError
    public void onError(Throwable error, Session session) {
        logger.info("发生错误{},{}", session.getId(), error.getMessage());
    }

    // 处理连接关闭
    @OnClose
    public void onClose() {
        webSocketMap.remove(this.session.getId());
        if(CurrentUserUtils.isExistUser()) {
            LoginUsers.userMap.remove(CurrentUserUtils.getUserId());
        }
    }

    // 发送消息
    public  void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    // 广播消息
    public void broadcast(String message) {
        webSocketMap.forEach((k, v) -> {
            try {
                v.sendMessage(message);
            } catch (Exception e) {
                if(logger.isErrorEnabled()) {
                    logger.error(e.getLocalizedMessage() , e);
                }
            }
        });
    }
    
}
