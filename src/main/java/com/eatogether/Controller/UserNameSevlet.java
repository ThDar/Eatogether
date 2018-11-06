package com.eatogether.Controller;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatogether.model.Chat;
import com.fasterxml.jackson.databind.ObjectMapper;


public class UserNameSevlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		response.setContentType("text/html");
		ArrayList<Chat> listechat = new ArrayList<Chat>();
		HttpSession httpSession = request.getSession();
		String json ="";
		Chat chat = new Chat();
		try {
			listechat=chat.getdicussion(httpSession.getAttribute("login").toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectMapper mapper = new ObjectMapper();
		json=mapper.writeValueAsString(listechat);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		
		
	}
	
}
