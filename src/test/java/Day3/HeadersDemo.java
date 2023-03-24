package Day3;

import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class HeadersDemo {

	@Test(enabled=false)
	void testHeaders()
	{
		
		given()
		
		.when()
			.get("https://www.google.com")
		
		.then()
			.header("Content-Type", "text/html; charset=ISO-8859-1")
			.header("X-Frame-Options", "SAMEORIGIN")
			.log().all();
		
	}
	
	@Test(enabled=true, priority=1)
	void getHeaders()
	{
		
		Response res= given()
		
		.when()
			.get("https://www.google.com");
		
			String header= res.getHeader("Content-Type");
			//System.out.println(header);
		
		Headers myHeaders=res.getHeaders(); 
	
		for(Header hd: myHeaders)
		{
			System.out.println(hd.getName()+"   ==VALUE==    "+hd.getValue());
		}
	
	}
	
	
}
