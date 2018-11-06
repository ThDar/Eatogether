package com.eatogether.Controller;


import java.io.IOException;
import java.io.StringWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.eatogether.model.Chat;

@ServerEndpoint(value="/chatroomServerEndpoint", configurator=ChatroomServerConfigurator.class)
public class ChatroomServerEndpoint {
static Set<Session> chatroomUsers = Collections.synchronizedSet(new HashSet<Session>());


@OnOpen
public void handleOpen(EndpointConfig endpointConfig , Session userSession) {
	userSession.getUserProperties().put("login", endpointConfig.getUserProperties().get("login"));
	userSession.getUserProperties().put("destination", endpointConfig.getUserProperties().get("destination"));
	boolean exist = false ; 
	String src = userSession.getUserProperties().get("login").toString();
	String dest = userSession.getUserProperties().get("destination").toString();
	for (Session peer : chatroomUsers) {
		if(peer.getUserProperties().get("login").toString().equals(src) && peer.getUserProperties().get("destination").toString().equals(dest)){
			exist = true ;
		}
	}
	if(exist==false) {
	chatroomUsers.add(userSession);
	}
}

@OnMessage
public void handleMessage(String message, Session userSession) throws IOException {
	String username = (String)userSession.getUserProperties().get("login");
	if(username==null) {
		chatroomUsers.stream().forEach(x -> {
			try {x.getBasicRemote().sendText(buildJsonData(username,message));}
		catch (Exception e) 
		{e.printStackTrace();}
		});
		userSession.getUserProperties().put("login", message);
		userSession.getBasicRemote().sendText(buildJsonData("System","you are connected as "+message));
	}else {
		boolean exist = false ;
		boolean exist1 = false ; 
		for (Session peer : chatroomUsers) {
			if(userSession.getUserProperties().get("destination").toString().equals(peer.getUserProperties().get("login").toString())){
				 if(peer.getUserProperties().get("destination").toString().equals(username)) {
					 	exist1 = true ; 
				 }  	
				 	exist = true ; 
	                peer.getBasicRemote().sendText(buildJsonData(username,message));
	                
			 }}
	
		if(exist1==false) {
			Chat chat = new Chat();
			try {
				if(chat.numberofmsg(username, userSession.getUserProperties().get("destination").toString())<=3) {
				chat.inserdiscussion(username, userSession.getUserProperties().get("destination").toString(), message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}}
		
			if(exist==false) {
				Chat chat = new Chat();
				try {
					if(chat.numberofmsg(username, userSession.getUserProperties().get("destination").toString())<=3) {
				chat.inserdiscussion(username, userSession.getUserProperties().get("destination").toString(), message);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
}
@OnClose
public void handleClose(Session userSession) {
	chatroomUsers.remove(userSession);
}

private String buildJsonData(String username, String message) {
	JsonObject jsonObject = Json.createObjectBuilder().add("username",username).add("message",message).build();
	StringWriter stringWriter = new StringWriter();
	try (JsonWriter jsonWriter = Json.createWriter(stringWriter)){jsonWriter.write(jsonObject);}
	return stringWriter.toString();
}

@OnError
public void onError(Session session, Throwable thr) {}

}
