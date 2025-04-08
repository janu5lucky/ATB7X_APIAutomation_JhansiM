package com.api.qa.CRUD.POJOS;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Hashmap_Pojo_class_Ex_002 {


	@Test
	public static void hashmap_payload() {
	
	//{
	  //  "firstname": "Alexandra",
	  //  "lastname": "Thomas",
	   // "totalprice": 123,
	//    "depositpaid": true,
	  //  "bookingdates": {
	 //       "checkin": "2025-01-01",
	 //       "checkout": "2025-02-01"
	 //   },
	   // "additionalneeds": "Breakfast"
///	}

	
	Map<String , Object> payloadusingmap = new LinkedHashMap<>();
	payloadusingmap.put("firstname", "Sally");
	payloadusingmap.put("lastname", "Traver");
	payloadusingmap.put("totalprice", "1234");
	payloadusingmap.put("depositpaid", "true");
	
	Map<String , Object> bookindatesmap = new LinkedHashMap<>();

	bookindatesmap.put("checkin", "2025-01-01");
	bookindatesmap.put("checkout", "2025-01-01");

	payloadusingmap.put("bookingdates", bookindatesmap);
	
	payloadusingmap.put("additionalneeds", "Breakfast");

	System.out.println(payloadusingmap);

	RequestSpecification requestspecs = RestAssured.given();
	requestspecs.baseUri("https://restful-booker.herokuapp.com");
	requestspecs.baseUri("/booking");
	requestspecs.contentType(ContentType.JSON);
	requestspecs.body(payloadusingmap).log().all();
	
	
	Response response = requestspecs.when().post();
	
	ValidatableResponse vr = response.then().log().all();
	vr.statusCode(200);
	
	
	
}
}