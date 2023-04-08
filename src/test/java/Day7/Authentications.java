package Day7;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Authentications {

	
	@Test(priority=1)
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
	
	@Test(priority=2)
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
	
	
	@Test(priority=3)
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
	
	
	
	@Test(priority=4)
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
	
	
	@Test(priority=5)
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
	
}
