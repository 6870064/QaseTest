package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

@Log4j2
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

        log.info("info");

        driver.findElement(LOGIN_INPUT).sendKeys(userLogin);
        driver.findElement(PASSWORD_INPUT).sendKeys(userPassword);
        driver.findElement(CHECKBOX_INPUT).click();
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void enterUserLogin(String userLogin) {
        driver.findElement(LOGIN_INPUT).sendKeys(userLogin);
    }

    public void enterUserPassword(String userPassword) {
        driver.findElement(PASSWORD_INPUT).sendKeys(userPassword);
    }

    public void clickCheckBoxInput(){
        driver.findElement(CHECKBOX_INPUT).click();
    }

    public void clickLoginButton(){
        driver.findElement(LOGIN_BUTTON).click();
    }
}
