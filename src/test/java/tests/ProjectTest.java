package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static pages.LoginPage.userLogin;
import static pages.LoginPage.userPassword;
import static pages.ProjectPage.projectName;

public class ProjectTest extends BaseTest {

    @Test
    public void createNewProject() {
    loginPage.mainPageOpen();
    assertTrue(loginPage.isPageOpened(), "Login page is not opened");
    loginPage.userLogin(userLogin, userPassword);
    assertTrue(homePage.isPageOpened(), "Home Page is not opened");
    projectPage.createNewProjectButtonClick();
    assertTrue(projectPage.isPageOpened(), "Projects Page is not opened");
    projectPage.createNewProject();
    assertTrue(projectPage.isProjectCreated(),"New project titled "+projectName+" is not created");
    }
}
