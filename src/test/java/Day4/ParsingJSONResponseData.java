package Day4;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;

public class ParsingJSONResponseData {

	@Test(enabled=false)
	void testJsonResponse()
	{
		
	//**	//APROACH 1
		given()
			.contentType("ContentType.JSON")
		
		.when()
			.get("http://localhost:3000/store")
			
		.then()
			.statusCode(200)
			.header("Content-Type","application/json; charset=utf-8")
			.body("book[3].title",equalTo("Mahabharat"));

						
	}
	
	@Test(enabled=false)
	void approach2() {
				
		
		Response res =given()
				.contentType("ContentType.JSON")
		
			.when()
				.get("http://localhost:3000/store");
			Assert.assertEquals(res.getStatusCode(),200);
			Assert.assertEquals(res.header("Content-Length"),"519");
				String bookname=res.jsonPath().get("book[3].title");
			Assert.assertEquals(bookname, "Mahabharat");
				
	}
	
	
	@Test
	void otherScenario()
	{
		
		Response res =given()
				.contentType("ContentType.JSON")
		
			.when()
				.get("http://localhost:3000/store");
			/* Assert.assertEquals(res.getStatusCode(),200);
			Assert.assertEquals(res.header("Content-Length"),"519");
				String bookname=res.jsonPath().get("book[3].title");
			Assert.assertEquals(bookname, "Mahabharat"); */
		
		JSONObject jo = new JSONObject(res.asString());
		boolean flag=false;
		double totalPrice=0;
		for(int i=0; i<jo.getJSONArray("book").length();i++)
		{
			String bookTitle=jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			String price=jo.getJSONArray("book").getJSONObject(i).get("price").toString();
			
			totalPrice+=Double.parseDouble(price);
			
			if(bookTitle.equals("Mahabharat"))
			{
				flag=true;	
				break;
			}
		}
		
		Assert.assertEquals(flag,true);
		//System.out.println(totalPrice);
		Assert.assertEquals(totalPrice,11209.5);
	}
}

// http://restapi.adequateshop.com/swagger/ui/index
