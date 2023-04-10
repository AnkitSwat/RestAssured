package Day8;

import org.json.JSONObject;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class CreateUser {

	
	@Test
	void test_CreateUser()
	{
		Faker faker=new Faker();
		
		JSONObject data= new JSONObject();
		data.put("name", faker.name().fullName());
		data.put("gender","male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken="e633fcb3458d13141a39fa161ff111ae55137ceb723e8fb538afc7d6d991a8c1";
		
		
		
	int id=given()
			.header("Authorization","Bearer "+bearerToken)
			.contentType("application/json")
			.body(data.toString())
			
		.when()
			.post("https://gorest.co.in/public/v2/users")
			.jsonPath().getInt("id");
	
	System.out.println("ID value is: "+id);
			
		
		
	}
	
}
