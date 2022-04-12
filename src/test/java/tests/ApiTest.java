package tests;

import adapters.ProjectAdapter;
import models.Project;
import models.ResponseProject;
import models.ResponseStatus;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class ApiTest {

//    @Test
//    public void projectTest(){
//        String response = new ProjectAdapter().post("{}",400);
//        assertEquals(response,"{\n" +
//                "    \"status\": false,\n" +
//                "    \"errorMessage\": \"Data is invalid.\",\n" +
//                "    \"errorFields\": [\n" +
//                "        {\n" +
//                "            \"field\": \"title\",\n" +
//                "            \"error\": \"Title is required.\"\n" +
//                "        },\n" +
//                "        {\n" +
//                "            \"field\": \"code\",\n" +
//                "            \"error\": \"Project code is required.\"\n" +
//                "        }\n" +
//                "    ]\n" +
//                "}");
//    }

    @Test
    public void projectTest2() {
        Project project = Project.builder()
                .title("TEST23")
                .code("QWEAYUIY")
                .build();

        ResponseStatus actual = new ProjectAdapter().create(project, 200);
        assertEquals(actual.isStatus(), true);
        assertEquals(actual.getResult().getCode(), project.getCode());
    }

    @Test
    public void get() {
      ResponseProject project = new ProjectAdapter().getProject("TEST3");
      System.out.println(project);
    }
}