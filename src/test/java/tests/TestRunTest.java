package tests;

import org.testng.annotations.Test;
import tests.base.Retry;

import static org.testng.Assert.assertTrue;


public class TestRunTest extends BaseTest {
    String testRunTitle = "Test run 333 description";
    String planValue = "Test plan for regression testing #1";
    String milestoneValue = "Release 3.0";
    String assigneeValueToClick = "Dmitry Vyacheslavov";

    @Test (description = "Creation of the test run")
    public void createTestRun() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testPlanPage.projectOpen();
        assertTrue(testRunPage.createTestRunButtonIsDisplayed(), "Test run page is not opened");
        testRunPage.createTestRun(testRunTitle, planValue, milestoneValue, assigneeValueToClick);
        assertTrue(testRunPage.createTestRunButtonIsDisplayed(), "Test run page is not opened");
    }
}
