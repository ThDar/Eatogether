
/* package com.eatogether.model ;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.eatogether.Controller.ConnectDB;

public class User {

	private static final long serialVersionUID = 1L;
	private ConnectDB db = new ConnectDB();
	//private String login;
	private String mp;
	private String nom;
	private String prenom;
	private String pseudo;
	private String date_naissance;
	private String email;
	private String gender;
	
	
	public User() {
		super();
	}

	public User(String email, String mp) {
		super();
		this.email = email;
		this.mp = mp;
	}

	public User(String email, String mp, String nom, String prenom,
			 String pseudo) {
		super();
		this.email = email;
		this.mp = mp;
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo=pseudo;
		
	}
	
	public User(String email, String mp, String nom, String prenom, String date_naiss,
			 String pseudo) {
		super();
		this.email = email;
		this.mp = mp;
		this.nom = nom;
		this.prenom = prenom;
		this.date_naissance=date_naiss;
		this.pseudo=pseudo;
		
	}
	
	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}


	public String getDate_naissance() {
		return date_naissance;
	}

	public void setDate_naissance(String date_naiss) {
		this.date_naissance = date_naiss;
	}


	
	public String getMp() {
		return mp;
	}

	public void setMp(String mp) {
		this.mp = mp;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public static User getUser(String login) throws Exception {
		ConnectDB db = new ConnectDB();
		User u = new User();
		Connection conn = db.getConnexion();
		String query = "select * from `UTILISATEUR` where `EMAIL`='" + login + "'";

		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			
			String nom = rs.getString("nom");
			String prenom = rs.getString("prenom");
			String date_naiss=rs.getString("date_naissance");
			String pseudo=rs.getString("pseudo");
			String gender=rs.getString("sexe");
			
			
			u.setEmail(login);
			u.setPrenom(prenom);
			u.setNom(nom);
			u.setDate_naissance(date_naiss);
			u.setPseudo(pseudo);
			u.setGender(gender);

		}

		catch (SQLException e) {
			System.out.println("An exception occurred:  " + e.getMessage());
		}

		finally {
			db.closeConnexion(conn);
		}

		return u;

	}

	public int getNombre() throws Exception {
		int nombre = 0;
		Connection conn = db.getConnexion();
		String query = "select count(*) from utilisateur";

		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			nombre = rs.getInt(1);

		}

		catch (SQLException e) {
			System.out.println("An exception occurred:  " + e.getMessage());
		}

		finally {
			db.closeConnexion(conn);
		}

		return nombre;

	}
	

	public static boolean isRegistred2(String login) throws Exception {
		ConnectDB db = new ConnectDB();
		boolean registred = false;
		Connection conn = db.getConnexion();
		String query = "select count(*) from UTILISATEUR where EMAIL='" + login + "'";

		
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			int nb = rs.getInt(1);
			
			if (nb > 0)
				registred = true;
		}

		catch (SQLException e) {
			System.out.println("An exception occurred: " + e.getMessage());
		}

		finally {
			db.closeConnexion(conn);
		}

		return registred;

	}
	
	public static boolean isRegistred(String login, String mp) throws Exception {
		ConnectDB db = new ConnectDB();
		boolean registred = false;
		Connection conn = db.getConnexion();
		String query = "select count(*) from UTILISATEUR where EMAIL='" + login + "' and PASS='"+mp+"' ";

		
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			rs.next();
			int nb = rs.getInt(1);
			
			if (nb > 0)
				registred = true;
		}

		catch (SQLException e) {
			System.out.println("An exception occurred: " + e.getMessage());
		}

		finally {
			db.closeConnexion(conn);
		}

		return registred;

	}

	public String insertUser(String mp, String login) throws Exception {
		String msg = "";
		if (mp != "" && login != "") {
			Connection conn = db.getConnexion();
			String query = "insert into UTILISATEUR(email,pass) values ('" + login
					+ "','" + mp + "')";
			try (Statement stmt = conn.createStatement()) {
				stmt.executeUpdate(query);

			} catch (SQLException e) {
				System.out.println("An exception occurred:  " + e.getMessage());
			}

			finally {
				db.closeConnexion(conn);
			}
		}

		else
			msg = "!! vous devez remplir tous les champs";
		return msg;
	}

	// Verify Values 

	public boolean okValues(String[] mp, String[] login) {
		boolean ok = true;
		int i = 0;
		while (i < mp.length && ok)// one loop because mp.length==login.length
		{
			if (mp[i] == "" || login[i] == "")
				ok = false;
			i++;
		}
		return ok;
	}

	// Update login and password 
	
	public String updateUser_compte(String mp, String email, String oldMp,
			String oldMail) throws Exception {
		String msg = "";
		if (mp != "" && email != "") {
			Connection conn = db.getConnexion();
			String query = "update UTILISATEUR set 'pass'= '" + mp + "' ,'email' ='"
					+ email + "' where 'email' ='"+ oldMail + "'";
			try (Statement stmt = conn.createStatement()) {
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println("An exception occurred: " + e.getMessage());
			}

			finally {
				db.closeConnexion(conn);
			}
		}

		else
			msg = "!! vous devez remplir tous les champs";
		return msg;
	}
	
	public static String updateUser_info(String email, String nom, String prenom, String pseudo, String date_naiss, String gender) throws Exception {
		ConnectDB db = new ConnectDB();
		String msg = "";
		if (email != "" && nom != "" && prenom != "" && pseudo !="" && date_naiss !="" && gender !="") {
			Connection conn = db.getConnexion();
			String query = "update UTILISATEUR set `nom`= '" + nom + "' , `prenom` = '"
					+ prenom +"' , `pseudo` = '"+pseudo +"' , `date_naissance` ='"+date_naiss
					+"' , `sexe`= '"+gender +"' where `email` = '"+email+"';" ;
			try (Statement stmt = conn.createStatement()) {
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println("An exception occurred: " + e.getMessage());
			}

			finally {
				db.closeConnexion(conn);
			}
		}

		else
			msg = "!! vous devez remplir tous les champs";
		return msg;
	}

	// Delete User 
	
	public void deleteUser(String email) throws Exception {

		Connection conn = db.getConnexion();
		String query = "delete from UTILISATEUR where email='" + email + "'";
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("An exception occurred: " + e.getMessage());
		}

		finally {
			db.closeConnexion(conn);
		}
	}

	// Insert User 


	public static String insertUser1(String email, String mp,
			String nom, String Prenom,String date_naiss,String pseudo, String gender) throws Exception {
		ConnectDB db = new ConnectDB();
		String msg = "";
		if (email != "") {
			Connection conn = db.getConnexion();
			String query = "insert into UTILISATEUR(EMAIL,PASS,NOM,PRENOM,DATE_NAISSANCE,PSEUDO,SEXE) values ('"
					
					+ email
					+ "','"
					+ mp
					+ "','"
					+ nom 
					+"','"
					+Prenom
					+"','"
					+date_naiss
					+"','"
					+pseudo
					+"','"
					+ gender + "')";
			try (Statement stmt = conn.createStatement()) {
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println("An exception occurred: " + e.getMessage());
			}

			finally {
				db.closeConnexion(conn);
			}
		}

		else
			msg = "!! vous devez remplir tous les champs";
		return msg;
	}
	
	
	public static String insertUser1(String email, String mp,
			String nom, String Prenom,String date_naiss,String pseudo, String gender,String photo) throws Exception {
		ConnectDB db = new ConnectDB();
		String msg = "";
		if (email != "") {
			Connection conn = db.getConnexion();
			String query = "insert into UTILISATEUR(EMAIL,PASS,NOM,PRENOM,DATE_NAISSANCE,PSEUDO,SEXE,PHOTO) values ('"
					
					+ email
					+ "','"
					+ mp
					+ "','"
					+ nom 
					+"','"
					+Prenom
					+"','"
					+date_naiss
					+"','"
					+pseudo
					+"','"
					+gender
					+"','"
					+ photo + "')";
			try (Statement stmt = conn.createStatement()) {
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				System.out.println("An exception occurred: " + e.getMessage());
			}

			finally {
				db.closeConnexion(conn);
			}
		}

		else
			msg = "!! vous devez remplir tous les champs";
		return msg;
	}

} */
