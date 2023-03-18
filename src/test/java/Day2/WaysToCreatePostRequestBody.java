package Day2;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class WaysToCreatePostRequestBody {

	//@Test(priority=1)
	void testPostUsingHashMap() {
		
		HashMap data = new HashMap();
		data.put("name", "Luffy");
		data.put("location", "east blue");
		data.put("phone", "clickkkk");
		
		String corsArr[]= {"ponygliff", "laughTale"};
		data.put("courses", corsArr);
		
		given()
			.contentType("application/json")
			.body(data)
			
		.when()
			.post("http://localhost:3000/students")
			
		.then()
			.statusCode(201)
			.body("name",equalTo("Luffy"))
			.body("location",equalTo("east blue"))
			.body("phone",equalTo("clickkkk"))
			.body("courses[0]",equalTo("ponygliff"))
			.header("content-Type", "application/json; charset=utf-8")
			.log().all();
	}
	
	
	//@Test(priority=1)
	void testPostUsingJSON() {
			
			JSONObject data = new JSONObject();
			data.put("name", "Luffy");
			data.put("location", "east blue");
			data.put("phone", "clickkkk");
			
			String corsArr[]= {"ponygliff", "laughTale"};
			data.put("courses", corsArr);
			
			given()
				.contentType("application/json")
				.body(data.toString())
				
			.when()
				.post("http://localhost:3000/students")
				
			.then()
				.statusCode(201)
				.body("name",equalTo("Luffy"))
				.body("location",equalTo("east blue"))
				.body("phone",equalTo("clickkkk"))
				.body("courses[0]",equalTo("ponygliff"))
				.header("content-Type", "application/json; charset=utf-8")
				.log().all();
		}
		
	
	//@Test(priority=1)
	void testPostUsingExternalJsonFile() throws FileNotFoundException {
			
		File f = new File(".\\body.json");
		FileReader fr= new FileReader(f);
		JSONTokener jt=new JSONTokener(fr);
		JSONObject data= new JSONObject(jt);
		
			
			given()
				.contentType("application/json")
				.body(data.toString())
				  
			.when()
				.post("http://localhost:3000/students")
				
			.then()
				.statusCode(201)
				.body("name",equalTo("Luffy"))
				.body("location",equalTo("east blue"))
				.body("phone",equalTo("clickkkk"))
				.body("courses[0]",equalTo("ponygliff"))
				.header("content-Type", "application/json; charset=utf-8")
				.log().all();
		}
	
	@Test(priority=1)
	void testPostUsingPOJO() {
		
		Pojo_postRequest data= new Pojo_postRequest();
		data.setName("Luffy");
		data.setPhone("clickkkk");
		data.setLocation("east blue");
		String courseArr[]= {"ponygliff","longpost"};
		data.setCourses(courseArr);
		
			given()
				.contentType("application/json")
				.body(data)
				  
			.when()
				.post("http://localhost:3000/students")
				
			.then()
				.statusCode(201)
				.body("name",equalTo("Luffy"))
				.body("location",equalTo("east blue"))
				.body("phone",equalTo("clickkkk"))
				.body("courses[0]",equalTo("ponygliff"))
				.header("content-Type", "application/json; charset=utf-8")
				.log().all();
		}
	
	
	@Test(priority=2)
	void testDelete()
	{
		given()
		
		.when()
			.delete("http://localhost:3000/students/7")
	
		.then()
			.statusCode(200);
	}
	
}
