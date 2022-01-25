package tests;

import org.testng.annotations.Test;
import tests.base.Retry;

import static org.testng.Assert.assertTrue;


public class TestPlanTest extends BaseTest {

    String testPlanTitle = "Test plan for regression testing #1";
    String testPlanDescription = "Description for regression testing Test plan for #1";

    @Test (description = "Creation test plan")
    public void createTestPlan() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testPlanPage.projectOpen();
        assertTrue(testPlanPage.createPlaneButtonIsDisplayed(), "Test plans page is not opened");
        testPlanPage.createTestPlanClick();
        testPlanPage.createTestPlan(testPlanTitle, testPlanDescription);
        assertTrue(testPlanPage.createPlaneButtonIsDisplayed(), "Test plans page is not opened");
    }
}
