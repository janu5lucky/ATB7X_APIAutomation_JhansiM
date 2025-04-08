package com.api.qa;
import io.restassured.RestAssured;

public class Ex_001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				System.out.println("Get Request demo");
				
			RestAssured.given().baseUri("https://www-api.pos.com.my/api")
			.basePath("/countries").log().all()
			.when().get()
			.then().log().all()
			.statusCode(200); 
			
			System.out.println("Successfull");

		
	}

}
