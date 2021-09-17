import static io.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.junit.Test;

//import static org.junit.jupiter.api.Assertions.assertTrue;

//import org.junit.jupiter.api.Test;
//import pages.HomePage;

public class GetCall {

	
	/*
	 * testPost :make the httpcall "https://jsonplaceholder.typicode.com/users/" + userNo + "/posts" 
	 * depending of reqType parameter (get/post)
	 * @param userNo that create the post, reqType   json file to be passed
	 * @return response body as string 
	*/
	@Test
	public static String testRequest(int userNo, String reqType) throws Exception {
	    String responseCall = " ";
	    switch (reqType) {
	    case ("post"):{
	    
	    responseCall = given().log().all().header("Content-Type", "application/json")
		  .body("{\r\n" +
				"        \"title\": \"foo title\",\n" +
		        "        \"body\": \"foo body\"\n" +
		        "}\r\n" +
		        " ")
	    
	   .when()
	   .post("users/" + userNo + "/posts")
	   .then().log().all()
	       .assertThat().statusCode(HttpStatus.SC_CREATED).extract().response().asString();
	    }

	    case ("get"):{
		    
		    responseCall = given().log().all().header("Content-Type", "application/json")
			  .body("{\r\n" +
					"        \"title\": \"foo title\",\n" +
			        "        \"body\": \"foo body\"\n" +
			        "}\r\n" +
			        " ")
		    
		   .when()
		   .get("users/" + userNo + "/posts")
		   .then().log().all()
		       .assertThat().statusCode(HttpStatus.SC_OK).extract().response().asString();
		    }
	    
	}
	    return responseCall;
}
}
