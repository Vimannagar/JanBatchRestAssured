package fetchdatafromresponse;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class FetchDetailsFromReadyMadeJson {

	
	@Test
	public void fetchData()
	{
		
		String json = "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"www.abc.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";
		
		
		JsonPath jp = new JsonPath(json);
		
		String value = jp.getString("dashboard.website");
		
		System.out.println(value);//www.abc.com
		
		
//		Solution for 4th point
		
		int courseCount = jp.getInt("courses.size()");
		
		for(int i=0; i<courseCount; i++)
		{
			String title = jp.getString("courses["+i+"].title");
			int price = jp.getInt("courses["+i+"].price");
			
			System.out.println(title+" : "+price);
			
			
		}
		
//		Solution for 6th point
		
		int sum = 0;
		
		for(int i=0; i<courseCount; i++)
		{
			int copiesCount = jp.getInt("courses["+i+"].copies");
			int price = jp.getInt("courses["+i+"].price");
			
			int amount = price * copiesCount;
			
			sum = sum+ amount;
				
		}
		
		int totalAmount = jp.getInt("dashboard.purchaseAmount");
		
		Assert.assertEquals(sum, totalAmount);
		
	}
	
	
}
