package Day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class LogginDemo {

	@Test
	void testLogs()
	{
		
		given()
		
		.when()
			.get("https://www.google.com")
			
		.then();
			//.log().body();
			//.log().cookies();
			//.log().headers();
			//.log().all();
	}
	
}
