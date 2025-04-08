package com.api.qa.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POST_EX_001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	 String URL = "https://restful-booker.herokuapp.com";
	 String uripath = "/auth";
	 String PayLoad = "{\n"+
	 "\"username\" : \"admin\",\n"+
	 "\"password\" : \"password123\"\n"+		 
			 
	 "}"; 
			 
			 
	RestAssured.given()
	.baseUri(URL)
	.basePath(uripath)
	.contentType(ContentType.JSON).log().all().body(PayLoad)
	.when().post().then().log().all().statusCode(200);
	
	}

}
