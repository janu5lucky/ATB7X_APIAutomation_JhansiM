package com.api.qa.CRUD.GET;

import io.restassured.RestAssured;

public class BddStyle_GET_Req_Ex_004 {
	public static void main(String[] args) {
		
		
		BDD_test1();
		BDD_test2();
		
	}

	private static void BDD_test1() {
		
		RestAssured.given().relaxedHTTPSValidation()
		.baseUri("https://api.zippopotam.us")
		.basePath("/IN/560037").log().all()
		.when().get()
		.then().log().all()
		.statusCode(200); 
		
		System.out.println("Got 200 as status code - success ");
	}

	private static void BDD_test2() {
		// TODO Auto-generated method stub
		RestAssured.given().baseUri("https://api.zippopotam.us")
		.basePath("/IN/-1").log().all()
		.when().get()
		.then().log().all()
		.statusCode(404); 
		
		System.out.println("Got 404 as status code - Not Found ");
		
	}

}
