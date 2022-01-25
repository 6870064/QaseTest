package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class TestCaseTest extends BaseTest {

    String testCaseTitleWithoutConditions = "The test case without picture and Conditions Jan 25 2022";
    String testCaseTitleWithConditions = "The test case without picture with Conditions Jan 25 2022";
    String testCaseDescription = "Description of the new test case title";
    String testCaseStatus = "Draft";
    String testCaseSeverity = "Blocker";
    String testCasePriority = "High";
    String testCaseLayer = "E2E";
    String testCaseType = "Functional";
    String testCaseIsFlaky = "Yes";
    String testCaseBehavior = "Positive";
    String testCaseAutoStatus = "To be automated";
    String preConditions = "Pre-conditions of the test case";
    String postConditions = "Post-conditions of the test case";
    String stepAction = "Action of the step №";
    String stepInputData = "Step of the test case №";
    String stepExpectedResult = "Expected result of the test case №";
    int amountOfSteps = 10;
    String filePath = "src/test/resources/152360.jpeg";
    String fileName = "152360.jpeg";
    String confirmText = "CONFIRM";

    @Test (description = "Creation of the test case without adding conditions and the steps")
    public void createTestCaseWithoutConditionsAndSteps() { //Pass
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.enterTestCaseTitle(testCaseTitleWithoutConditions);
        testCasePage.enterDescription(testCaseDescription);
        testCasePage.selectStatus(testCaseStatus);
        testCasePage.selectSeverity(testCaseSeverity);
        testCasePage.selectPriority(testCasePriority);
        testCasePage.selectType(testCaseType);
        testCasePage.selectLayer(testCaseLayer);
        testCasePage.selectIsFlaky(testCaseIsFlaky);
        testCasePage.selectBehavior(testCaseBehavior);
        testCasePage.selectAutomationStatus(testCaseAutoStatus);
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test (description = "Creation of the test case with adding Pre-Conditions and 1 step")
    public void createTestCaseWithOneStep() { //Fails
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.enterTestCaseTitle(testCaseTitleWithConditions);
        testCasePage.enterDescription(testCaseDescription);
        testCasePage.selectStatus(testCaseStatus);
        testCasePage.selectSeverity(testCaseSeverity);
        testCasePage.selectPriority(testCasePriority);
        testCasePage.selectType(testCaseType);
        testCasePage.selectLayer(testCaseLayer);
        testCasePage.selectIsFlaky(testCaseIsFlaky);
        testCasePage.selectBehavior(testCaseBehavior);
        testCasePage.selectAutomationStatus(testCaseAutoStatus);
        testCasePage.enterPreConditions(preConditions);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        testCasePage.addStep(0, stepAction, stepInputData, stepExpectedResult);
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test (description = "Creation of the test case with adding Pre-Conditions, Post-Conditions and 1 step")
    public void createTestCaseWithConditionsOneStep() {  //Pass
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.enterTestCaseTitle(testCaseTitleWithConditions);
        testCasePage.enterDescription(testCaseDescription);
        testCasePage.selectStatus(testCaseStatus);
        testCasePage.selectSeverity(testCaseSeverity);
        testCasePage.selectPriority(testCasePriority);
        testCasePage.selectType(testCaseType);
        testCasePage.selectLayer(testCaseLayer);
        testCasePage.selectIsFlaky(testCaseIsFlaky);
        testCasePage.selectBehavior(testCaseBehavior);
        testCasePage.selectAutomationStatus(testCaseAutoStatus);
        testCasePage.enterPreConditions(preConditions);
        testCasePage.enterPostConditions(postConditions);
        testCasePage.addStep(0, stepAction, stepInputData, stepExpectedResult);
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test (description = "Creation of the test case with adding Pre-Conditions, Post-Conditions and 10 steps without attachment")
    public void createTestCaseWithTenSteps() { //Fails
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.enterTestCaseTitle(testCaseTitleWithConditions);
        testCasePage.enterDescription(testCaseDescription);
        testCasePage.selectStatus(testCaseStatus);
        testCasePage.selectSeverity(testCaseSeverity);
        testCasePage.selectPriority(testCasePriority);
        testCasePage.selectType(testCaseType);
        testCasePage.selectLayer(testCaseLayer);
        testCasePage.selectIsFlaky(testCaseIsFlaky);
        testCasePage.selectBehavior(testCaseBehavior);
        testCasePage.selectAutomationStatus(testCaseAutoStatus);
        testCasePage.enterPreConditions(preConditions);
        testCasePage.enterPostConditions(postConditions);

        for (int b = 0; b < amountOfSteps; b++) { //Добавление 10 шагов в тест-кейс
            testCasePage.addStep(b, stepAction, stepInputData, stepExpectedResult);
        }
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test (description = "Creation of the test case with adding 1 step and attachment")
    public void createTestCaseWithFileAndOneStep() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.enterTestCaseTitle(testCaseTitleWithoutConditions);
        testCasePage.enterDescription(testCaseDescription);
        testCasePage.selectStatus(testCaseStatus);
        testCasePage.selectSeverity(testCaseSeverity);
        testCasePage.selectPriority(testCasePriority);
        testCasePage.selectType(testCaseType);
        testCasePage.selectLayer(testCaseLayer);
        testCasePage.selectIsFlaky(testCaseIsFlaky);
        testCasePage.selectBehavior(testCaseBehavior);
        testCasePage.selectAutomationStatus(testCaseAutoStatus);
        defectPage.fileUpload(filePath, fileName);
        testCasePage.addStep(0, stepAction, stepInputData, stepExpectedResult);
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test (description = "Creation of the test case with adding 10 step and attachment")
    public void createTestCaseWithFileAndTenSteps() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.createTestCaseButtonClick();
        testCasePage.enterTestCaseTitle(testCaseTitleWithoutConditions);
        testCasePage.enterDescription(testCaseDescription);
        testCasePage.selectStatus(testCaseStatus);
        testCasePage.selectSeverity(testCaseSeverity);
        testCasePage.selectPriority(testCasePriority);
        testCasePage.selectType(testCaseType);
        testCasePage.selectLayer(testCaseLayer);
        testCasePage.selectIsFlaky(testCaseIsFlaky);
        testCasePage.selectBehavior(testCaseBehavior);
        testCasePage.selectAutomationStatus(testCaseAutoStatus);
        defectPage.fileUpload(filePath, fileName);
        for (int b = 0; b < amountOfSteps; b++) { //Добавление 10 шагов в тест-кейс
            testCasePage.addStep(b, stepAction, stepInputData, stepExpectedResult);
        }
        testCasePage.saveButtonClick();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
    }

    @Test (description = "Delete all cases on the project")
    public void deleteAllTestCases() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testCasePage.projectOpen();
        assertTrue(testCasePage.addCaseButtonIsDisplayed(), "Repository page is not opened");
        testCasePage.deleteAllTestCases(confirmText);
        assertTrue(testCasePage.addFirstCaseButtonIsDisplayed(), "Repository page is not opened");
    }
}