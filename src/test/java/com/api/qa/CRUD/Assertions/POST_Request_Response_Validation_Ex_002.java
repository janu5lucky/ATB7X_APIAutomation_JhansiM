package com.api.qa.CRUD.Assertions;

import static org.testng.Assert.assertNotNull;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class POST_Request_Response_Validation_Ex_002 {
	public static RequestSpecification requestspecification ; 
	public static String BaseUri = "https://restful-booker.herokuapp.com";
	public static String id = "";
	public static String token = "";
	public static String BasePathAuth = "/auth";
	public static String BasePathGet = "/booking/"+id;
	public static String BasePathPost = "/booking/";
	public static Integer bookingId ;
	
	@Test
	public static void Test_CreatBooking_Post_Validation() {
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
	

	bookingId = response.then().extract().path("bookingid");
	Assert.assertNotNull(bookingId);
	System.out.println("BookingId not a null assertion passed");
	
    String firstname = response.then().extract().path("booking.firstname");
	Assert.assertEquals(firstname, "Alexandra");
    String lastname = response.then().extract().path("booking.lastname");

	Assert.assertEquals(lastname, "Thomas");

	System.out.println("Firstname and Lastname assertions passed");


	id = response.jsonPath().getString("bookingid");
	System.out.println("Id : " +id);
	
	
}

}
