package com.api.qa.CRUD.POJOS.MJ;

public class Restfuldata {

	public static String payload = "{\r\n"
			+ "   \"name\": \"Apple MacBook Pro 16\",\r\n"
			+ "   \"data\": {\r\n"
			+ "      \"year\": 2019,\r\n"
			+ "      \"price\": 1849.99,\r\n"
			+ "      \"CPU model\": \"Intel Core i9\",\r\n"
			+ "      \"Hard disk size\": \"2 TB\"\r\n"
			+ "   }\r\n"
			+ "}";
	private Integer year ;
	private Double price ;
	private String CPU_Model ;
	private String hard_disk_Size ;
	private String color ;
	
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getCPU_Model() {
		return CPU_Model;
	}
	public void setCPU_Model(String cPU_Model) {
		CPU_Model = cPU_Model;
	}
	public String getHard_disk_Size() {
		return hard_disk_Size;
	}
	public void setHard_disk_Size(String hard_disk_Size) {
		this.hard_disk_Size = hard_disk_Size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	

}
