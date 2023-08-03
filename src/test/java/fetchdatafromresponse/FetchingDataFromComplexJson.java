package fetchdatafromresponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchingDataFromComplexJson {
	
	
	@Test
	public void getUsers()
	{
		RestAssured.baseURI = "https://reqres.in/";
		
	Response resp = given()
			
					.log().all()
		
					.when()
		
					.get("/api/users?page=2")
		
					.then()
					
					.log().all()
					
					.extract()
		
					.response();
	
	JsonPath js = resp.jsonPath();
	
	int totalPagesValue = js.getInt("total_pages");
	
	System.out.println(totalPagesValue);//2
	
	String urlValue = js.getString("support.url");
	
	System.out.println(urlValue);//"https://reqres.in/#support-heading"
	
//	fetching the value from array
	
	String lastname = js.getString("data[0].last_name");
	
	System.out.println(lastname);//Lawson
	
int totalElements = js.getInt("data.size()");

System.out.println(totalElements);//6
	

//Assignment: WAP to print all the values of email addresses for all the elements of array

//Assignment: WAP to print the lastname of user whose firstname is Byron
	
	
	}

}
