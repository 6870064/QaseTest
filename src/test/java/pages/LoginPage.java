package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public static final By LOGIN_INPUT = By.id("inputEmail");
    public static final By PASSWORD_INPUT = By.id("inputPassword");
    public static final By CHECKBOX_INPUT = By.className("custom-control-indicator");
    public static final By SIGN_UP_BUTTON = By.linkText("Sign up");
    public static final By LOGIN_BUTTON = By.id("btnLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void pageOpen() {
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

    @Step("Login by user: {userLogin}, {userPassword}")
    public void login(String userLogin, String userPassword) {
        driver.findElement(LOGIN_INPUT).sendKeys(userLogin);
        driver.findElement(PASSWORD_INPUT).sendKeys(userPassword);
        driver.findElement(CHECKBOX_INPUT).click();
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void signedUpButtonClick() {
        driver.findElement(SIGN_UP_BUTTON).click();
    }


}
