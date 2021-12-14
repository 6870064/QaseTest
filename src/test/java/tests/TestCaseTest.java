package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class TestCaseTest extends BaseTest {

    public static final String firstTestCaseTitle = "Test case title 12/14";
    public static final String testCaseTitle = "The test case with picture";
    public static final String testCaseDescription = "Description of the new test case title";
    public static final String preConditions = "Pre-conditions of the test case";
    public static final String postConditions = "Post-conditions of the test case";
    public static final String stepText = "Steps of the test case";

    @Test
    public void createFirstTestCase() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addFirstCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createFirstTestCaseButtonClick();
        testCasePage.createTestCase(firstTestCaseTitle, testCaseDescription, preConditions, postConditions);
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is opened");
    }

    @Test
    public void createTestCase() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
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
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.deleteAllTestCases();
        assertTrue(testCasePage.addFirstCaseButtonIsDisplayed(), "Repository page is not opened");
    }
}
// степы пойдут отдельным методом