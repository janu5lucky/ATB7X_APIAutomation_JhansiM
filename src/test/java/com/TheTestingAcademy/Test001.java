package com.TheTestingAcademy;

import io.restassured.RestAssured;

public class Test001
{
    public static void main(String[] args) {

        System.out.println("Rest Assured Test Case");
        System.out.println("GET Request Demo");


        //Gherkins Syntax---------
        // given() - url, headers ,  body or payload
        //when() - http methods - get, post , patch, put , delete
        // then() - verify the response
        RestAssured
                .given().baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking/1").log().all()
                .when()
                .get()
                .then()
                .statusCode(200);


    }
}
