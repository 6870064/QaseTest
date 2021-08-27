package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    public static final By CREATE_BUTTON = By.id("createButton");
    public static final By RESEND_BUTTON = By.id("resend");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementExist(CREATE_BUTTON);
    }

    @Override
    public boolean isCongratsPageOpened() {
        return isElementExist(RESEND_BUTTON);
    }
}
