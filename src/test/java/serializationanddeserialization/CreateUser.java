package serializationanddeserialization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.RequestBody;
import pojo.ResponseBody;

public class CreateUser {
	
	@Test
	public void createUser()
	{
		RequestBody requestBody = new RequestBody();
		requestBody.setId(0);
		requestBody.setUsername("Ederuser");
		requestBody.setFirstName("Eder");
		requestBody.setLastName("Mejia");
		requestBody.setEmail("eder.mejia@abc.com");
		requestBody.setPassword("Test@1234");
		requestBody.setPhone("998877665544");
		requestBody.setUserStatus(0);
		
		
		
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
	ResponseBody resbody = given()
		
		.body(requestBody)
		
		.header("Content-Type", "application/json")
		
		.when()
		
		.post("/user")
		
		.then()
		
		.log().all()
		
		.extract()
		
		.response()
		
		.as(ResponseBody.class);
		
	
	String messageValue= resbody.getMessage();
	
	System.out.println(messageValue);
		
			
	}


}
