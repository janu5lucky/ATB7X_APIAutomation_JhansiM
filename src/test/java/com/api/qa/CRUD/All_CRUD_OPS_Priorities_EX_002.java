package com.api.qa.CRUD;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class All_CRUD_OPS_Priorities_EX_002 {

	
	public static RequestSpecification requestspecification ; 
	public static String BaseUri = "https://restful-booker.herokuapp.com";
	public static String id = "";
	public static String token = "";
	public static String BasePathAuth = "/auth";
	public static String BasePathGet = "/booking/"+id;
	public static String BasePathPost = "/booking/";
	//public static String BasePathPut = "/booking/"+id;
	
	@BeforeTest
	public static void Test_01_CreateToken() {
		
		String AuthPayload = "{\n"+
				 "\"username\" : \"admin\",\n"+
				 "\"password\" : \"password123\"\n"+		 
			"}";
		
		requestspecification = RestAssured.given();
		requestspecification.baseUri(BaseUri);
		requestspecification.basePath(BasePathAuth);
		requestspecification.contentType(ContentType.JSON).body(AuthPayload).log().all();
		
		Response response = 	requestspecification.when().post();
		
		ValidatableResponse validateresponse = response.then().log().all();
		validateresponse.statusCode(200);
		
		token = response.jsonPath().getString("token");		
		
		System.out.println("Token : " +token);
		
	}
	
	@Test
	public static void CreateBooking_POST() {
		
		
		String PostPayload = "{\n" +
			    "  \"firstname\" : \"Jhansi\",\n" +
			    "  \"lastname\" : \"Muthyala\",\n" +
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
		
		id = response.jsonPath().getString("bookingid");
		System.out.println("Id : " +id);
		
		
	}
	
	@Test(dependsOnMethods = "CreateBooking_POST", priority =1)
	public static void Verify_CreatedBooking_GET() {
			
		System.out.println("Base Path :"+BasePathGet+id);

			
			requestspecification = RestAssured.given();
			requestspecification.baseUri(BaseUri);
			requestspecification.basePath(BasePathGet+id);
			requestspecification.cookie("token", token);
			requestspecification.contentType(ContentType.JSON).log().all();
			
			Response response = requestspecification.when().get();
			
			ValidatableResponse validateresponse = response.then();//.log().all();
			validateresponse.statusCode(200);
			
			
			
		}
		
	
	@Test(dependsOnMethods = "CreateBooking_POST", priority = 2)
public static void UpdateBooking_PUT() {
		
		
		String PutPayload = "{\n" +
			    "  \"firstname\" : \"Karthika\",\n" +
			    "  \"lastname\" : \"aaryan\",\n" +
			    "  \"totalprice\" : 231,\n" +
			    "  \"depositpaid\" : true,\n" +
			    "  \"bookingdates\" : {\n" +
			    "    \"checkin\" : \"2025-01-02\",\n" +
			    "    \"checkout\" : \"2025-02-02\"\n" +
			    "  },\n" +
			    "  \"additionalneeds\" : \"Breakfast\"\n" +
			"}";
		
		
		requestspecification = RestAssured.given();
		requestspecification.baseUri(BaseUri);
		requestspecification.basePath(BasePathGet+id);
		requestspecification.cookie("token", token);
		requestspecification.contentType(ContentType.JSON).body(PutPayload).log().all();
		
		Response response = requestspecification.when().put();
		
		ValidatableResponse validateresponse = response.then();
		validateresponse.statusCode(200);
		
	}
	

	@Test(dependsOnMethods = "UpdateBooking_PUT", priority = 3)
	public static void Verify_UpdatedBooking_GET() {
			
		
			
			requestspecification = RestAssured.given();
			requestspecification.baseUri(BaseUri);
			requestspecification.basePath(BasePathGet+id);
			requestspecification.cookie("token", token);
			requestspecification.contentType(ContentType.JSON).log().all();
			
			Response response = requestspecification.when().get();
			
			ValidatableResponse validateresponse = response.then();//.log().all();
			validateresponse.statusCode(200);
			
		
		}
		
	@Test(dependsOnMethods = "CreateBooking_POST", priority = 4)
	public static void DelBooking_DELETE() {	
			
			requestspecification = RestAssured.given();
			requestspecification.baseUri(BaseUri);
			requestspecification.basePath(BasePathGet+id);
			requestspecification.cookie("token", token);
			requestspecification.contentType(ContentType.JSON).log().all();
			
			Response response = requestspecification.when().delete();
			
			ValidatableResponse validateresponse = response.then().log().all();
			validateresponse.statusCode(404);
			
			
			
		}
	@Test
	public static void Verify_DeletedBooking_GET() {
			
		
			
			requestspecification = RestAssured.given();
			requestspecification.baseUri(BaseUri);
			requestspecification.basePath(BasePathGet+id);
			requestspecification.cookie("token", token);
			requestspecification.contentType(ContentType.JSON).log().all();
			
			Response response = requestspecification.when().get();
			
			ValidatableResponse validateresponse = response.then();//.log().all();
			validateresponse.statusCode(200);
			
			
			
		}
		
		
}
