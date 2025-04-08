package com.api.qa.CRUD.DELETE;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class DELETE_NBDD_EX_005_RestFull_Objects {
	
	
	public static RequestSpecification rs ;
	public static String BaseUri = "https://api.restful-api.dev";
	public static String Basepath = "/objects/ff808181932badb601960a5365182353";
	
	
	@Test(priority = 1)
	public static void Delete_object() {
		
		rs = RestAssured.given();
		rs.baseUri(BaseUri);
		rs.basePath(Basepath);
		rs.contentType(ContentType.JSON).log().all();
		
		Response res = rs.when().delete();
		
		ValidatableResponse vr = res.then().log().all();
		vr.statusCode(200);
	}
	
	@Test(priority = 2)
	
	public static void get_deleted_object() {
		
		rs = RestAssured.given();
		rs.baseUri(BaseUri);
		rs.basePath(Basepath);
		
		Response res = rs.when().get();
		
		ValidatableResponse vr = res.then().log().all();
		vr.statusCode(404);
		
	}

}
