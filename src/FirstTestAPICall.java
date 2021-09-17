//import static io.restassured.RestAssured.given;
//import static org.hamcrest.Matchers.equalTo;

//import org.apache.http.HttpStatus;
//import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;


public class FirstTestAPICall {
public static int userNo;
public static int postNo;
public static String baseURI =  "https://jsonplaceholder.typicode.com/";
public static String response = "";

//Buono
public static void main(String[] args) {

	RestAssured.baseURI = baseURI;
    userNo = 8;
    postNo = 101;
    //resource for user 10
    //post 100
  	for(int user=-1; user<12; user++){
  		try {	
  			//response  = PostCall.testPost(user);
  			response = GetCall.testRequest(user,"post");
    		}
    	catch (Exception e) {
    			// TODO Auto-generated catch block
    		e.printStackTrace();  		
    
    	}
  	}
  	System.out.println("Mio output" + response);
  	try {
		response = GetCall.testRequest(userNo,"get");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  	System.out.println("PostGet" + response);

}

/*
 * testPost :make the httpcall "https://jsonplaceholder.typicode.com/users/" + userNo + "/posts"
 * @postNo the post number to be created
 * @userNo userNo that create the post
 * @post   json file to be passed
*/

//public static void testPost(int userNo, int postNo, String body) throws Exception {
    
//    given().log().all().header("Content-Type", "application/json")
//			.body("{\r\n"+ 
//             "        \"title\": \"foo title\",\n" +
//			 "        \"body\": \"foo body\"\n" + 
//             "}\r\n" +
//			 " ")
//    .when()
//    .post("users/" + userNo + "/posts")
//    .then().log().all()
//        .assertThat().statusCode(HttpStatus.SC_CREATED); 
//   // https://hc.apache.org/httpclient-legacy/apidocs/org/apache/commons/httpclient/HttpStatus.html
//}

/*
 * testPost :make the httpcall "https://jsonplaceholder.typicode.com/users/" + userNo + "/posts"
 * @userNo userNo that create the post
 * @post   json file to be passed
*/

//public static void testPost(int userNo) throws Exception {
    
//    given().log().all().header("Content-Type", "application/json")
//	  .body("{\r\n" +
//			"        \"title\": \"foo title\",\n" +
//	        "        \"body\": \"foo body\"\n" +
//	        "}\r\n" +
//	        " ")
    
 //   .when()
 //   .post("users/" + userNo + "/posts")
 //   .then().log().all()
 //       .assertThat().statusCode(HttpStatus.SC_CREATED);   
//}

}
