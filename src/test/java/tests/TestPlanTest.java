package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static tests.LoginTest.userLogin;
import static tests.LoginTest.userPassword;

public class TestPlanTest extends BaseTest{

    public static final String testPlanTitle = "Test plan for regression testing #1";
    public static final String testPlanDescription = "Description for regression testing Test plan for #1";

    @Test
    public void createTestPlan(){
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(userLogin, userPassword);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
        testPlanPage.projectOpen();
        assertTrue(testPlanPage.createPlaneButtonIsDisplayed(), "Test plans page is not opened");
        testPlanPage.createTestPlanClick();
        testPlanPage.createTestPlan(testPlanTitle, testPlanDescription);
        assertTrue(testPlanPage.createPlaneButtonIsDisplayed(), "Test plans page is not opened");
    }
}
