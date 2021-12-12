package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static tests.LoginTest.userLogin;
import static tests.LoginTest.userPassword;

public class TestCaseTest extends BaseTest {

    public static final String firstTestCaseTitle = "First test case title";
    public static final String testCaseTitle = "The 1+ test case title";
    public static final String testCaseDescription = "Description of the new test case title";
    public static final String preConditions = "Pre-conditions of the test case";
    public static final String postConditions = "Post-conditions of the test case";
    public static final String stepText = "Steps of the test case";

    @Test
    public void createFirstTestCase() throws InterruptedException {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(userLogin, userPassword);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addFirstCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createFirstTestCaseButtonClick();
        testCasePage.createTestCase(firstTestCaseTitle, testCaseDescription, preConditions, postConditions);
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is opened");
    }

    @Test
    public void createTestCase() throws InterruptedException {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(userLogin, userPassword);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.createTestCase(testCaseTitle, testCaseDescription, preConditions, postConditions);
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test
    public void deleteAllTestCases() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(userLogin, userPassword);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.deleteAllTestCases();
        assertTrue(testCasePage.addFirstCaseButtonIsDisplayed(), "Repository page is not opened");
    }
}
// степы пойдут отдельным методом