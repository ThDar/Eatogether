package com.eatogether.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Venuesinfo {
	
	
	Object venues ;
	Object geocode ;
	public Object getVenues() {
		return venues;
	}
	public void setVenues(Object venues) {
		this.venues = venues;
	}
	public Object getGeocode() {
		return geocode;
	}
	public void setGeocode(Object geocode) {
		this.geocode = geocode;
	} 
}

	
	