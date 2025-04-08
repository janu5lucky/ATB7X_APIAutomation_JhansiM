package com.api.qa.CRUD.POJOS;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class De_serialisation_pojo_Class_Ex_001 {
	
	public static RequestSpecification rs ;
	public static Response res;
	public static ValidatableResponse vr;
	public static String BaseUri = "https://restful-booker.herokuapp.com";
	public static String BasePathPost = "/booking";

	@Description("Serialisation class ")
	@Test
	public static void Pojoserialization() {
		
		
		rs = RestAssured.given();
		rs.baseUri(BaseUri);
		rs.basePath(BasePathPost);
		
		Booking booking = new Booking();
		booking.setFirstname("Karthik");
		booking.setLastname("james");
		booking.setTotalprice(123);
		booking.setDepositpaid(true);
		
		BookingDates bookingdates = new BookingDates();
		bookingdates.setCheckin("2025-01-01");
		bookingdates.setCheckout("2025-01-01");
		
		booking.setBookingdates(bookingdates);
		
		booking.setAdditionalneeds("BreakFast");

		System.out.println(booking);
		// Now convert Java Object to Json String 
		
		Gson gson = new Gson();
		String jsonpayload = gson.toJson(booking);
		System.out.println(jsonpayload);
		
		rs = RestAssured.given();
		rs.baseUri(BaseUri);
		rs.basePath(BasePathPost);
		rs.contentType(ContentType.JSON);
		rs.body(jsonpayload).log().all();
		
		res = rs.when().post();
		
		vr = res.then().log().all();
		vr.statusCode(200);
		String responseString = res.asString();
		System.out.println("Test Executed sucessfully ");
		
// 			Deserialisation 
		
		BookingResponse bookingresponse = gson.fromJson(responseString, BookingResponse.class);
		System.out.println(bookingresponse.getBookingid());
		System.out.println(bookingresponse.getBooking().getFirstname());
		assertThat(bookingresponse.getBooking().getFirstname()).isEqualTo("Karthik").isNotEmpty().isNotNull();
		assertThat(bookingresponse.getBooking().getLastname()).isEqualTo("james").isNotEmpty().isNotNull();

		
		System.out.println("Assertions are completed");
		
		
}

}