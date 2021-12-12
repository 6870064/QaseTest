package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static tests.LoginTest.userLogin;
import static tests.LoginTest.userPassword;

public class ProjectTest extends BaseTest {

    public static final String projectName = "Test project 999";
    public static final String projectCode = "999";
    public static final String projectDescription = "Test description of the Test project with the title № 35. " +
            "The best test project written on JAVA.";

    @Test
    public void createNewProject() {

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(userLogin, userPassword);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.createNewProjectButtonClick();
        assertTrue(projectPage.isPageOpened(), "Projects Page is not opened");
        projectPage.createNewProject();

        String errorText = String.format("New project titled %s is not created", projectName);
        assertTrue(projectPage.isProjectCreated(), errorText);
        System.out.println(errorText);

    }
}
