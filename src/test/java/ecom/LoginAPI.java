package ecom;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LoginAPI extends BaseData{
	
	
	@Test
	public void createUser()
	{
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
		Response response = given()
		
		.body("{\r\n"
				+ "    \"userEmail\": \"gouravjawale0708@gmail.com\",\r\n"
				+ "    \"userPassword\": \"Test@1234\"\r\n"
				+ "}")
		
		.header("Content-Type", "application/json")
		
		.when()
		
		.post("/api/ecom/auth/login")
		
		.then()
		
		.extract()
		
		.response();
		
		String strResp = response.asPrettyString();
		
		System.out.println(strResp);
		
		JsonPath jp = response.jsonPath();
		
		String idOfUser = jp.getString("userId");
		
		userId = idOfUser;
		
		System.out.println("User id is "+idOfUser);
		
		String tokenvalue = jp.getString("token");
		
		System.out.println(tokenvalue);
		
		tokenid = tokenvalue;
		
		
			
	}
	

}
