package com.admxj.spring.boot.interceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

/**
 * Socket建立连接（握手）和断开
 *
 * @author admxj
 * @Date 2018年04月07日22:23:48
 */
public class HandShakeInterceptor implements HandshakeInterceptor {

    // 握手前
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        String uid = ((ServletServerHttpRequest) request).getServletRequest().getParameter("uid");
        System.out.println("Websocket:用户[ID:" + uid + "]已经建立连接");
        attributes.put("id",uid);
        return true;
    }

    // 握手后
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }

}

