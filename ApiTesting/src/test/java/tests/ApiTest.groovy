package tests

import org.testng.Assert
import spock.lang.Shared
import spock.lang.Specification
import static io.restassured.RestAssured.*
import org.apache.http.HttpStatus
import io.restassured.http.ContentType
import io.restassured.response.Response



class ApiTest extends Specification{
    String responseBody = ""
    int statusCode = 0

   // @Shared baseURI = "https://jsonplaceholder.typicode.com/"

    def setupSpec() {
        baseURI = "https://jsonplaceholder.typicode.com/"
    }

    def "get  all posts"() {
        given:
        basePath = "/posts"
        Response response = get()
        responseBody = response.asString()
        println(response.getStatusCode())
        statusCode = response.statusCode()
        println("***********************")
        println("GET ALL POSTS")
        println(responseBody)
        expect:
        statusCode == HttpStatus.SC_OK
    }

    def "get all users"() {
        given:
        //baseURI = "https://jsonplaceholder.typicode.com/"
        basePath = "/users"
        Response response = get()
        responseBody = response.asString()
        println(response.getStatusCode())
        statusCode = response.statusCode()
        println("***********************")
        println("GET ALL USERS")
        println(responseBody)
        expect:
        statusCode == HttpStatus.SC_OK
    }


    def "get all todos"() {
        given:
        basePath = "/todos"
        Response response = get()
        responseBody = response.asString()
        println(response.getStatusCode())
        statusCode = response.statusCode()
        println("***********************")
        println("GET ALL TODOS")
        println(responseBody)
        expect:
        statusCode == HttpStatus.SC_OK

    }


    def "get all albums"() {
        given:
        //baseURI = "https://jsonplaceholder.typicode.com/"
        basePath = "/albums"
        Response response = get()
        responseBody = response.asString()
        println(response.getStatusCode())
        statusCode = response.statusCode()
        //Assert.assertEquals(statusCode, 404)
        Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("GET ALL ALBUMS")
        println(responseBody)
        expect:
        statusCode == HttpStatus.SC_OK
    }

    def "get all post of the user"() {
        given:
        //baseURI = "https://jsonplaceholder.typicode.com/"
        basePath = "users/10/posts"
        Response response = get()
        responseBody = response.asString()
        println(response.getStatusCode())
        statusCode = response.statusCode()
        println("***********************")
        println("GET ALL Posts of the user")
        println(responseBody)
        expect:
        statusCode == HttpStatus.SC_OK
    }


    def "get all todo  of the user"() {
        given:
        //baseURI = "https://jsonplaceholder.typicode.com/"
        basePath = "users/10/todos"
        Response response = get()
        responseBody = response.asString()
        println(response.getStatusCode())
        statusCode = response.statusCode()
        //Assert.assertEquals(statusCode, 404)
        //Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("GET ALL Todos of the user")
        println(responseBody)
        expect:
        statusCode == HttpStatus.SC_OK
    }


    def "get all album of the user"() {
       given:
        //baseURI = "https://jsonplaceholder.typicode.com/"
        basePath = "users/10/albums"
        Response response = get()
        responseBody = response.asString()
        println(response.getStatusCode())
        statusCode = response.statusCode()
        println("***********************")
        println("GET ALL Albums of the user")
        println(responseBody)
        expect:
        statusCode == HttpStatus.SC_OK
    }


    def "delete the user"() {
        given:
        //baseURI = "https://jsonplaceholder.typicode.com/"
        basePath = "users/10"
        Response response = delete()
        statusCode = response.statusCode()
        //Assert.assertEquals(statusCode, 404)
        //Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("Delete the user " + statusCode)
        println("***********************")
        expect:
        statusCode == HttpStatus.SC_OK
    }

    def "delete the post"() {
        given:
        //baseURI = "https://jsonplaceholder.typicode.com/"
        basePath = "posts/88"
        Response response = delete()
        statusCode = response.statusCode()
        println("***********************")
        println("Delete the Post " + statusCode)
        println("***********************")
        expect:
        statusCode == HttpStatus.SC_OK
    }

    def "post new post for the user"() {
        given:
        //baseURI = "https://jsonplaceholder.typicode.com/"
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
        println(response.getStatusCode())
        statusCode = response.statusCode()
        Assert.assertEquals(statusCode,HttpStatus.SC_CREATED)
        println("***********************")
        println("Post New Post For The User")
        println(responseBody)
        expect:
        statusCode == HttpStatus.SC_CREATED
    }

    def "post new Todo for the user"() {
        given:
        //baseURI = "https://jsonplaceholder.typicode.com/"
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
        println(response.getStatusCode())
        statusCode = response.statusCode()
        println("***********************")
        println("Post New ToDo For The User")
        println(responseBody)
        expect:
        statusCode == HttpStatus.SC_CREATED
    }


    def "post new album for the user"() {
        given:
        //baseURI = "https://jsonplaceholder.typicode.com/"

        String payload =   ''' 
                       {
                        "userId": 4,
                        "title": "foo title"
                        }
                        '''
        basePath = "users/4/albums"
        Response response = given().contentType (ContentType.JSON).body(payload).post()
        responseBody = response.asString()
        println(response.getStatusCode())
        statusCode = response.statusCode()
        println("***********************")
        println("Post New Album For The User")
        println(responseBody)
        expect:
        statusCode == HttpStatus.SC_CREATED
    }


    def"post new post"() {
        given:
        //baseURI = "https://jsonplaceholder.typicode.com/"

        String payload =   ''' 
                       {
                        "title": "foo title",
                        "body": "foo body"
                        }
                        '''
        basePath = "/posts"
        Response response = given().contentType (ContentType.JSON).body(payload).post()
        responseBody = response.asString()
        println(response.getStatusCode())
        statusCode = response.statusCode()
        println("***********************")
        println("Post New Post")
        println(responseBody)
        expect:
        statusCode == HttpStatus.SC_CREATED
    }


    def"put the post"() {
        given:
        //baseURI = "https://jsonplaceholder.typicode.com/"

        String payload =   ''' 
                       {
                        "title": "foo title",
                        "body": "foo body"
                        }
                        '''
        basePath = "/posts/44"
        Response response = given().contentType (ContentType.JSON).body(payload).put()
        responseBody = response.asString()
        println(response.getStatusCode())
        statusCode = response.statusCode()
        println("***********************")
        println("Put The Post")
        println(responseBody)
        expect:
        statusCode == HttpStatus.SC_OK
    }

    def "patch the post"() {
        given:
        //baseURI = "https://jsonplaceholder.typicode.com/"

        String payload =   ''' 
                       {
                        "title": "foo"
                        }
                        '''
        basePath = "/posts/44"
        Response response = given().contentType (ContentType.JSON).body(payload).patch()
        responseBody = response.asString()
        println(response.getStatusCode())
        statusCode = response.statusCode()
        //Assert.assertEquals(statusCode,HttpStatus.SC_OK)
        println("***********************")
        println("Put The Post")
        println(responseBody)
        expect:
        statusCode == HttpStatus.SC_OK
    }


}
