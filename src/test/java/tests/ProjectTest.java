package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class ProjectTest extends BaseTest {

    String publicProjectName = "New Test public project №999";
    String privateProjectName = "New 1 Private Test project №111";
    String publicProjectDescription = "Test description of the Test public project with the title №999";
    String privateProjectDescription = "Test description of the Test private project with the title №111";

    @Test (description = "Creation of the new public project")
    public void createNewPublicProject() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.createNewProjectButtonClick();
        assertTrue(projectPage.isPageOpened(), "Projects Page is not opened");
        projectPage.EnterProjectName(publicProjectName);
        projectPage.EnterProjectDescriptionField(publicProjectDescription);
        projectPage.ProjectPublicAccessRadioButtonClick();
        projectPage.CreateProjectButton();
        String errorText = String.format("New project titled %s is not created", publicProjectName);
        assertTrue(projectPage.isProjectCreated(), errorText);
        System.out.println(errorText);
    }

    @Test (description = "Creation of the new private project")
    public void createNewPrivateProject(){
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.createNewProjectButtonClick();
        assertTrue(projectPage.isPageOpened(), "Projects Page is not opened");
        projectPage.EnterProjectName(privateProjectName);
        projectPage.EnterProjectDescriptionField(privateProjectDescription);
        projectPage.CreateProjectButton();
        String errorText = String.format("New project titled %s is not created", privateProjectName);
        assertTrue(projectPage.isProjectCreated(), errorText);
        System.out.println(errorText);
    }
}
