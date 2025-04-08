package com.api.qa.CRUD.POJOS.MJ;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Gson_serialisation {
	
	public static RequestSpecification rs ;
	public static Response res ;
	public static ValidatableResponse vr ;

	public static String BaseUri = "https://api.restful-api.dev";
	public static String Basepath = "/objects";
	public static String payloadpost = "";
	public static String payloadput = "";
	public static String id = "";
	@Test
	public static void TC_1_Restfulobject_post() {
		
		Restfullobject obj = new Restfullobject();
		obj.setName("Apple MacBook Pro 16" );
		Restfuldata data = new Restfuldata();
		data.setYear(2019);
		data.setPrice(188.22);
		data.setHard_disk_Size("2 TB");
		data.setCPU_Model("Intel Core i9");
		obj.setData(data);
		
		System.out.println(obj);
		
		Gson gsondata = new Gson();
		payloadpost = gsondata.toJson(obj);
		
		System.out.println(payloadpost);

		rs = RestAssured.given();
		rs.baseUri(BaseUri);
		rs.basePath(Basepath);
		rs.contentType(ContentType.JSON);
		rs.body(payloadpost).log().all();
		
		
		res = rs.when().post();
		
		vr = res.then().log().all();
		
		vr.statusCode(200);
		
		String createdAt = res.jsonPath().getString("createdAt");
		assertThat(createdAt).isNotEmpty().isNotNull();
		
		 id = res.jsonPath().getString("id");
		assertThat(id).isNotEmpty().isNotNull();
		
		System.out.println("Assertion are completed");
		
	System.out.println("Testcase _1 _executed sucessfully");
		
		
		
		
	}

	
	@Test
	public static void TC_2_Restfulobject_post() {
		
		String Basepathput = Basepath+"/"+id;
		System.out.println(Basepathput);
		
		Restfullobject obj = new Restfullobject();
		obj.setName("Apple MacBook Pro 20");
		Restfuldata data = new Restfuldata();
		data.setYear(2020);
		data.setPrice(199.90);
		data.setHard_disk_Size("1 TB");
		data.setCPU_Model("Intel Core i9");
		data.setColor("Silver");
		obj.setData(data);

		Gson gson = new Gson();
		payloadput = gson.toJson(obj);
		System.out.println(payloadput);
		
		rs = RestAssured.given();
		rs.baseUri(BaseUri);
		rs.basePath(Basepathput);
		rs.contentType(ContentType.JSON);
		rs.body(payloadput).log().all();
		
		res = rs.when().put();
		
		vr = res.then().log().all();
		vr.statusCode(200);

		String updatedaAt = res.jsonPath().getString("updatedAt");
		assertThat(updatedaAt).isNotEmpty().isNotNull();
		System.out.println("assertion are completd sucessfully");		

		
		System.out.println("Testcase 2 executed sucessfully");		
		
		
		
	}

}
