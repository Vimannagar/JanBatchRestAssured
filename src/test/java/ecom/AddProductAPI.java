package ecom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;

public class AddProductAPI extends BaseData {
	
	@Test
	public void addProductToApp()
	{
		
		String path = System.getProperty("user.dir")+ "\\src\\test\\resources\\Images\\TestProduct2.png";
		File file = new File(path);
		
		RestAssured.baseURI = "https://rahulshettyacademy.com";
			
		given()
		
		.header("Authorization", tokenid)
		
		.param("productName", "Party wear Jeans")
		.param("productAddedBy", userId)
		.param("productCategory", "fashion")
		.param("productSubCategory", "Trouser")
		.param("productPrice", "2000")
		.param("productDescription", "Levis Jeans")
		.param("productFor", "Women")
		.multiPart("productImage", file)
		
		.when()
		
		.post("/api/ecom/product/add-product")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response();
		
		
	}

}
