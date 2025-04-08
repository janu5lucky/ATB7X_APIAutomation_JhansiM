package com.api.qa.CRUD.GET;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyle_GET_Ex_002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Non BDD Style ");

		RequestSpecification r =  RestAssured.given();
		r.baseUri("https://api.zippopotam.us");
		r.basePath("").log().all();
		r.when().get();
		r.then().log().all().statusCode(200);
		
		System.out.println("Sucess");
		

	}

}
