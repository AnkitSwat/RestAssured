package Day5;


import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import org.testng.annotations.Test;

public class FileUploadAndDownload {

	@Test(enabled=true)
	void singleFileUpload()
	{
		
		File myFile=new File("C:\\Users\\toank\\OneDrive\\Desktop\\API\\FileUploadAPI\\TestFile2.txt");
		
		given()
			 .multiPart("file",myFile)
			 .contentType("multipart/form-data")
			 
		.when()
			.post("http://localhost:8080/uploadFile")
			
		.then()
			.statusCode(200)
			.body("fileName", equalTo("TestFile2.txt"));
			//.log().all();
		
	}
	
	@Test(enabled=false)
	void multipleFileUpload()
	{
		
		File myFile1=new File("C:\\Users\\toank\\OneDrive\\Desktop\\API\\FileUploadAPI\\TestFile1.txt");
		File myFile2=new File("C:\\Users\\toank\\OneDrive\\Desktop\\API\\FileUploadAPI\\TestFile2.txt");
		
		given()
			 .multiPart("files",myFile1)
			 .multiPart("files",myFile2)
			 .contentType("multipart/form-data")
			 
		.when()
			.post("http://localhost:8080/uploadMultipleFiles")
			
		.then()
			.statusCode(200)
			.body("[0].fileName", equalTo("TestFile1.txt"))
			.body("[1].fileName", equalTo("TestFile2.txt"))
			.log().all();
		
	}
	
	
	@Test
	void fileDownload()
	{
		given()
		
		.when()
			.get("http://localhost:8080/downloadFile/TestFile2.txt")
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
}
