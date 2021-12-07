package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    public static final String userLogin = "6870064@gmail.com";
    public static final String userPassword = "qwe1122qwe";

    @Test
    public void validUserLogin() {
        loginPage.pageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.login(userLogin, userPassword);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
    }

}