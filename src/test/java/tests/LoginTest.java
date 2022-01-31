package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(description = "Username should be required")
    public void validUserLogin() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
    }

}