package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class DefectTest extends BaseTest {

    String defectTitle = "Test Bug title 12/17";
    String actualResult = "Bug №555 is exist - this is an actual result";
    String milestoneValueToClick = "Release 3.0";
    String assigneeValueToClick = "Dmitry Vyacheslavov";
    String filePath = "src/test/resources/152360.jpeg";
    String fileName = "152360.jpeg";

    @Test
    public void createNewDefectWithoutAttachment() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.projectOpen();
        defectPage.newDefectCreated(defectTitle, actualResult, milestoneValueToClick, assigneeValueToClick);
        defectPage.createDefectButtonClick();
        assertTrue(defectPage.isPageOpened(), "Defects page is not opened");
    }

    @Test
    public void createNewDefectWithAttachment() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.projectOpen();
        defectPage.newDefectCreated(defectTitle, actualResult, milestoneValueToClick, assigneeValueToClick);
        defectPage.fileUpload(filePath, fileName);
        defectPage.createDefectButtonClick();
        assertTrue(defectPage.isPageOpened(), "Defects page is not opened");
    }
}