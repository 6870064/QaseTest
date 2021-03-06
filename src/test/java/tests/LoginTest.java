package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "Username should be required")
    public void validUserLogin() {

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.enterUserLogin(USER_LOGIN);
        loginPage.enterUserPassword(USER_PASSWORD);
        loginPage.clickCheckBoxInput();
        loginPage.clickLoginButton();
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
    }
}