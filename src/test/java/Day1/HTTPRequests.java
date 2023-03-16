package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;


public class HTTPRequests {

	int id;
	
	@Test(priority=1)
	void getUsers() {
		
		given()

		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
	
	
	//@Test(priority=2)
	void createUser()
	{
		HashMap data=new HashMap();
		data.put("name","Luffy");
		data.put("job","Captain");
		
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(201)
			.log().all();
	
	}

	@Test(priority=3)
	void createUserGetId()
	{
		HashMap data=new HashMap();
		data.put("name","Luffy");
		data.put("job","Captain");
		
		
		id=given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
	
	}

	@Test(priority=4,dependsOnMethods= {"createUserGetId"})
	void updateUser()
	{
		HashMap data=new HashMap();
		data.put("name","Zoro");
		data.put("job","Swordsman");
		
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.put("https://reqres.in/api/users/"+id)
			
		.then()
		.statusCode(200)
		.log().all();
	}
	
	@Test(priority=5,dependsOnMethods= {"createUserGetId"})
	void deleteUser() {
		
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(204)
			.log().all();
		
		
	}
}
