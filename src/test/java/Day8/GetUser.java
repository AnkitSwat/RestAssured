package Day8;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.Test;


public class GetUser {

	@Test
	void test_getUser(ITestContext context)
	{
		String bearerToken="e633fcb3458d13141a39fa161ff111ae55137ceb723e8fb538afc7d6d991a8c1";
		
		int id=(Integer) context.getSuite().getAttribute("user_id");//this should come from create Request class
		
		given()
		.headers("Authorization","Bearer "+bearerToken)
		.pathParam("id",id)
		
		.when()
			.get("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
}
