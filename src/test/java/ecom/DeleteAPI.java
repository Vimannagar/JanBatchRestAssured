package ecom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DeleteAPI extends BaseData {
	
	@Test
	public void deleteProduct()
	{
		RestAssured.baseURI = "https://www.rahulshettyacademy.com";
		
		given()
		
		.header("Authorization", tokenid)
		
		.pathParam("prdid", productId)
		
		.when()
		
		.delete("/api/ecom/product/delete-product/{prdid}")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();


		
		
		
		
	}

}
