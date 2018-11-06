package com.eatogether.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Comparator;

import com.eatogether.Controller.ConnectDB;

public class Chat {
	String source ; 
	String destination;
	String message ;
	String id ; 
	String number ; 
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	ConnectDB db = new ConnectDB();
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	} 
	
	public ArrayList<Chat> getdicussion(String source) throws Exception {
		
		ArrayList<Chat> listchat = new ArrayList<Chat>();
		Connection conn = db.getConnexion();
		String query = "SELECT DISTINCT * FROM CHAT INNER JOIN (SELECT MAX(id) AS maxid FROM CHAT GROUP BY source) topscore ON CHAT.destination ='"+source+"' AND CHAT.id = topscore.maxid";

		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				Chat chat = new Chat();
			String msg = rs.getString("message");
			String src = rs.getString("source");
			String dst=rs.getString("destination");
			
		chat.setMessage(msg);
		chat.setDestination(dst);
		chat.setSource(src);
		System.out.println("aaaa"+msg);
		listchat.add(chat);
			}
		}

		catch (SQLException e) {
			System.out.println("An exception occurred:  " + e.getMessage());
		}

		finally {
			db.closeConnexion(conn);
		}

		return listchat;

	}
	
	
	public ArrayList<Chat> getdicussionSrc (String source , String destination) throws Exception {
		Chat chat = new Chat();
		ArrayList<Chat> listchat = new ArrayList<Chat>();
		Connection conn = db.getConnexion();
		//System.out.println("source");
		
		String query = "select * from CHAT  where source='"+source+"' and destination='"+destination+"'";
	//	System.out.println(query);
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			 while (rs.next()) {
	
			String msg = rs.getString("message");
			String src = rs.getString("source");
			String dst=rs.getString("destination");
			String id =rs.getString("id");
			
		chat=new Chat();
		chat.setMessage(msg);
		chat.setDestination(dst);
		chat.setSource(src);
		chat.setId(id);
		chat.setNumber(number);
		listchat.add(chat);
		//System.out.println(msg);
			 }
		}

		catch (SQLException e) {
			System.out.println("An exception occurred:  " + e.getMessage());
		}

		finally {
			db.closeConnexion(conn);
		}

		return listchat;

	}
	
	public String inserdiscussion(String source, String destination,String msg) throws Exception {
		
		if (source != "" && destination != "") {
			Connection conn = db.getConnexion();
			String query = "insert into CHAT (source,destination,message) values ('" + source
					+ "','" + destination + "','" + msg +"')";
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
	
	public void deletechat (String source , String destination ) throws Exception {
		String query = "delete from CHAT where source='"+source+"' and destination='"+destination+"'";
		Connection conn = db.getConnexion();
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("An exception occurred: " + e.getMessage());
		}

		finally {
			db.closeConnexion(conn);
		}
		
		
	}

	public int numberofmsg(String source, String destination) throws Exception {
		
		int nombre = 0;
		String query = "select count(source) FROM CHAT where source ='"+source+"' and destination='"+destination+"'";
		Connection conn = db.getConnexion();
		try (Statement stmt = conn.createStatement()) {
			ResultSet rs = stmt.executeQuery(query);
			if(rs.next()) {
				nombre = rs.getInt(1);
			}
		}
		return nombre; 
	}}



