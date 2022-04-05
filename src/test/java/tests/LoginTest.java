package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

@Log4j2
public class LoginTest extends BaseTest {

    @Test(description = "Username should be required")
    public void validUserLogin() {

        log.warn("warn");
        log.error("error");

        log.warn(String.format("Valid user login with username '%s' and login '%s'", USER_LOGIN, USER_PASSWORD));
        log.error(String.format("Error in Valid user login with username '%s' and login '%s'", USER_LOGIN, USER_PASSWORD));

        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(USER_LOGIN, USER_PASSWORD);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
    }

}