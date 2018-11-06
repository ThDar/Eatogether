package com.eatogether.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class InformationTT {

	String id ; 
	ContactTT contact ; 
	String canonicalURL ; 
	StatsTT stats;
	String url;
	Object price ; 
	LikesTT likes ; 
	String rating ; 
	String ratingColor; 
	String ratingSignals;
	MenuTT menu ; 
	Object photos ; 
	Object hours ;
	String description ;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public ContactTT getContact() {
		return contact;
	}
	public void setContact(ContactTT contact) {
		this.contact = contact;
	}
	public String getCanonicalURL() {
		return canonicalURL;
	}
	public void setCanonicalURL(String canonicalURL) {
		this.canonicalURL = canonicalURL;
	}
	public StatsTT getStats() {
		return stats;
	}
	public void setStats(StatsTT stats) {
		this.stats = stats;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Object getPrice() {
		return price;
	}
	public void setPrice(Object price) {
		this.price = price;
	}
	public LikesTT getLikes() {
		return likes;
	}
	public void setLikes(LikesTT likes) {
		this.likes = likes;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getRatingColor() {
		return ratingColor;
	}
	public void setRatingColor(String ratingColor) {
		this.ratingColor = ratingColor;
	}
	public String getRatingSignals() {
		return ratingSignals;
	}
	public void setRatingSignals(String ratingSignals) {
		this.ratingSignals = ratingSignals;
	}
	public MenuTT getMenu() {
		return menu;
	}
	public void setMenu(MenuTT menu) {
		this.menu = menu;
	}
	public Object getPhotos() {
		return photos;
	}
	public void setPhotos(Object photos) {
		this.photos = photos;
	}
	public Object getHours() {
		return hours;
	}
	public void setHours(Object hours) {
		this.hours = hours;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}