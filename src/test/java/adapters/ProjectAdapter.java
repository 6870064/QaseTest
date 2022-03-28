package adapters;

import tests.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProjectAdapter extends BaseAdapter {

    public String post(String body, int status) {
        return post(body, status, "https://api.qase.io/v1/project");
    }
}
