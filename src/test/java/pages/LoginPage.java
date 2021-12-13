package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public static final By LOGIN_INPUT = By.id("inputEmail");
    public static final By PASSWORD_INPUT = By.id("inputPassword");
    public static final By CHECKBOX_INPUT = By.className("custom-control-indicator");
    public static final By SIGN_UP_BUTTON = By.linkText("Sign up");
    public static final By LOGIN_BUTTON = By.id("btnLogin");
    public static final String userLogin = "6870064@gmail.com";
    public static final String userPassword = "qwe1122qwe";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void mainPageOpen() {
        driver.get(BASE_URL);
    }

    @Override
    public boolean isPageOpened() {
        return isElementExist(LOGIN_BUTTON);
    }

    @Override
    public boolean isCongratsPageOpened() {
        return false;
    }

    public void userLogin(String userLogin, String userPassword) {
        driver.findElement(LOGIN_INPUT).sendKeys(userLogin);
        driver.findElement(PASSWORD_INPUT).sendKeys(userPassword);
        driver.findElement(CHECKBOX_INPUT).click();
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void signedUpButtonClick() {
        driver.findElement(SIGN_UP_BUTTON).click();
    }


}
