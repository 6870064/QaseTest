package tests;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import static tests.LoginTest.userLogin;
import static tests.LoginTest.userPassword;

public class DefectTest extends BaseTest {

    public static final String defectTitle = "Test Bug title №555";
    public static final String actualResult = "Bug №555 is exist - this is an actual result";

    @Test
    public void createNewDefect() {
    loginPage.pageOpen();
    assertTrue(loginPage.isPageOpened(), "Login page is not opened");
    loginPage.login(userLogin, userPassword);
    assertTrue(homePage.isPageOpened(), "Home Page is not opened");
    projectPage.projectOpen();
    defectPage.newDefectCreated(defectTitle,actualResult);
    assertTrue(defectPage.isPageOpened(),"Defects page is not opened");
    }
}