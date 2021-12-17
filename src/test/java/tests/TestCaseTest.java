package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class TestCaseTest extends BaseTest {

    String firstTestCaseTitle = "Test case title 12/14";
    String testCaseTitle = "The test case with picture";
    String testCaseDescription = "Description of the new test case title";
    String miletonevalue = "Release 3.0";
    String preConditions = "Pre-conditions of the test case";
    String postConditions = "Post-conditions of the test case";
    String suiteValue = "Test cases without suite";
    String stepAction = "Action of the step №";
    String stepInputData = "Step of the test case №";
    String stepExpectedResult = "Expected result of the test case №";
    int amountOfSteps = 10;
    String filePath = "src/test/resources/152360.jpeg";
    String fileName = "152360.jpeg";

    @Test
    public void createFirstTestCaseWithFile() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addFirstCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createFirstTestCaseButtonClick();
        testCasePage.createTestCase(testCaseTitle, testCaseDescription, suiteValue, miletonevalue, preConditions, postConditions);
        defectPage.fileUpload(filePath, fileName);
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is opened");
    }

    @Test
    public void createTestCaseWithoutSteps() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.createTestCase(testCaseTitle, testCaseDescription, suiteValue, miletonevalue, preConditions, postConditions);
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test
    public void createTestCaseWithOneStep() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.createTestCase(testCaseTitle, testCaseDescription, suiteValue, miletonevalue, preConditions, postConditions);
        testCasePage.addStep(0,stepAction, stepInputData, stepExpectedResult);
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test
    public void createTestCaseWithFileAndOneStep() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.createTestCase(testCaseTitle, testCaseDescription, suiteValue, miletonevalue, preConditions, postConditions);
        defectPage.fileUpload(filePath, fileName);
        testCasePage.addStep(0,stepAction, stepInputData, stepExpectedResult);
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test
    public void createTestCaseWithFileAndTenSteps() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.createTestCase(testCaseTitle, testCaseDescription, suiteValue, miletonevalue, preConditions, postConditions);
        defectPage.fileUpload(filePath, fileName);

        for ( int b =0;b<amountOfSteps;b++){ //Добавление 10 шагов в тест-кейс
        testCasePage.addStep(b, stepAction, stepInputData, stepExpectedResult);
        }

        testCasePage.saveButtonClick();
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