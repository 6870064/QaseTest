package tests;

import com.github.javafaker.Faker;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Log4j2
public class ProjectTest extends BaseTest {

    Faker faker = new Faker();

    String publicProjectName = faker.date().toString() + " project" + " " + faker.date().toString();
    String privateProjectName = faker.date().toString() + " project" + " " + faker.date().toString();
    String publicProjectDescription = faker.name().firstName();
    String privateProjectDescription = faker.name().firstName() + " " + faker.name().lastName();

    @Test(description = "Creation of the new public project")
    public void createNewPublicProject() {

        log.warn("warn");
        log.error("error");

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.createNewProjectButtonClick();
        assertTrue(projectPage.isPageOpened(), "Projects Page is not opened");
        projectPage.enterProjectName(publicProjectName);
        projectPage.enterProjectDescriptionField(publicProjectDescription);
        projectPage.projectPublicAccessRadioButtonClick();
        projectPage.createProjectButton();
        String errorText = String.format("New project titled %s is not created", publicProjectName);
        assertTrue(projectPage.isProjectCreated(), errorText);
    }

    @Test(description = "Creation of the new private project")
    public void createNewPrivateProject() {

        log.warn("warn");
        log.error("error");

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.createNewProjectButtonClick();
        assertTrue(projectPage.isPageOpened(), "Projects Page is not opened");
        projectPage.enterProjectName(privateProjectName);
        projectPage.enterProjectDescriptionField(privateProjectDescription);
        projectPage.createProjectButton();
        String errorText = String.format("New project titled %s is not created", privateProjectName);
        assertTrue(projectPage.isProjectCreated(), errorText);
    }
}
