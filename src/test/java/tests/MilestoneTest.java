package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class MilestoneTest extends BaseTest {

    public static final String milestoneName = "Release 3.0";
    public static final String milestoneDescription = "Description of the Release 3.0";

    @Test
    public void createNewMilestone() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        milestonePage.projectOpen();
        milestonePage.newMilestoneCreated(milestoneName, milestoneDescription);
        milestonePage.isPageOpened();
    }
}