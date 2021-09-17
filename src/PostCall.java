import static io.restassured.RestAssured.given;
import org.apache.http.HttpStatus;
import org.junit.Test;

class PostCall {

	
/*
 * testPost :make the httpcall "https://jsonplaceholder.typicode.com/users/" + userNo + "/posts"
 * @postNo the post number to be created
 * @userNo userNo that create the post
 * @post   json file to be passed
*/
	@Test
public static void testPost(int userNo, int postNo, String body) throws Exception {
    
    given().log().all().header("Content-Type", "application/json")
			.body("{\r\n"+ 
             "        \"title\": \"foo title\",\n" +
			 "        \"body\": \"foo body\"\n" + 
             "}\r\n" +
			 " ")
    .when()
    .post("users/" + userNo + "/posts")
    .then().log().all()
        .assertThat().statusCode(HttpStatus.SC_CREATED); 
 // https://hc.apache.org/httpclient-legacy/apidocs/org/apache/commons/httpclient/HttpStatus.html
}


/*
 * testPost :make the httpcall "https://jsonplaceholder.typicode.com/users/" + userNo + "/posts"
 * @userNo userNo that create the post
 * @post   json file to be passed
 * return response body as string 
*/
	@Test
public static String testPost(int userNo) throws Exception {
    
    return given().log().all().header("Content-Type", "application/json")
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

}
