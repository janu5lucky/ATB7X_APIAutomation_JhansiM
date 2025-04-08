package com.api.qa.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class POST_NBDD_EX_003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String URL = "https://www-api.pos.com.my";
		 String uripath = "/api/getStateByPostcode";
		 String PayLoad = "{\n"+
		 "\"postCode\" : \"35600\"\n"+

		 "}"; 
		RequestSpecification r = RestAssured.given();
		r.baseUri(URL);
		r.basePath(uripath);
		r.contentType(ContentType.JSON).body(PayLoad);
		
		Response response = r.when().get();
		
		ValidatableResponse validation = response.then();
		validation.statusCode(200);
		System.out.println("Got 200 as status code - success ");

		
	}

}
