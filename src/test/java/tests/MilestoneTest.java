package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class MilestoneTest extends BaseTest {

    public static final String milestoneName = "Release 5.0";
    public static final String milestoneDescription = "Description of the Release 3.0";

    @Test(description = "Creation of new milestone")
    public void createNewMilestone() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        milestonePage.projectOpen();
        milestonePage.clickMilestoneSubmenu();
        milestonePage.clickCreateMilestoneButton();
        milestonePage.enterMilestoneName(milestoneName);
        milestonePage.enterMilestoneDescription(milestoneDescription);
        milestonePage.createNewMilestoneButtonClick();
        milestonePage.isPageOpened();
    }
}