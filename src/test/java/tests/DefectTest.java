package tests;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DefectTest extends BaseTest {

    String defectTitle = "Test Bug title Feb 04 2022 №170";
    String actualResult = "Bug №161 is exist - this is an actual result";
    String assigneeValueToClick = "Dmitry Vyacheslavov";
    String severityToCheck = "Critical";
    String filePath = "src/test/resources/152360.jpeg";
    String fileName = "152360.jpeg";
    String caseParamReporter = "Reporter";
    String caseParamAssignee = "Assignee";

    @Issue("170")
    @TmsLink("96")
    @Test(description = "Creation of new defect without attaching the file and milestone")
    public void createNewDefectWithoutAttachment() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.projectOpen();
        defectPage.clickDefectsButton();
        defectPage.createNewDefectButton();
        defectPage.enterDefectTitle(defectTitle);
        defectPage.enterActualResult(actualResult);
        defectPage.selectSeverity(severityToCheck);
        defectPage.selectAssigneeValue(assigneeValueToClick);
        defectPage.createDefectButtonClick();
        assertTrue(defectPage.isPageOpened(), "Defects page is not opened");
    }

    @Test(description = "Creation of new defect without attaching the file, milestone and Assignee")
    public void createNewDefectWithoutAssigneeAndAttachment() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.projectOpen();
        defectPage.clickDefectsButton();
        defectPage.createNewDefectButton();
        defectPage.enterDefectTitle(defectTitle);
        defectPage.enterActualResult(actualResult);
        defectPage.selectSeverity(severityToCheck);
        defectPage.createDefectButtonClick();
        assertTrue(defectPage.isPageOpened(), "Defects page is not opened");
    }

    @Test(description = "Creation of new defect with attaching the file and without milestone")
    public void createNewDefectWithAttachment() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.projectOpen();
        defectPage.clickDefectsButton();
        defectPage.createNewDefectButton();
        defectPage.enterDefectTitle(defectTitle);
        defectPage.enterActualResult(actualResult);
        defectPage.selectSeverity(severityToCheck);
        defectPage.selectAssigneeValue(assigneeValueToClick);
        defectPage.fileUpload(filePath);
        defectPage.checkTitleOfFileUploaded(fileName);
        defectPage.createDefectButtonClick();
        assertTrue(defectPage.isPageOpened(), "Defects page is not opened");
        defectPage.createdDefectOpen(defectTitle);

        assertEquals(defectPage.titleValueCheck(), defectTitle, "Title of the new bug created is not equal");
        assertEquals(defectPage.descriptionValueCheck(), actualResult, "Description of the new bug created is not equal");
        assertEquals(defectPage.caseSeverityValueCheck(), severityToCheck, "Severity of the new bug created is not equal");
        assertEquals(defectPage.caseParameterValueCheck(caseParamReporter), assigneeValueToClick, "The reporter of the new bug created is not equal");
        assertEquals(defectPage.caseParameterValueCheck(caseParamAssignee), assigneeValueToClick, "The assignee is not equal");
    }
}