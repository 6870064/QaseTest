package tests;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static pages.LoginPage.userLogin;
import static pages.LoginPage.userPassword;

public class LoginTest extends BaseTest {

    @Test
    public void validUserLogin() {
        loginPage.mainPageOpen();
        assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        loginPage.userLogin(userLogin, userPassword);
        assertTrue(homePage.isPageOpened(), "Home Page is not opened");
    }

    @Test
    public void validUserSignUp () {
    loginPage.mainPageOpen();
    assertTrue(loginPage.isPageOpened(), "Login page is not opened");
    loginPage.signedUpButtonClick();
    assertTrue(signedUpPage.isPageOpened(), "Signed Up page is not opened");
    signedUpPage.userSignedUP();
    assertTrue(homePage.isCongratsPageOpened(),"Congratulations page is not opened");
    }
}