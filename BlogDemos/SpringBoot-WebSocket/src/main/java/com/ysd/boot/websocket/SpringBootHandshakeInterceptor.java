package com.ysd.boot.websocket;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 * WebSocket通信 握手拦截器 它只拦截握手
 *
 */
@Component
public class SpringBootHandshakeInterceptor implements HandshakeInterceptor {

	/**
	 * 握手之前 ServerHttpRequest : 请求对象 ServerHttpResponse : 响应对象 WebSocketHandler :
	 * WebSocket服务处理类,在这里指的是SpringBootWebSocketHandler attributes :
	 * WebSocketSession.getAttributes()
	 */
	@Override
	public boolean beforeHandshake(ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse,
			WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
		ServletServerHttpRequest servletServerHttpRequest = (ServletServerHttpRequest) serverHttpRequest;
		HttpServletRequest request = servletServerHttpRequest.getServletRequest();// 得到Http协议的请求对象
		HttpSession session = request.getSession(true);
		System.out.println("握手拦截器^^^^^^^^^^^^  request.getParameter(\"param\")=>" + request.getParameter("param"));
		System.out.println("握手拦截器^^^^^^^^^^^^  request.getParameter(\"token\")=>" + request.getParameter("token"));
		System.out.println("握手拦截器^^^^^^^^^^^^ HttpSession.getAttribute(\"user\")=>" + session.getAttribute("user"));

		// 数据中转 可以把http协议的会话对象数据中转到ws协议的会话对象中
		attributes.put("param", request.getParameter("param"));
		// 非前后端分离架构:把HttpSession中的数据中转到WebSocketSession中
		if (session.getAttribute("user") != null)
			attributes.put("user", session.getAttribute("user"));
		// 如果是前后端分离架构:把Http协议中的token令牌中转到ws协议的WebSocketSession中
		attributes.put("token", request.getParameter("token"));

		return true;
	}

	/**
	 * 握手之后
	 */
	@Override
	public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler,
			Exception exception) {
		// TODO Auto-generated method stub

	}

}
