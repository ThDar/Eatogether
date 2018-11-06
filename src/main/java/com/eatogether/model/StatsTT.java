package com.eatogether.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class StatsTT {
	String checkinsCount; 
	String usersCount ; 
	String tipCount ; 
	String visitsCount ;
	
	
	public String getCheckinsCount() {
		return checkinsCount;
	}
	public void setCheckinsCount(String checkinsCount) {
		this.checkinsCount = checkinsCount;
	}
	public String getUsersCount() {
		return usersCount;
	}
	public void setUsersCount(String usersCount) {
		this.usersCount = usersCount;
	}
	public String getTipCount() {
		return tipCount;
	}
	public void setTipCount(String tipCount) {
		this.tipCount = tipCount;
	}
	public String getVisitsCount() {
		return visitsCount;
	}
	public void setVisitsCount(String visitsCount) {
		this.visitsCount = visitsCount;
	} 
}
