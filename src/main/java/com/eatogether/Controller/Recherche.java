package com.eatogether.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatogether.model.FoursquareAPIsearch;
import com.eatogether.model.InformationTT;
import com.eatogether.model.PhotoInfoTT;
import com.eatogether.model.Venuedetails;


public class Recherche extends HttpServlet {
	private static final long serialVersionUID = 1L;
    

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		String id = request.getParameter("id");
		String lieu = request.getParameter("lieu");
		String name = request.getParameter("name");
		
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("lieu", lieu);
		
		this.getServletContext()
		.getRequestDispatcher("/details.jsp")
		.forward(request, response);
		   
		}

	


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("login"));
		System.out.println(session.getAttribute("mp"));
		String place = request.getParameter("place");
		String query = request.getParameter("query");
		String limit = request.getParameter("limit");
		String rayon = request.getParameter("rayon");
		FoursquareAPIsearch api = new FoursquareAPIsearch();
		Venuedetails[] result = api.getvenues(place, rayon, query,limit, "4d4b7105d754a06374d81259");

		request.setAttribute("venue", result);
		this.getServletContext()
		.getRequestDispatcher("/recherche.jsp")
		.forward(request, response);
	}

}
