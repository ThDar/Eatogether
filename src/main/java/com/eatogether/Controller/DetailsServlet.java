package com.eatogether.Controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatogether.Buisness.IRendezVousBusiness;
import com.eatogether.Buisness.Implementation.IRendezVousBusinessImplementation;
import com.eatogether.Repository.RendezVous;
import com.eatogether.model.FoursquareAPIsearch;
import com.fasterxml.jackson.databind.ObjectMapper;



public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	IRendezVousBusiness iRendezVousBusiness = new IRendezVousBusinessImplementation();
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	 //TODO 
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
	    String mail = session.getAttribute("login").toString();
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		FoursquareAPIsearch api = new FoursquareAPIsearch();
		
		
		List<RendezVous> list=iRendezVousBusiness.GetListRdv_REST(id,mail);
		ObjectMapper mapper = new ObjectMapper();
		String json1 = mapper.writeValueAsString(list);
		String json = api.infovenuetojson(id);
		String bothJson = "{\"venue\":"+json+",\"info\":"+json1+"}";
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(bothJson);
		
	}

}
