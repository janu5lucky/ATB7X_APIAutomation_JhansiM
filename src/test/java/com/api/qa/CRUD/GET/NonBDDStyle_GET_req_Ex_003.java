package com.api.qa.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyle_GET_req_Ex_003 {
 static RequestSpecification r = RestAssured.given();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		r.baseUri("https://api.zippopotam.us");
			NoBDD_test1();
			NoBDD_test2();
			
		
		
	}
	public static void NoBDD_test1() {
		
		r.basePath("/IN/560037").log().all();
		r.when().get();
		r.then().log().all().statusCode(200);
		
		System.out.println("Got 200 as status code - success ");
		
	}
	public static void NoBDD_test2() {

		r.basePath("/IN/500090").log().all();
		r.when().get();
		r.then().log().all().statusCode(404);
		
		System.out.println("Got 404 as status code - Not Found ");
	}

}
