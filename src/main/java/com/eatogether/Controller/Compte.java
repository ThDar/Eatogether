package com.eatogether.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.eatogether.Consumer.IUsers;
import com.eatogether.Consumer.Implementation.UsersImplementation;
import com.eatogether.Consumer.Transformation.IUserTransformation;
import com.eatogether.Consumer.Transformation.Implementation.TransformationUser;

public class Compte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IUsers iUsers = new UsersImplementation();
	 IUserTransformation iUserTransformation = new TransformationUser();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String mail=(String)session.getAttribute("login");

		String pass_ancien= (String)request.getParameter("password_ancien");
		
		try {
			
			if(iUsers.getUserexist(mail, pass_ancien)) {
				
				
				String pass_nv= (String) request.getParameter("password_nouveau");
				String pass_nv2= (String) request.getParameter("password_nouveau2");
				
				if(pass_nv.equals(pass_nv2)) {
					iUsers.updateUserpassword(mail, pass_nv);	
					request.setAttribute("err", "LE MOT DE PASSE A ETE CHANGE");
					this.getServletContext()
					.getRequestDispatcher("/compte.jsp")
					.forward(request, response);
				}else {					
					request.setAttribute("err", "LES NOUVEAUX PASS NE SONT PAS EGAUX");
					this.getServletContext()
					.getRequestDispatcher("/compte.jsp")
					.forward(request, response);
				}
			}else {			
				request.setAttribute("err", "LE MOT DE PASSE QUE VOUS AVEZ TAPEZ NE CORRESPOND PAS");
				this.getServletContext()
				.getRequestDispatcher("/compte.jsp")
				.forward(request, response);
				
			}
			
		}catch(Exception e) {
			request.setAttribute("err", "LE MOT DE PASSE N'EXISTE PAS");
			this.getServletContext()
			.getRequestDispatcher("/compte.jsp")
			.forward(request, response);
		}
	
		
		
	
		
	//		
	}

}
