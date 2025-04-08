package com.api.qa.CRUD.POJOS.MJ;

public class Restfullobject {
	
	public static String payload = "{\r\n"
			+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
			+ "   \"data\": {\r\n"
			+ "      \"year\": 2019,\r\n"
			+ "      \"price\": 1849.99,\r\n"
			+ "      \"CPU model\": \"Intel Core i9\",\r\n"
			+ "      \"Hard disk size\": \"2 TB\"\r\n"
			+ "   }\r\n"
			+ "}";
	
	private String name ;
	private Restfuldata data ;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Restfuldata getData() {
		return data;
	}
	public void setData(Restfuldata data) {
		this.data = data;
	}
	

	

}
