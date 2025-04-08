package com.api.qa.CRUD.POST;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class POST_NBDD_EX_004_WithToken {
	public static RequestSpecification requestspecification;
	public static String BaseUri = "https://restful-booker.herokuapp.com";
	public static String BasepathGet = "/auth";
	public static String BasepathPost = "/booking";
	public static String Token="5346c9b027da5ae";
	
	
	@BeforeTest(enabled = false)
	public static void creatToken() {
	
		String GetPayload = "{\n"+
				 "\"username\" : \"admin\",\n"+
				 "\"password\" : \"password123\"\n"+		 
						 
				 "}"; 
		
		 requestspecification =  RestAssured.given();
		 requestspecification.baseUri(BaseUri);
		 requestspecification.basePath(BasepathGet);
		 requestspecification.contentType(ContentType.JSON).body(GetPayload);
		 Response response = requestspecification.when().post();
		 ValidatableResponse validateresponse = response.then().log().all();
		 validateresponse.statusCode(200);
		System.out.println("Got 200 as status code - success ");
		

		 
		
	}
	
	@Test
	public static void SendPOST_Request() {
		
		String payload = "{\n" +
			    "  \"firstname\" : \"Pramod\",\n" +
			    "  \"lastname\" : \"Brown\",\n" +
			    "  \"totalprice\" : 111,\n" +
			    "  \"depositpaid\" : true,\n" +
			    "  \"bookingdates\" : {\n" +
			    "    \"checkin\" : \"2018-01-01\",\n" +
			    "    \"checkout\" : \"2019-01-01\"\n" +
			    "  },\n" +
			    "  \"additionalneeds\" : \"Breakfast\"\n" +
			"}";
		
		requestspecification =  RestAssured.given();
		 requestspecification.baseUri(BaseUri);
		 requestspecification.basePath(BasepathPost);
		 requestspecification.contentType(ContentType.JSON).body(payload);
		 requestspecification.cookie("token",Token);
		 Response response = requestspecification.when().post();
		 ValidatableResponse validateresponse = response.then().log().all();
		 validateresponse.statusCode(200);
		System.out.println("Got 200 as status code - success ");
		

	}

}
