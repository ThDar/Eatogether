package com.eatogether.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Venuedetails {
		String id ; 
		String name ; 
		LocationVenue location ; 
		Categorievenue[] categories;
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Object getLocation() {
			return location;
		}
		public void setLocation(LocationVenue location) {
			this.location = location;
		}
		public Categorievenue[] getCategories() {
			return categories;
		}
		public void setCategories(Categorievenue[] categories) {
			this.categories = categories;
		}
		
}
