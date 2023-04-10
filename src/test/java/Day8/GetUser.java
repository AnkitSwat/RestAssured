package Day8;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class GetUser {

	String bearerToken="e633fcb3458d13141a39fa161ff111ae55137ceb723e8fb538afc7d6d991a8c1";
	 
	void test_getUser()
	{
	
		int id=0;//this should come from create Request class
		
		given()
		.header("Authorization","Bearer "+bearerToken)
		.pathParam("id",id)
		
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
}
