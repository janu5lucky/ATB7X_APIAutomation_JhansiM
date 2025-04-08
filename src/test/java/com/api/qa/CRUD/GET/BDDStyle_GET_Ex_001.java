package com.api.qa.CRUD.GET;

import io.restassured.RestAssured;

public class BDDStyle_GET_Ex_001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://api.zippopotam.us/IN/560037
			
			System.out.println("Zippotam Search");
		
		RestAssured.given().baseUri("https://api.zippopotam.us")
		.basePath("/IN/560037").log().all()
		.when().get()
		.then().log().all()
		.statusCode(200); 
		
		System.out.println("Successfull");
	}

}
