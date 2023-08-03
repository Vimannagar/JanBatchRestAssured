package fetchdatafromresponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GET_ListUser {
	
	@Test
	public void getUsers()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
	Response resp = given()
			
					.log().all()
		
					.when()
		
					.get("/api/users/2")
		
					.then()
					
					.log().all()
		
					.extract()
		
					.response();
	}

}
