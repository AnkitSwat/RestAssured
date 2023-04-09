import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataGenerater {

	@Test
	void testGenerateDummyData()
	{
		Faker fake=new Faker();
		String name=fake.name().fullName();
		System.out.println(name);
		
	}
	
	
}
