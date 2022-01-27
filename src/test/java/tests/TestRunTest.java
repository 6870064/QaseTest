package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static tests.MilestoneTest.milestoneDescription;


public class TestRunTest extends BaseTest {

    String testCaseTitleWithoutConditions = "The test case without picture and Conditions Jan 25 2022";
    String testCaseDescription = "Description of the new test case title";
    String testCaseStatus = "Draft";
    String testCaseSeverity = "Critical";
    String testCasePriority = "High";
    String testCaseLayer = "E2E";
    String testCaseType = "Functional";
    String testCaseIsFlaky = "Yes";
    String testCaseBehavior = "Positive";
    String testCaseAutoStatus = "To be automated";
    String testRunTitle = "Test run 555 title";
    String testRunDescription = "Test run 555 Description";
    String testPlanTitleForRun = "Test plan 555 for regression testing #1";
    String testPlanDescriptionForRun = "Test plan 555 Description";
    String milestoneForTestRunName = "Release 55.0";
    String assigneeValueToClick = "Dmitry Vyacheslavov";

    @Test(description = "Creation of the test run")
    public void createTestRun() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testPlanPage.projectOpen();

        // создание testcase для test run
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

        // создание milestone для test run
        milestonePage.MilestoneSubmenuClick();
        milestonePage.CreateMilestoneButtonClick();
        milestonePage.EnterMilestoneName(milestoneForTestRunName);
        milestonePage.EnterMilestoneDescription(milestoneDescription);
        milestonePage.CreateNewMilestoneButtonClick();
        milestonePage.isPageOpened();

        //создание test plan для test run
        testPlanPage.testPlansButtonClick();
        assertTrue(testPlanPage.createPlanButtonIsDisplayed(), "Test plans page is not opened");
        testPlanPage.createPlanButtonClick();
        testPlanPage.enterTestPlanTitle(testPlanTitleForRun);
        testPlanPage.enterTestPlanDescription(testPlanDescriptionForRun);
        testPlanPage.addCasesButtonClick();
        testPlanPage.checkboxSelect();
        testPlanPage.addCasesDoneButton();
        testPlanPage.savePlanButtonClick();
        assertTrue(testPlanPage.createPlanButtonIsDisplayed(), "Test plans page is not opened");

        //создание test run
        testRunPage.testRunsSubmenuClick();
        assertTrue(testRunPage.startNewTestRunButtonIsDisplayed(), "Test run page is not opened");
        testRunPage.setStartNewTestRunButtonClick();
        testRunPage.enterRunTitle(testRunTitle);
        testRunPage.enterTestRunDescription(testRunDescription);
        testRunPage.assigneeSelect(assigneeValueToClick);
        testRunPage.setAddCasesButtonClick();
        testRunPage.checkboxClick();
        testRunPage.doneButtonClick();
        testRunPage.startRunButtonClick();
        assertTrue(testRunPage.startNewTestRunButtonIsDisplayed(), "Test run page is not opened");
    }
}
