package com.eatogether.model;

import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import io.restassured.response.Response;

public class FoursquareAPIsearch {



	public static Venuedetails[] getvenues(String near, String radius, String query, String limit, String categoryid)
			throws JsonParseException, JsonMappingException, IOException {

		final String nearParameter = "near";
		String radiusParameter = "radius";
		String queryParameter = "query";
		String limitParameter = "limit";
		String categoryidParameter = "categoryId";

		if (radius.equals("")) {
			radiusParameter = "";
		}

		if (query.equals("")) {
			queryParameter = "";
		}

		if (limit.equals("")) {
			limitParameter = "";
		}

		if (categoryid.equals("")) {
			categoryidParameter = "";
		}

		Response resp = given()
				.params(nearParameter, near, radiusParameter, radius, queryParameter, query, limitParameter, limit,
						categoryidParameter, categoryid)

				.params("client_id", "3HFZPNFFTBJZSGRXT5ZHN24UWCZL0C2VQDLNS2XHTQ0AI5AJ")
				.params("client_secret", "0KQDGCEKWB0YXXYLEQPPOHZD3UTVTG3YIN3GLLVGBKBIOPKV").params("v", "20180922")
				.when().get("https://api.foursquare.com/v2/venues/search");
		
		Venuedetails[] venuedetails;
		String deserialize = venuedeserialize(resp.asString());
		venuedetails=venueinformation(deserialize);
		return venuedetails;	
	}

	
	public static String venuedeserializestep2(String resp) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Venue venue = mapper.readValue(resp, Venue.class);

		String venueinfo;
		ObjectMapper objectMapper = new ObjectMapper();
		venueinfo = objectMapper.writeValueAsString(venue.getResponse());
		Venueinfo info = mapper.readValue(venueinfo, Venueinfo.class);
		String venuedetails = objectMapper.writeValueAsString(info.getVenue());

		return venuedetails;
	}
	
	public static InformationTT infostep2(String resp) throws JsonParseException, JsonMappingException, IOException {
		InformationTT infovenue ;
		ObjectMapper mapper = new ObjectMapper();
		infovenue = mapper.readValue(resp, InformationTT.class);
		return infovenue ;
	}
	
	
	

	public static String venuedeserialize(String resp) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		Venue venue = mapper.readValue(resp, Venue.class);

		String venueinfo;
		ObjectMapper objectMapper = new ObjectMapper();
		venueinfo = objectMapper.writeValueAsString(venue.getResponse());
		
		Venuesinfo info = mapper.readValue(venueinfo, Venuesinfo.class);
		String venuedetails = objectMapper.writeValueAsString(info.getVenues());

		return venuedetails;
	}

	public static Venuedetails[] venueinformation(String venueinfo) throws JsonParseException, JsonMappingException, IOException {
		Venuedetails[] venuedetails;
		ObjectMapper mapper = new ObjectMapper();
		venuedetails = mapper.readValue(venueinfo, Venuedetails[].class);
		return venuedetails ;
	}

	


	public static InformationTT getvenuesdetails(String id) throws JsonParseException, JsonMappingException, IOException {

		System.out.println("id"+id);
		Response resp = given().params("client_id", "3HFZPNFFTBJZSGRXT5ZHN24UWCZL0C2VQDLNS2XHTQ0AI5AJ")
				.params("client_secret", "0KQDGCEKWB0YXXYLEQPPOHZD3UTVTG3YIN3GLLVGBKBIOPKV").params("v", "20180922")
				.when().get("https://api.foursquare.com/v2/venues/"+id);
		
		System.out.println(resp.asString());
		String venues=venuedeserializestep2(resp.asString());
		
		InformationTT infovenue =	infostep2(venues);

		return infovenue ;
	}


	public String infovenuetojson(String id) throws JsonParseException, JsonMappingException, IOException {
		InformationTT info = getvenuesdetails(id);
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = mapper.writeValueAsString(info);
		return jsonInString;
		
	}

}
