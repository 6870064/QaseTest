package adapters;

import models.Project;
import tests.BaseTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ProjectAdapter extends BaseAdapter {

    public String create(Project project, int status) {
        return post(gson.toJson(project), status, "https://api.qase.io/v1/project");
    }
}
