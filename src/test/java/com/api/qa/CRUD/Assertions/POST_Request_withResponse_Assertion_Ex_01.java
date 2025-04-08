package com.api.qa.CRUD.Assertions;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class POST_Request_withResponse_Assertion_Ex_01 {

	public static RequestSpecification requestspecification ; 
	public static String BaseUri = "https://restful-booker.herokuapp.com";
	public static String id = "";
	public static String token = "";
	public static String BasePathAuth = "/auth";
	public static String BasePathGet = "/booking/"+id;
	public static String BasePathPost = "/booking/";
	
	@Test
	public static void Test_02_CreateBooking_POST() {
		
		
		String PostPayload = "{\n" +
			    "  \"firstname\" : \"Alexandra\",\n" +
			    "  \"lastname\" : \"Thomas\",\n" +
			    "  \"totalprice\" : 123,\n" +
			    "  \"depositpaid\" : true,\n" +
			    "  \"bookingdates\" : {\n" +
			    "    \"checkin\" : \"2025-01-01\",\n" +
			    "    \"checkout\" : \"2025-02-01\"\n" +
			    "  },\n" +
			    "  \"additionalneeds\" : \"Breakfast\"\n" +
			"}";
		
		
		requestspecification = RestAssured.given();
		requestspecification.baseUri(BaseUri);
		requestspecification.basePath(BasePathPost);
		requestspecification.cookie("token", token);
		requestspecification.contentType(ContentType.JSON).body(PostPayload).log().all();
		
		Response response = requestspecification.when().post();
		
		ValidatableResponse validateresponse = response.then().log().all();
		validateresponse.statusCode(200);
		validateresponse.body("booking.firstname", Matchers.equalTo("Alexandra"));
		validateresponse.body("booking.lastname", Matchers.equalTo("Thomas"));

		System.out.println("Firstname assertion passed");
		validateresponse.body("bookingid", Matchers.notNullValue());
		System.out.println("BookingId not a null assertion passed");

		id = response.jsonPath().getString("bookingid");
		System.out.println("Id : " +id);
		
		
	}
	
	@Test
	public static void Test_02_CreateBooking_POST_faliedCase() {
		
		
		String PostPayload = "{\n" +
			    "  \"firstname\" : \"Alexandra\",\n" +
			    "  \"lastname\" : \"Thomas\",\n" +
			    "  \"totalprice\" : 123,\n" +
			    "  \"depositpaid\" : true,\n" +
			    "  \"bookingdates\" : {\n" +
			    "    \"checkin\" : \"2025-01-01\",\n" +
			    "    \"checkout\" : \"2025-02-01\"\n" +
			    "  },\n" +
			    "  \"additionalneeds\" : \"Breakfast\"\n" +
			"}";
		
		
		requestspecification = RestAssured.given();
		requestspecification.baseUri(BaseUri);
		requestspecification.basePath(BasePathPost);
		requestspecification.cookie("token", token);
		requestspecification.contentType(ContentType.JSON).body(PostPayload).log().all();
		
		Response response = requestspecification.when().post();
		
		ValidatableResponse validateresponse = response.then().log().all();
		validateresponse.statusCode(200);
		validateresponse.body("booking.firstname", Matchers.equalTo("Jhansi"));
		validateresponse.body("booking.lastname", Matchers.equalTo("Thomas"));

		System.out.println("Firstname assertion Failed");
		validateresponse.body("bookingid", Matchers.notNullValue());
		System.out.println("BookingId not a null assertion passed");

		id = response.jsonPath().getString("bookingid");
		System.out.println("Id : " +id);
		
		
	}
	


}
