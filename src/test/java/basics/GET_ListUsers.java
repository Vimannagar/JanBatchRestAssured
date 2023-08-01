package basics;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class GET_ListUsers {
	
	
	@Test
	public void getUsers()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
	Response resp = given()
		
					.when()
		
					.get("/api/users/2")
		
					.then()
		
					.extract()
		
					.response();
	
	String stringresponse = resp.asPrettyString();
	
		System.out.println(stringresponse);
		
		
		int stscode = resp.statusCode();// fetching the status code
		
		System.out.println(stscode);//200
		
		Assert.assertEquals(stscode, 200);
		
		long timetaken = resp.getTime();// time taken to execute and fetch the data
		
		System.out.println(timetaken);
		
	}

}
