package com.eatogether.model;

public class User_fcb {
	
	private String id;
	private String name;
	private String email;
	private String picture;
	
	public User_fcb() {
		
	}
	
	public User_fcb(String id, String name, String picture) {
		super();
		this.id = id;
		this.name = name;		
		this.picture = picture;
	}
	
	public User_fcb(String id, String name, String email, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.picture = picture;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}
	
}
