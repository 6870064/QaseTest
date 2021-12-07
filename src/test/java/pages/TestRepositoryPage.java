package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestRepositoryPage extends BasePage {

    public static final By CREATE_NEW_CASE = By.className("btn btn-primary ms-3");

    public TestRepositoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    @Override
    public boolean isCongratsPageOpened() {
        return false;
    }
}
