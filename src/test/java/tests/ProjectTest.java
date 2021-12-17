package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class ProjectTest extends BaseTest {

    String projectName = "Test project bla bla bla 999";
    String projectDescription = "Test description of the Test project with the title № 35. The best test project written on JAVA.";

    @Test
    public void createNewProject() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.createNewProjectButtonClick();
        assertTrue(projectPage.isPageOpened(), "Projects Page is not opened");
        projectPage.createNewProject(projectName, projectDescription);
        String errorText = String.format("New project titled %s is not created", projectName);
        assertTrue(projectPage.isProjectCreated(), errorText);
        System.out.println(errorText);
    }
}
