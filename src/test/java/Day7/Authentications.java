package Day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Authentications {

	
	@Test(enabled=false,priority=1)
	void testBasicAuthentication()
	{
		
		given()
			.auth().basic("postman","password")
		
			.when()
				.get("https://postman-echo.com/basic-auth")
				
			.then()
				.statusCode(200)
				//.body("authenticated",equalTo(true))
				.log().all();
	}
	
	@Test(enabled=false,priority=2)
	void testDigestAuthentication()
	{
		
		given()
			.auth().digest("postman","password")
		
			.when()
				.get("https://postman-echo.com/basic-auth")
				
			.then()
				.statusCode(200)
				//.body("authenticated",equalTo(true))
				.log().all();
	}
	
	
	@Test(enabled=false,priority=3)
	void testPreemptiveAuthentication()
	{
		
		given()
			.auth().preemptive().basic("postman","password")
		
			.when()
				.get("https://postman-echo.com/basic-auth")
				
			.then()
				.statusCode(200)
				//.body("authenticated",equalTo(true))
				.log().all();
	}
	
	
	
	@Test(enabled=false,priority=4)
	void testBearerAuthentication()
	{
		
		String token="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";
		
		given()
			.header("Authorization","Bearer "+token)
			
		.when()
			.get("https://api.github.com/user/repos")
			
		.then()
		.statusCode(200)
		.log().all();			
			
	}
	
	
	@Test(enabled=false,priority=5)
	void testOauth2Authentication()
	{
		
		given()
			.auth().oauth2("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")
			
		.when()
		.get("https://api.github.com/user/repos")
		
		.then()
		.statusCode(200)
		.log().all();			
			
		
	}
	
	@Test()
	void testAPIKeyAuthentication()
	{
		
		/* Method 1
		given()
			.queryParam("appid", "6e4016fb82e7b97cdaa281a702c47a5e")
			
		.when()
			.get("https://api.openweathermap.org/data/2.5/forecast/daily?q=Delhi&units=metric&cnt=7")
			
		.then()
			.statusCode(200)
			.log().all();
			*/
		
		//method2
		
		given()
			.queryParam("appid", "6e4016fb82e7b97cdaa281a702c47a5e")
			.pathParam("mypath","/data/2.5/forecast/daily")
			.queryParam("q","Delhi")
			.queryParam("cnt", "7")
			
		.when()
			.get("https://api.openweathermap.org/{mypath}")
			
		.then()
			.statusCode(200)
			.log().all();
			
	}
	
}
