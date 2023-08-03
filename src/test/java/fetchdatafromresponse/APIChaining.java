package fetchdatafromresponse;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class APIChaining {
static	String messagevalue;
	
	@Test(priority = 1)
	public void createUser()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
		Response response = given()
		
		.body("{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"username\": \"eder\",\r\n"
				+ "  \"firstName\": \"diana\",\r\n"
				+ "  \"lastName\": \"matthew\",\r\n"
				+ "  \"email\": \"diana.matthew@velocity.com\",\r\n"
				+ "  \"password\": \"Test@1234\",\r\n"
				+ "  \"phone\": \"9876543213\",\r\n"
				+ "  \"userStatus\": 0\r\n"
				+ "}")
		
		.header("Content-Type", "application/json")
		
		.when()
		
		.post("/user")
		
		.then()
		
		.extract()
		
		.response();
		
		String strResp = response.asPrettyString();
		
		System.out.println(strResp);
		
		JsonPath js = response.jsonPath();
		
	 messagevalue = js.getString("message");
					
	}
	
	
	
	@Test(priority = 2)
	public void getUserDetails()
	{
		RestAssured.baseURI = "https://petstore.swagger.io/v2";
		
	Response resp = given()
		
		.when()
		
		.get("/user/eder")
		
		.then()
		
		.extract()
		
		.response();
	
	String response = resp.asPrettyString();
	
	System.out.println(response);
	
	JsonPath jp = resp.jsonPath();
	
	String uname = jp.getString("username");
	
	System.out.println(uname);
	
//	long idvalue = jp.getLong("id");
//	
//	System.out.println(idvalue);
	
	String idvalue = jp.getString("id");
	
	
	Assert.assertEquals(idvalue, messagevalue);
	
	}

}
