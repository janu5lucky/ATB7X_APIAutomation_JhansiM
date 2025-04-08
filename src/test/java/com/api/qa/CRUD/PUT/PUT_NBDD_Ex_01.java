package com.api.qa.CRUD.PUT;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PUT_NBDD_Ex_01 {
	
	public static RequestSpecification rs;
	public static String BaseUri = "https://restful-booker.herokuapp.com";
	public static String BasepathAuth = "/auth";
	public static String BasepathPost = "/booking";
	public static String BasepathPut = "";
	public static String  Token = "dbdb2e15d9d277a";
	
	
	@BeforeTest
	
	public static void CreateToken() {
		String GetPayload = "{\n"+
				 "\"username\" : \"admin\",\n"+
				 "\"password\" : \"password123\"\n"+		 
			"}";
		
		rs = RestAssured.given();
		rs.baseUri(BaseUri);
		rs.basePath(BasepathAuth);
		rs.cookie("Token",Token);
		rs.contentType(ContentType.JSON).body(GetPayload);
		Response res = rs.when().post();
		
		ValidatableResponse vr = res.then().log().all();
		vr.statusCode(200);
		
		
	}
	
@Test
public static void PostRequest() {
	
	String PostPayload = "{\n" +
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
	
		rs = RestAssured.given();
		rs.baseUri(BaseUri);
		rs.basePath(BasepathPost);
		rs.cookie("Token", Token);
		rs.contentType(ContentType.JSON);
		rs.body(PostPayload).log().all();
		
		Response res = rs.when().post();
		
		ValidatableResponse vr = res.then().log().all();
		vr.statusCode(200);
		
		
		
		
}
		@Test 
		public static void PUTRequest() {
			
			String PUTPayload = "{\n" +
				    "  \"firstname\" : \"Craloine\",\n" +
				    "  \"lastname\" : \"Channing\",\n" +
				    "  \"totalprice\" : 111,\n" +
				    "  \"depositpaid\" : true,\n" +
				    "  \"bookingdates\" : {\n" +
				    "    \"checkin\" : \"2018-01-01\",\n" +
				    "    \"checkout\" : \"2019-01-01\"\n" +
				    "  },\n" +
				    "  \"additionalneeds\" : \"Breakfast\"\n" +
				"}";
			
			rs = RestAssured.given();
			rs.baseUri(BaseUri);
			rs.basePath(BasepathPut);
			rs.cookie("Toekn", Token);
			rs.contentType(ContentType.JSON);
			rs.body(PUTPayload).log().all();
			
			Response res = rs.when().put();
			
			ValidatableResponse vr = res.then().log().all();
			vr.statusCode(200);
			
			
		}
	
}
