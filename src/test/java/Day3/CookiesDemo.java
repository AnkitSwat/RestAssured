package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {

	@Test(enabled=false)
	void testCookies()
	{
		
		given()
		
		.when()
			.get("https://www.google.com")
		
		.then()
		.cookie("AEC","ARSKqsKqJv_qCzo1jX5Y2c7uWF-1fqXOqMhwRvsGts_NEGT9_-9DOJp2Pg")
			.log().all();
		
	}
	
	@Test
	void testCookies2()
	{
		
		Response rs=given()
		
		.when()
			.get("https://www.google.com");
		
		String cookie_val= rs.getCookie("AEC");
		//System.out.println("The value is "+cookie_val);
		
		Map<String, String> cookies_values=rs.getCookies();
		System.out.println(cookies_values.keySet());
		
		for(String k:cookies_values.keySet())
		{
			String cookie_value= rs.getCookie(k);
			System.out.println(k+"  :  "+cookie_value);
		}
		
	}
	
}
