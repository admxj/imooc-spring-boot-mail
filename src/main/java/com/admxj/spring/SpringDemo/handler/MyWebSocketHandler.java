package com.admxj.spring.SpringDemo.handler;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

import java.util.ArrayList;
import java.util.Map;

@Component
public class MyWebSocketHandler implements WebSocketHandler {

    private Logger logger = Logger.getLogger(this.getClass());

    public static final ArrayList<WebSocketSession> userSocketSessionMap;

    static {
        userSocketSessionMap = new ArrayList<WebSocketSession>();
    }


    //建立连接后
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception{
        logger.info("建立连接");
        userSocketSessionMap.add(session);
    }

    //消息处理，在客户端通过Websocket API发送的消息会经过这里，然后进行相应的处理
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {

        Map<String, Object> attributes = session.getAttributes();
        String id = (String) attributes.get("id");

        String msg=message.getPayload().toString();

        for (WebSocketSession webSocketSession : userSocketSessionMap)
            webSocketSession.sendMessage(new TextMessage(msg));

        logger.info("id: "+id+" 消息列表: " + msg);
    }

    //消息传输错误处理
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {

    }

    //关闭连接后
    @Override
    public void afterConnectionClosed(WebSocketSession session,
                                      CloseStatus closeStatus) throws Exception {
        logger.info("connect websocket closed.......");
        userSocketSessionMap.remove(session);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }

}
