package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.HomePage.RESEND_BUTTON;

public class SignedUpPage extends BasePage {

    public static final By EMAIL_FIELD = By.id("inputEmail");
    public static final By PASSWORD_FIELD = By.id("inputPassword");
    public static final By CONFIRM_PASSWORD_FIELD = By.id("inputPasswordConfirm");
    public static final By CONTROL_INDICATOR = By.className("custom-control-indicator");
    public static final By SIGN_UP_BUTTON = By.xpath("//button[text()='Create your Qase account >']");
    public static final String newUserLogin = "test12345@mail.ru";
    public static final String newUserPassword = "qwe2233qwe";

    public SignedUpPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementExist(EMAIL_FIELD);
    }

    @Override
    public boolean isCongratsPageOpened() {
        return isElementExist(RESEND_BUTTON);
    }

    public void userSignedUP() {
    driver.findElement(EMAIL_FIELD).sendKeys(newUserLogin);
    driver.findElement(PASSWORD_FIELD).sendKeys(newUserPassword);
    driver.findElement(CONFIRM_PASSWORD_FIELD).sendKeys(newUserPassword);
    driver.findElement(CONTROL_INDICATOR).click();
    driver.findElement(SIGN_UP_BUTTON).click();
    }
}