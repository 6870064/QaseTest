package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static tests.LoginTest.userLogin;
import static tests.LoginTest.userPassword;

public class testRunTest extends BaseTest {
    public static final String testRunTitle = "Test run 333 description";

    @Test
    public void createTestRun() throws InterruptedException {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(userLogin, userPassword);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testPlanPage.projectOpen();
        assertTrue(testRunPage.createTestRunButtonIsDisplayed(), "Test run page is not opened");
        testRunPage.createTestRun(testRunTitle);
        assertTrue(testRunPage.createTestRunButtonIsDisplayed(), "Test run page is not opened");
    }
}
