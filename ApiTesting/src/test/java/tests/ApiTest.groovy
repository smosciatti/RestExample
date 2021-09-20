package tests

import groovy.json.JsonSlurper
import io.restassured.builder.RequestSpecBuilder
import io.restassured.mapper.ObjectMapper
import io.restassured.mapper.ObjectMapperType
import io.restassured.specification.RequestSpecification
import org.testng.Assert
import org.testng.annotations.BeforeClass
import org.testng.annotations.Parameters
import spock.lang.Specification
import static io.restassured.RestAssured.*
import io.restassured.RestAssured
import org.testng.annotations.Test
import org.apache.http.HttpStatus
import io.restassured.http.ContentType;
import io.restassured.response.Response;


class ApiTest {
    //int userNo = 0
    //int postNo = 0
    String responseBody = ""
    // RestAssured.baseURI = baseURI

    @BeforeClass
    void setup() {
        // Setting BaseURI once
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/"

    }

/*
    @Parameters(["basepath"])
    @Test
    void PerformCall(String basepath) {
        // Setting BasePath
        RestAssured.basePath = basepath
        Response response = RestAssured.get()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        //Assert.assertEquals(statusCode, 404)
        Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("GET ALL POSTS")
        println(responseBody)
    }
*/

    @Test
    void GetAllPosts() {
        // Setting BasePath
        RestAssured.basePath = "/posts"
        Response response = RestAssured.get()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        //Assert.assertEquals(statusCode, 404)
        Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("GET ALL POSTS")
        println(responseBody)
    }

    @Test
    void GetAllUsers() {
        // Setting BasePath
        RestAssured.basePath = "/users"
        Response response = RestAssured.get()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
       // Assert.assertEquals(statusCode, 404)
        Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("GET ALL USERS")
        println(responseBody)
    }

    @Test
    void GetAllTodos() {
        // Setting BasePath
        RestAssured.basePath = "/todos"
        Response response = RestAssured.get()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        //Assert.assertEquals(statusCode, 404)
        Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("GET ALL TODOS")
        println(responseBody)

    }


    @Test
    void GetAllAlbums() {
        // Setting BasePath
        RestAssured.basePath = "/albums"
        Response response = RestAssured.get()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        //Assert.assertEquals(statusCode, 404)
        Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("GET ALL ALBUMS")
        println(responseBody)

    }

    @Test
    void GetAllPostOfTheUser() {
        // Setting BasePath
        RestAssured.basePath = "users/10/posts"
        Response response = RestAssured.get()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        //Assert.assertEquals(statusCode, 404)
        Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("GET ALL Posts of the user")
        println(responseBody)

    }

    @Test
    void GetAllTodoOfTheUser() {
        // Setting BasePath
        RestAssured.basePath = "users/10/todos"
        Response response = RestAssured.get()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        //Assert.assertEquals(statusCode, 404)
        Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("GET ALL Todos of the user")
        println(responseBody)

    }


    @Test
    void GetAllAlbumOfTheUser() {
        // Setting BasePath
        RestAssured.basePath = "users/10/albums"
        Response response = RestAssured.get()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        //Assert.assertEquals(statusCode, 404)
        Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("GET ALL Albums of the user")
        println(responseBody)

    }


    @Test
    void DeleteTheUser() {
        // Setting BasePath
        RestAssured.basePath = "users/10"
        Response response = RestAssured.delete()
        int statusCode = response.statusCode()
        //Assert.assertEquals(statusCode, 404)
        Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("Delete the user " + statusCode)
        println("***********************")
    }
    @Test
    void DeleteThePost() {
        // Setting BasePath
        RestAssured.basePath = "posts/88"
        Response response = RestAssured.delete()
        int statusCode = response.statusCode()
        //Assert.assertEquals(statusCode, 404)
        Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("Delete the Post " + statusCode)
        println("***********************")
    }

    @Test
    void PostNewPostForTheUser() {

         String payload =   ''' 
                       {
                        "userId": 4,
                        "title": "foo title",
                        "body": "foo body"
                       }
                        '''
        // Setting BasePath
        basePath = "users/4/posts"
        Response response = given().contentType (ContentType.JSON).body(payload).post()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        Assert.assertEquals(statusCode,HttpStatus.SC_CREATED)
        println("***********************")
        println("Post New Post For The User")
        println(responseBody)
    }

    @Test
    void PostNewTODoForTheUser() {

        String payload =   ''' 
                       {
                        "userId": 4,
                        "title": "foo title",
                        "completed": true
                       }
                        '''
        // Setting BasePath
        basePath = "users/4/todos"
        Response response = given().contentType (ContentType.JSON).body(payload).post()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        Assert.assertEquals(statusCode,HttpStatus.SC_CREATED)
        println("***********************")
        println("Post New ToDo For The User")
        println(responseBody)
    }


    @Test
    void PostNewAlbumForTheUser() {

        String payload =   ''' 
                       {
                        "userId": 4,
                        "title": "foo title"
                        }
                        '''
        // Setting BasePath
        basePath = "users/4/albums"
        Response response = given().contentType (ContentType.JSON).body(payload).post()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        Assert.assertEquals(statusCode,HttpStatus.SC_CREATED)
        println("***********************")
        println("Post New Album For The User")
        println(responseBody)

    }

     @Test
    void PostNewPost() {

        String payload =   ''' 
                       {
                        "title": "foo title",
                        "body": "foo body"
                        }
                        '''
        // Setting BasePath
        basePath = "/posts"
        Response response = given().contentType (ContentType.JSON).body(payload).post()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        Assert.assertEquals(statusCode,HttpStatus.SC_CREATED)
        println("***********************")
        println("Post New Post")
        println(responseBody)
    }

    @Test
    void PutThePost() {

        String payload =   ''' 
                       {
                        "title": "foo title",
                        "body": "foo body"
                        }
                        '''
        // Setting BasePath
        basePath = "/posts/44"
        Response response = given().contentType (ContentType.JSON).body(payload).put()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        Assert.assertEquals(statusCode,HttpStatus.SC_OK)
        println("***********************")
        println("Put The Post")
        println(responseBody)
    }

    @Test
    void PatchThePost() {

        String payload =   ''' 
                       {
                        "title": "foo"
                        }
                        '''
        // Setting BasePath
        basePath = "/posts/44"
        Response response = given().contentType (ContentType.JSON).body(payload).patch()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        Assert.assertEquals(statusCode,HttpStatus.SC_OK)
        println("***********************")
        println("Put The Post")
        println(responseBody)
    }


}



/* Spock ok /Report?

class ApiTest extends Specification{
    def "test1"() {
        given:
        Response response = RestAssured.get("https://reqres.in/api/users?psge2")
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        expect:
        statusCode == 200
    }
}*/
