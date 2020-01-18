package com.admxj.spring.boot.handler;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketConnectionManager;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class WebSocketTest {
    //服务器WebSocket 连接地址
    private static final String WS_URI = "ws://localhost:8080/counter?collector=1";

    public static void main(String[] args) throws IOException, InterruptedException {
        StandardWebSocketClient client = new StandardWebSocketClient();
        WebSocketConnectionManager manager = new WebSocketConnectionManager(client, new MyHandler(), WS_URI);
        manager.start();
        Thread.sleep(100000);
    }

    private static class MyHandler extends TextWebSocketHandler {
        @Override
        public void afterConnectionEstablished(WebSocketSession session) throws Exception {
            System.out.println("connected...........");
            session.sendMessage(new TextMessage("hello, web socket"));
            super.afterConnectionEstablished(session);
        }

        @Override
        protected void handleTextMessage(WebSocketSession session, TextMessage message)
                throws Exception {
            System.out.println("receive: " + message.getPayload());
            super.handleTextMessage(session, message);
        }
    }
}