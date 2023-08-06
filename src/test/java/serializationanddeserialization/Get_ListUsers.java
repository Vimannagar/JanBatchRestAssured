package serializationanddeserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.Get_ResponseBody;
import pojo.Support;

public class Get_ListUsers {
	

	@Test
	public void getUsers()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
Get_ResponseBody responseBody = given()
		
								.when()
		
								.get("/api/users?page=2")
		
								.then()
		
								.extract()
		
								.response()
					
								.as(Get_ResponseBody.class);

	Integer totalvalue = responseBody.getTotal();
	
	System.out.println(totalvalue);
	
	Support support = responseBody.getSupport();
	
	String textvalue = support.getText();
	
	System.out.println(textvalue);
	
	
//	WAP to fetch the third id value from the json response
	

}
}