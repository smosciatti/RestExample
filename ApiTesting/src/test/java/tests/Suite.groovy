package tests

import io.restassured.RestAssured
import io.restassured.response.Response
import org.apache.http.HttpStatus
import org.testng.Assert
import org.testng.annotations.BeforeClass
import org.testng.annotations.Parameters
import org.testng.annotations.Test

class Suite {
    String responseBody = ""

    @Parameters(["suiteBaseURI"] )
    @BeforeClass
    void setup(String suiteBaseURI) {
        // Setting BaseURI once
        RestAssured.baseURI =  suiteBaseURI

    }
    @Parameters(["basepath"] )
    @Test
    void PerformCall( String basepath){
        // Setting BasePath
        RestAssured.basePath = basepath
        Response response = RestAssured.get()
        responseBody = response.asString()
        println(response.getStatusCode())
        int statusCode = response.statusCode()
        //Assert.assertEquals(statusCode, 404)
        Assert.assertEquals(statusCode, HttpStatus.SC_OK)
        println("***********************")
        println("GET ALL " + basepath)
        println(responseBody)
    }
}
