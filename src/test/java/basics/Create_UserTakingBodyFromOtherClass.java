package basics;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Create_UserTakingBodyFromOtherClass {
	
	@Test
	public void createUser()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response response = given()
		
		.body(JsonBody.getBody())
		
		.header("Content-Type", "application/json")
		
		.when()
		
		.post("/user")
		
		.then()
		
		.extract()
		
		.response();
		
		String strResp = response.asPrettyString();
		
		System.out.println(strResp);
			
	}

}
