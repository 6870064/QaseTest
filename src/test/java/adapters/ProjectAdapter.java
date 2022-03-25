package adapters;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProjectAdapter {

    public String post(String body, int status){
        return
        given().
                header("Token", "427c4e87166cb838a6498704ba965e71c8a6cdd1").
                header("Content-Type","application/json").
                header("Accept", "application/json").
                body(body).
        when().
                get("https://api.qase.io/v1/project").
        then().
                log().all().
                statusCode(status).
                extract().body().asString();
    }
}
