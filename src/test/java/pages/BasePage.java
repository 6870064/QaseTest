package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static pages.ProjectPage.PROJECT_URL;

public abstract class BasePage {
    public static final String BASE_URL = "https://app.qase.io/login";
    public static final String FILE_PATH = "src/test/resources/152360.jpeg";
    public static final By ADD_ATTACHMENT_BUTTON = By.xpath("//button[text()=' Add attachment']");
    public static final By DROP_FILES_AREA = By.xpath("//div[@class='dropzone dz-clickable']");
    public static final By UPLOADED_FILE = By.xpath("//div[@class='suitecase-attachment-link is-image']");

    public static final By MILESTONE_DROPDOWN = By.xpath("//*[text()='Not set']");
    public static final By MILESTONE_VALUE = By.xpath("//*[text()='Release 1.0']");

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    public void projectOpen(){
        driver.get(PROJECT_URL);
    }

    public abstract boolean isPageOpened();

    public abstract boolean isCongratsPageOpened();

    public boolean isElementExist(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
    }

    @Test
    public void fileUpload() {
        driver.findElement(ADD_ATTACHMENT_BUTTON).click();
        File file = new File(FILE_PATH);
        driver.findElement(DROP_FILES_AREA).sendKeys(file.getAbsolutePath());
        WebDriverWait wait = new WebDriverWait(driver, 5);
        String titleOfFile = driver.findElement(UPLOADED_FILE).getText();
        assertEquals(titleOfFile, "152360.jpeg", "Title of the uploaded file is not equal"); //Проверить, что имя файла
        // на странице совпадает с именем загруженного файла
    }
}
