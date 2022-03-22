package tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiTest {

    String statusCode = "rerrerqw";

    @Test
    public void projectTest(){

    }

    @Test
    public void projectTest2(){
        given().
                header("Token", "427c4e87166cb838a6498704ba965e71c8a6cdd1").
                header("Content-Type","application/json").
                header("Accept", "application/json").
                body("{\"title\": \"TEeST6\", \"code\": \"TREREDFR\", \"description\": \"Test description\", \"access\": \"all\"}").
                when().
                post("https://api.qase.io/v1/project").
                then().
                log().all().
                statusCode(200).
                body("status", equalTo(true),
                        "result.code", equalTo("TREREDFR"));
    }
}