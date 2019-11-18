package com.ysd.boot.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * WebSocket服务配置类
 *
 */
// @Component //非单例模式bean
@Configuration // 单例模式bean
@EnableWebSocket // 启动WebSocket服务器
//public class SpringBootWebSocketConfigurer extends WebMvcConfigurerAdapter implements WebSocketConfigurer{ //SpringBoot1.0系列用法
public class SpringBootWebSocketConfigurer implements WebMvcConfigurer, WebSocketConfigurer { // SpringBoot2.0系列用法

	@Autowired
	private SpringBootWebSocketHandler handler;
	@Autowired
	private SpringBootHandshakeInterceptor handshakeInterceptor;

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		// -------------------- 允许跨域访问WebSocket ------------------------
		String[] allowsOrigins = { "*" };// 允许连接的域,只能以http或https开头
		/**
		 * http://localhost:8080 http://localhost:8080/index.html
		 */
		// 7. 设置websocket服务器地址 ws://localhost:8080/SpringBootWebSocket
		registry.addHandler(handler, "/SpringBootWebSocket").addInterceptors(handshakeInterceptor)
				.setAllowedOrigins(allowsOrigins);
//		registry.addHandler(handler, "/SpringBootWebSocket/sockjs").addInterceptors(handshakeInterceptor).setAllowedOrigins(allowsOrigins).withSockJS();//兼容以前老版本的sockJS

	}

}
