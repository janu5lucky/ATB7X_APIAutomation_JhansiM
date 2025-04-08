package com.api.qa.CRUD.Assertions;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.json.Json;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class POST_Json_path_validation_Ex_005 {

//	private static final SeverityLevel CRITICAL = 4;
	public static RequestSpecification requestspecification;
	public static String BaseUri = "https://restful-booker.herokuapp.com";
	public static Integer bookingId;
	public static String id = "";
	public static String BasePathAuth = "/auth";
	public static String BasePathPost = "/booking";
	public static String BasePathGet = "/booking/" + id;
	public static String token = "";

	
	@Description ("This is Attempts to log into the ")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Jhansi M")
	@Link(name ="Website", url = "https://dev.example.com")
	
	@Test
	public static void validation_Jsonpath_POST() {

		
		String Payload =  "{\n" +
			    "  \"firstname\" : \"Alexandra\",\n" +
			    "  \"lastname\" : \"Thomas\",\n" +
			    "  \"totalprice\" : 123,\n" +
			    "  \"depositpaid\" : true,\n" +
			    "  \"bookingdates\" : {\n" +
			    "    \"checkin\" : \"2025-01-01\",\n" +
			    "    \"checkout\" : \"2025-02-01\"\n" +
			    "  },\n" +
			    "  \"additionalneeds\" : \"Breakfast\"\n" +
			"}";
		
		requestspecification = RestAssured.given();
		requestspecification.baseUri(BaseUri);
		requestspecification.basePath(BasePathPost);
		//requestspecification.cookie("token", token);
		requestspecification.contentType(ContentType.JSON).body(Payload).log().all();
		
		Response response = requestspecification.when().post();
		
		ValidatableResponse vr = response.then().log().all();
		id = response.jsonPath().getString("bookingid");
		System.out.println("ID:>> "+id);
		String resposnebody = response.asString();
		JsonPath jsonpath = new  JsonPath(response.asString());
		bookingId = jsonpath.get("bookingid");
		
		String firstname = jsonpath.getString("booking.firstname");
		String lastname = jsonpath.getString("booking.lastname");
		String	checkout =jsonpath.getString("booking.bookingdates.checkout");	
		Assert.assertEquals(firstname, "Alexandra");
		System.out.println("Assert firstname " );
		

		assertThat(bookingId).isNotNull().isNotZero().isPositive();
		System.out.println("Assert bookingId not null  " );

		assertThat(lastname).isNotNull().isEqualTo("Thomas");
		System.out.println("Assert lastname  " );

		System.out.println(resposnebody);
		
		

	}

	@Test
	public static void validation_Jsonpath_Response() {

		
		String Response =  "{\r\n"
				+ "  \"firstName\": \"Alexandra 2\",\r\n"
				+ "  \"lastName\": \"Thomas\",\r\n"
				+ "  \"age\": 26,\r\n"
				+ "  \"address\": {\r\n"
				+ "    \"streetAddress\": \"naist street\",\r\n"
				+ "    \"city\": \"Nara\",\r\n"
				+ "    \"postalCode\": \"630-0192\"\r\n"
				+ "  },\r\n"
				+ "  \"phoneNumbers\": [\r\n"
				+ "    {\r\n"
				+ "      \"type\": \"iPhone\",\r\n"
				+ "      \"number\": \"0123-4567-8888\"\r\n"
				+ "    },\r\n"
				+ "    {\r\n"
				+ "      \"type\": \"home\",\r\n"
				+ "      \"number\": \"0123-4567-8910\"\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}\r\n"
				+ "";
		
		JsonPath jsonpath = new JsonPath(Response);
		
		String firstname = jsonpath.getString("firstName");
		assertThat(firstname).isEqualTo("Alexandra 2");
		System.out.println("Jsonpath firstname validated");
		String phonenumberytype = jsonpath.getString("phoneNumbers[0].type");
		assertThat(phonenumberytype).isNotEmpty().isEqualTo("iPhone");
		System.out.println("Jsonpath iPhone validated");
		
		String streetaddress = jsonpath.getString("address.streetAddress");
		assertThat(streetaddress).isNotEmpty().isEqualTo("naist street");
		System.out.println("Jsonpath street address validated");

	}

}
