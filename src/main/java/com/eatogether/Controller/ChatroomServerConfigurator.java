package com.eatogether.Controller;
import javax.servlet.http.HttpSession;
import javax.websocket.HandshakeResponse;
import javax.websocket.server.*;
public class ChatroomServerConfigurator extends ServerEndpointConfig.Configurator {

	public void modifyHandshake(ServerEndpointConfig sec,HandshakeRequest request , HandshakeResponse response) {
		sec.getUserProperties().put("login",(String)((HttpSession)request.getHttpSession()).getAttribute("login"));
		sec.getUserProperties().put("destination", (String)((HttpSession)request.getHttpSession()).getAttribute("destination"));
		
	}
}
