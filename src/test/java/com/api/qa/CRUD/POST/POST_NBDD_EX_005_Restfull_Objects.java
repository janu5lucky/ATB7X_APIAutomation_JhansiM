package com.api.qa.CRUD.POST;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class POST_NBDD_EX_005_Restfull_Objects {
	
	public static RequestSpecification rs ;
	public static String BaseUri = "https://api.restful-api.dev";
	public static String Basepath = "/objects";
	public static String payload = "{\r\n"
			+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
			+ "   \"data\": {\r\n"
			+ "      \"year\": 2019,\r\n"
			+ "      \"price\": 1849.99,\r\n"
			+ "      \"CPU model\": \"Intel Core i9\",\r\n"
			+ "      \"Hard disk size\": \"2 TB\"\r\n"
			+ "   }\r\n"
			+ "}";
	

	@Test
	public static void CreateanObject() {
		
		rs = RestAssured.given();
		rs.baseUri(BaseUri);
		rs.basePath(Basepath);
		rs.contentType(ContentType.JSON).body(payload).log().all();
	
		Response res = rs.when().post();
		
		ValidatableResponse vr = res.then().log().all();
		vr.statusCode(200);
				
		
	}

}
