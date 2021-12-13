package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class DefectTest extends BaseTest {

    public static final String defectTitle = "Test Bug title №555";
    public static final String actualResult = "Bug №555 is exist - this is an actual result";

    @Test
    public void createNewDefect() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        projectPage.projectOpen();
        defectPage.newDefectCreated(defectTitle, actualResult);
        assertTrue(defectPage.isPageOpened(), "Defects page is not opened");
    }
}