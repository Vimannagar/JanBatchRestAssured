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
			
					.queryParam("page", "2")
					
					.queryParams("page", "2", "book", "3")
			
					.log().all()
		
					.when()
		
					.get("/api/users")
		
					.then()
					
					.log().all()
		
					.extract()
		
					.response();
	}

}
