package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static pages.BasePage.UPLOADED_FILE;


public class DefectTest extends BaseTest {

    String defectTitle = "Test Bug title Jan 25 2022";
    String actualResult = "Bug №555 is exist - this is an actual result";
    String milestoneValueToClick = "Release 3.0";
    String assigneeValueToClick = "Dmitry Vyacheslavov";
    String severityToCheck = "Critical";
    String filePath = "src/test/resources/152360.jpeg";
    String fileName = "152360.jpeg";

    @Test (description = "Creation of new defect without attaching the file and milestone")
    public void createNewDefectWithoutAttachment() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.projectOpen();
        defectPage.defectsButtonClick();
        defectPage.createNewDefectButton();
        defectPage.enterDefectTitle(defectTitle);
        defectPage.enterActualResult(actualResult);
        defectPage.severitySelect(severityToCheck);
        defectPage.assigneeValueSelect(assigneeValueToClick);
        defectPage.createDefectButtonClick();
        assertTrue(defectPage.isPageOpened(), "Defects page is not opened");
    }

    @Test (description = "Creation of new defect without attaching the file, milestone and Assignee")
    public void createNewDefectWithoutAssigneeAndAttachment() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.projectOpen();
        defectPage.defectsButtonClick();
        defectPage.createNewDefectButton();
        defectPage.enterDefectTitle(defectTitle);
        defectPage.enterActualResult(actualResult);
        defectPage.severitySelect(severityToCheck);
        defectPage.createDefectButtonClick();
        assertTrue(defectPage.isPageOpened(), "Defects page is not opened");
    }

    @Test (description = "Creation of new defect with attaching the file and without milestone")
    public void createNewDefectWithAttachment() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.projectOpen();
        defectPage.defectsButtonClick();
        defectPage.createNewDefectButton();
        defectPage.enterDefectTitle(defectTitle);
        defectPage.enterActualResult(actualResult);
        defectPage.severitySelect(severityToCheck);
        defectPage.assigneeValueSelect(assigneeValueToClick);
        defectPage.fileUpload(filePath, fileName);
        defectPage.createDefectButtonClick();
        assertTrue(defectPage.isPageOpened(), "Defects page is not opened");
    }
}