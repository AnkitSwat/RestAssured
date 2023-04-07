package Day6;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class SerializationDeserialization {

	//POJO to JSON ---- Serialization
	@Test
	void convertPojo2Json() throws JsonProcessingException
	{
		//Created Java Object Using POJO class
		Student stuPojo=new Student(); //POJO
		
		stuPojo.setName("Luffy");
		stuPojo.setPhone("clikkk");
		stuPojo.setLocation("East Blue");
		String courseArr[]= {"GumoGumo","Bink Sake"};
		stuPojo.setCourses(courseArr);
		
		//Convert Java Object to JSON object
		ObjectMapper objMapper= new ObjectMapper();
		String jsonData=objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(stuPojo);
		
		System.out.println(jsonData);
	}
	
	
	//JSON to POJO ---- Deserialization
	@Test
	void convertJson2Pojo() throws JsonMappingException, JsonProcessingException
	{
		
		String jsonData="{\r\n"
				+ "  \"name\" : \"Luffy\",\r\n"
				+ "  \"location\" : \"East Blue\",\r\n"
				+ "  \"phone\" : \"clikkk\",\r\n"
				+ "  \"courses\" : [ \"GumoGumo\", \"Bink Sake\" ]\r\n"
				+ "}";
		
		ObjectMapper objMapper= new ObjectMapper();
		
		Student stuPojo=objMapper.readValue(jsonData, Student.class);
		System.out.println(stuPojo.getName());
		System.out.println(stuPojo.getCourses()[1]);
		
		
	}
}
