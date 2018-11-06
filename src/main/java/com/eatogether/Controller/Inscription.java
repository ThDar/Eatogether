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
import com.eatogether.Repository.User;
import com.eatogether.Repository.RepositoryBean.UtilisateurBean;


public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private IUsers iUsers = new UsersImplementation();
    IUserTransformation iUserTransformation = new TransformationUser();

   
public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        
    }
    
		public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
			HttpSession session = request.getSession();
		
			String mp = request.getParameter("password");
			String mail = request.getParameter("email");
			String name = request.getParameter("nom");
			String prename = request.getParameter("prenom");
			String date_naiss=request.getParameter("date_naiss");
			String pseudo = request.getParameter("pseudo");
	
			String gender=request.getParameter("gender");

			
			User user = new User();
			
			user.setMotdepasse(mp);
			user.setMail(mail);
			user.setImage(null);
			user.setDatenaissance(date_naiss);
			user.setNom(name);
			user.setPrenom(prename);
			user.setPseudo(pseudo);
			user.setSexe(gender);
			
			
			UtilisateurBean utilisateurPersistance = iUserTransformation.fromUserToUserBean(user);
	        
							
								
						try {
									
									if(iUsers.getUserexistemail(mail)) {
								
										String err="true";
					                    request.setAttribute(err, "Cet utilisateur existe déja");
					                    this.getServletContext()
										.getRequestDispatcher("/inscription.jsp")
										.forward(request, response);
													
									}       
								} catch (Exception e) {
									
									iUsers.persistuser(utilisateurPersistance);
									session.setAttribute("mail", mail);						
									
									this.getServletContext()
									.getRequestDispatcher("/login.jsp")
									.forward(request, response);
								} 
				
				}
			
		}
	


