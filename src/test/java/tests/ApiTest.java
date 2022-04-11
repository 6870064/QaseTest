package tests;

import adapters.ProjectAdapter;
import models.Project;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class ApiTest {

    @Test
    public void projectTest(){
        String response = new ProjectAdapter().post("{}",400);
        assertEquals(response,"{\n" +
                "    \"status\": false,\n" +
                "    \"errorMessage\": \"Data is invalid.\",\n" +
                "    \"errorFields\": [\n" +
                "        {\n" +
                "            \"field\": \"title\",\n" +
                "            \"error\": \"Title is required.\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"field\": \"code\",\n" +
                "            \"error\": \"Project code is required.\"\n" +
                "        }\n" +
                "    ]\n" +
                "}");
    }

    @Test
    public void projectTest2(){
        Project project = new Project();
        String response = new ProjectAdapter().post("{\"title\": \"TEeST56\", \"code\": \"TSRRFS\"}", 200);
        assertEquals(response, "{\n" +
                "    \"status\": true,\n" +
                "    \"result\": {\n" +
                "        \"code\": \"TSRRFS\"\n" +
                "    }\n" +
                "}");
    }
}