package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static tests.LoginTest.userLogin;
import static tests.LoginTest.userPassword;

public class MilestoneTest extends BaseTest {

    public static final String milestoneName = "Release 3.0";
    public static final String milestoneDescription = "Description of the Release 3.0";

    @Test
    public void createNewMilestone() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(userLogin, userPassword);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        milestonePage.projectOpen();
        milestonePage.newMilestoneCreated(milestoneName, milestoneDescription);
        milestonePage.isPageOpened();
    }
}