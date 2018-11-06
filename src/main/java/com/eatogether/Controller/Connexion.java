package com.eatogether.Controller;

import java.io.IOException;
import java.util.Arrays;

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

import com.eatogether.model.User_fcb;
import com.fasterxml.jackson.annotation.JsonValue;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.json.JsonObject;




public class Connexion extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	 private IUsers iUsers = new UsersImplementation();
	 IUserTransformation iUserTransformation = new TransformationUser();
	ConnectDB db = new ConnectDB();

	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		HttpSession session = request.getSession();

		try {
			
			String acces_token= request.getParameter("acces_token");
			FacebookClient facebookClient=new DefaultFacebookClient(acces_token,Version.VERSION_3_1);
			JsonObject fetchObjectsResults =
			facebookClient.fetchObjects(Arrays.asList("me"), 
				JsonObject.class, Parameter.with("fields","name,id,email,birthday,picture,gender"));

			JsonObject me = (JsonObject) fetchObjectsResults.get("me");
	
			String name_user=  me.get("name").toString().substring(1, me.get("name").toString().length()-1);
			String id_user=  me.get("id").toString().substring(1,  me.get("id").toString().length()-1);
			String email_user= me.get("email").toString().substring(1,  me.get("email").toString().length()-1);
			String gender_user= me.get("gender").toString().substring(1,  me.get("gender").toString().length()-1);
			String birthday_user= me.get("birthday").toString().substring(1,  me.get("birthday").toString().length()-1);

			
			JsonObject picture = (JsonObject) me.get("picture");
			JsonObject data = (JsonObject) picture.get("data");

			String picture_user=data.get("url").toString().substring(1, data.get("url").toString().length()-1);


			session.setAttribute("login", email_user);			
			session.setAttribute("picture_user", picture_user);
			
			String[] prenom_nom = name_user.split("\\s+");
			
			
			
			User user = new User();
			user.setMail(email_user);
			user.setImage(picture_user);
			user.setDatenaissance(birthday_user);
			user.setNom(prenom_nom[1]);
			user.setPrenom(prenom_nom[0]);
			user.setPseudo("");
			user.setSexe(gender_user);
			
			
			UtilisateurBean utilisateurPersistance = iUserTransformation.fromUserToUserBean(user);
			
			try {
				if (iUsers.getUserexistemail(email_user)) {	 
					this.getServletContext()
					.getRequestDispatcher("/recherche.jsp")
					.forward(request, response);
				}	
				
			} catch (Exception e) {
				iUsers.persistuser(utilisateurPersistance);
				this.getServletContext()
				.getRequestDispatcher("/recherche.jsp")
				.forward(request, response);
			}
			

		} catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		HttpSession session = request.getSession();



		String login = request.getParameter("pseudo");
		String mp = request.getParameter("password");

	

		try {
			if (iUsers.getUserexist(login,mp)) {
				
				String picture_user="data:image/png;base64,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";
				session.setAttribute("login", login);	
				session.setAttribute("picture_user", picture_user);

				this.getServletContext()
				.getRequestDispatcher("/recherche.jsp")
				.forward(request, response);
			} else {

				String err = "Nom ou mot de passe incorrect !";
				request.setAttribute("err", err);
				this.getServletContext()
				.getRequestDispatcher("/login.jsp")
				.forward(request, response);

			}
		} catch (Exception e) {
			String err = "Nom ou mot de passe incorrect !";
			request.setAttribute("err", err);
			this.getServletContext()
			.getRequestDispatcher("/login.jsp")
			.forward(request, response);
		}


	}



}