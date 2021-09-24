package tests

import org.testng.Assert
import org.testng.annotations.Test
import spock.lang.Shared
import spock.lang.Specification
import static io.restassured.RestAssured.*
import org.apache.http.HttpStatus
import io.restassured.http.ContentType
import io.restassured.response.Response



class ApiTest extends Specification{
    String responseBody = ""
    int statusCode = 0

    def setupSpec() {
        baseURI = "https://jsonplaceholder.typicode.com/"
    }
    def "get  all posts"() {
        given: "GET https://jsonplaceholder.typicode.com/posts"
        basePath = "/posts"
        Response response = get()
        responseBody = response.asString()
        statusCode = response.statusCode()
        println("***********************")
        println ("GET ALL POSTS -> " + statusCode)
        println(responseBody)
        expect: "status code 200"
        statusCode == HttpStatus.SC_OK
    }

    def "get all users"() {
        given:"GET https://jsonplaceholder.typicode.com/users"
        basePath = "/users"
        Response response = get()
        responseBody = response.asString()
        statusCode = response.statusCode()
        println("***********************")
        println("GET ALL USERS -> " + statusCode)
        println(responseBody)
        expect: "status code 200"
        statusCode == HttpStatus.SC_OK
    }


    def "get all todos"() {
        given:"GET https://jsonplaceholder.typicode.com/todos"
        basePath = "/todos"
        Response response = get()
        responseBody = response.asString()
        statusCode = response.statusCode()
        println("***********************")
        println("GET ALL TODOS -> " + statusCode)
        println(responseBody)
        expect: "status code 200"
        statusCode == HttpStatus.SC_OK

    }


    def "get all albums"() {
        given:"GET https://jsonplaceholder.typicode.com/albums"
        basePath = "/albums"
        Response response = get()
        responseBody = response.asString()
        statusCode = response.statusCode()
        println("***********************")
        println("GET ALL ALBUMS -> " + statusCode)
        println(responseBody)
        expect: "status code 200"
        statusCode == HttpStatus.SC_OK
    }

    def "get all post of the user"() {
        given:"GET https://jsonplaceholder.typicode.com/users/10/posts"
        basePath = "users/10/posts"
        Response response = get()
        responseBody = response.asString()
        statusCode = response.statusCode()
        println("***********************")
        println("GET ALL Posts of the user -> " + statusCode)
        println(responseBody)
        expect: "status code 200"
        statusCode == HttpStatus.SC_OK
    }


    def "get all todo  of the user"() {
        given:"GET https://jsonplaceholder.typicode.com/users/10/todos"
        basePath = "users/10/todos"
        Response response = get()
        responseBody = response.asString()
        statusCode = response.statusCode()
        //Assert.assertEquals(statusCode, 404)
        //Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("GET ALL Todos of the user -> " + statusCode)
        println(responseBody)
        expect:"status code 200"
        statusCode == HttpStatus.SC_OK
    }


    def "get all album of the user"() {
       given:"GET https://jsonplaceholder.typicode.com/users/10/albums"
        basePath = "users/10/albums"
        Response response = get()
        responseBody = response.asString()
        statusCode = response.statusCode()
        println("***********************")
        println("GET ALL Albums of the user -> " + statusCode)
        println(responseBody)
        expect:"status code 200"
        statusCode == HttpStatus.SC_OK
    }


    def "delete the user"() {
        given:"DELETE https://jsonplaceholder.typicode.com/users/10"
        basePath = "users/10"
        Response response = delete()
        statusCode = response.statusCode()
        println("***********************")
        println("Delete the user -> " + statusCode)
        expect:"status code 200"
        statusCode == HttpStatus.SC_OK
    }

    def "delete the post"() {
        given:"DELETE https://jsonplaceholder.typicode.com/posts/88"
        //baseURI = "https://jsonplaceholder.typicode.com/"
        basePath = "posts/88"
        Response response = delete()
        statusCode = response.statusCode()
        println("***********************")
        println("Delete the Post -> " + statusCode)
        expect:"status code 200"
        statusCode == HttpStatus.SC_OK
    }

    def "post new post for the user"() {
        given: "POST https://jsonplaceholder.typicode.com/users/4/posts"
        String payload =   ''' 
                       {
                        "userId": 4,
                        "title": "foo title",
                        "body": "foo body"
                       }
                        '''
        basePath = "users/4/posts"
        Response response = given().contentType (ContentType.JSON).body(payload).post()
        responseBody = response.asString()
        statusCode = response.statusCode()
       // Assert.assertEquals(statusCode,HttpStatus.SC_CREATED)
        println("***********************")
        println("Post New Post For The User -> "+ statusCode)
        println(responseBody)
        expect:"status code 201"
        statusCode == HttpStatus.SC_CREATED
    }

    def "post new Todo for the user"() {
        given:"POST https://jsonplaceholder.typicode.com/users/4/todos"
        String payload =   ''' 
                       {
                        "userId": 4,
                        "title": "foo title",
                        "completed": true
                       }
                        '''
        basePath = "users/4/todos"
        Response response = given().contentType (ContentType.JSON).body(payload).post()
        responseBody = response.asString()
        statusCode = response.statusCode()
        println("***********************")
        println("Post New ToDo For The User -> "+ statusCode)
        println(responseBody)
        expect:"status code 201"
        statusCode == HttpStatus.SC_CREATED
    }


    def "post new album for the user"() {
        given:"POST https://jsonplaceholder.typicode.com/users/4/albums"
        String payload =   ''' 
                       {
                        "userId": 4,
                        "title": "foo title"
                        }
                        '''
        basePath = "users/4/albums"
        Response response = given().contentType (ContentType.JSON).body(payload).post()
        responseBody = response.asString()
        statusCode = response.statusCode()
        println("***********************")
        println("Post New Album For The User -> "+ statusCode)
        println(responseBody)
        expect:"status code 201"
        statusCode == HttpStatus.SC_CREATED
    }


    def"post new post"() {
        given:"POST https://jsonplaceholder.typicode.com/posts"
        String payload =   ''' 
                       {
                        "title": "foo title",
                        "body": "foo body"
                        }
                        '''
        basePath = "/posts"
        Response response = given().contentType (ContentType.JSON).body(payload).post()
        responseBody = response.asString()
        statusCode = response.statusCode()
        println("***********************")
        println("Post New Post -> "+ statusCode)
        println(responseBody)
        expect:"status code 201"
        statusCode == HttpStatus.SC_CREATED
    }


    def"put the post"() {
        given:"PUT https://jsonplaceholder.typicode.com/posts/44"

        String payload =   ''' 
                       {
                        "title": "foo title",
                        "body": "foo body"
                        }
                        '''
        basePath = "/posts/44"
        Response response = given().contentType (ContentType.JSON).body(payload).put()
        responseBody = response.asString()
        statusCode = response.statusCode()
        println("***********************")
        println("Put The Post -> " + statusCode)
        println(responseBody)
        expect:"status code 200"
        statusCode == HttpStatus.SC_OK
    }

    def "patch the post"() {
        given:"PATCH https://jsonplaceholder.typicode.com/posts/44"
        String payload =   ''' 
                       {
                        "title": "foo"
                        }
                        '''
        basePath = "/posts/44"
        Response response = given().contentType (ContentType.JSON).body(payload).patch()
        responseBody = response.asString()
        statusCode = response.statusCode()
        println("***********************")
        println("Put The Post -> "+ statusCode)
        println(responseBody)
        expect:"status code 200"
        statusCode == HttpStatus.SC_OK
    }


}
