package com.api.qa.CRUD.PUT;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PUT_NBDD_EX_005_RestFull_Objects {
	
	
	String id = "ff808181932badb601960a5365182353";
	public static RequestSpecification rs ;
	public static String BaseUri = "https://api.restful-api.dev";
	public static String Basepath = "/objects/ff808181932badb601960a5365182353";
	public static String payload = "{\r\n"
			+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
			+ "   \"data\": {\r\n"
			+ "      \"year\": 2019,\r\n"
			+ "      \"price\": 2249.99,\r\n"
			+ "      \"CPU model\": \"Intel Core i9\",\r\n"
			+ "      \"Hard disk size\": \"1 TB\",\r\n"
			+ "      \"color\": \"Rose Gold\"\r\n"
			+ "   }\r\n"
			+ "}";
	
	
	@Test
	public static void PUT_ObjectRequest() {
		
		rs = RestAssured.given();
		rs.baseUri(BaseUri);
		rs.basePath(Basepath);
		rs.contentType(ContentType.JSON).body(payload).log().all();
		
		Response res = rs.when().put();
		
		ValidatableResponse vr  = res.then().log().all();
		vr.statusCode(200);
		
		
		
		
	}

}
