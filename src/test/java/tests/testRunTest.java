package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class testRunTest extends BaseTest {
    public static final String testRunTitle = "Test run 333 description";

    @Test
    public void createTestRun() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testPlanPage.projectOpen();
        assertTrue(testRunPage.createTestRunButtonIsDisplayed(), "Test run page is not opened");
        testRunPage.createTestRun(testRunTitle);
        assertTrue(testRunPage.createTestRunButtonIsDisplayed(), "Test run page is not opened");
    }
}
