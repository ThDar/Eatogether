package com.eatogether.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatogether.Buisness.IRendezVousBusiness;
import com.eatogether.Buisness.Implementation.IRendezVousBusinessImplementation;
import com.eatogether.model.Chat;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Chatchargement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	IRendezVousBusiness iRendezVousBusiness = new IRendezVousBusinessImplementation();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		session.setAttribute("destination", "az@+01-qc*");
		String source = session.getAttribute("login").toString();
		ArrayList<Chat> listechat = new ArrayList<Chat>();
		ArrayList<String>listeami=iRendezVousBusiness.GetListOfFriends(source);
		
		if(listeami.contains(source)) {
			listeami.remove(source);
		}
		
		String json ="";
		Chat chat = new Chat();
		try {
			listechat=chat.getdicussion(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map mp = new HashMap<>();
		mp.put("Ami", listeami);
		mp.put("Chat", listechat);
		ObjectMapper mapper = new ObjectMapper();
		json=mapper.writeValueAsString(mp);
		System.out.println(json);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(json);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
