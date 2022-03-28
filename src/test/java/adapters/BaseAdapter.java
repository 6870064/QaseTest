package adapters;

import static io.restassured.RestAssured.given;

public class BaseAdapter {

    public String post(String body, int status, String url) {
        return
                given().
                        header("Token", "427c4e87166cb838a6498704ba965e71c8a6cdd1").
                        header("Content-Type", "application/json").
                        header("Accept", "application/json").
                        body(body).
                when().
                        post(url).
                then().
                        log().all().
                        statusCode(status).
                        extract().body().asString();
    }
}
