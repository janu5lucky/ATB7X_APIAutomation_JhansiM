package com.api.qa.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POST_EX_002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL = "https://www-api.pos.com.my";
		 String uripath = "/api/getStateByPostcode";
		 String PayLoad = "{\n"+
		 "\"postCode\" : \"35600\"\n"+

		 "}"; 
				 
				 
		 RestAssured.given()
			.baseUri(URL)
			.basePath(uripath)
			.contentType(ContentType.JSON).log().all().body(PayLoad)
			.when().post().then().log().all().statusCode(200);
		
		}

	}

