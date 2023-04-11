package Day8;


import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class UpdateUser {

	
	@Test
	void test_UpdateUser(ITestContext context)
	{
		Faker faker=new Faker();
		
		JSONObject data= new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender","Female");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "active");
		
		String bearerToken="e633fcb3458d13141a39fa161ff111ae55137ceb723e8fb538afc7d6d991a8c1";
		
		int id=(Integer) context.getSuite().getAttribute("user_id");
		
		given()
			.headers("Authorization","Bearer "+bearerToken)
			.contentType("application/json")
			.body(data.toString())
			.pathParam("id",id)
			
		.when()
			.put("https://gorest.co.in/public/v2/users/{id}")
			
			
		.then()
			.statusCode(200)
			.log().all();
	
	
			
		
		
	}
	
}
