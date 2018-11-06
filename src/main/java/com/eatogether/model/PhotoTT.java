package com.eatogether.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class PhotoTT {
	Object groups ;

	public Object getGroups() {
		return groups;
	}

	public void setGroups(Object groups) {
		this.groups = groups;
	}
}
