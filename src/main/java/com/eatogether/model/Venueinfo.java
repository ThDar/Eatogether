package com.eatogether.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Venueinfo {

	Object venue ;

	public Object getVenue() {
		return venue;
	}

	public void setVenue(Object venue) {
		this.venue = venue;
	}
}

	