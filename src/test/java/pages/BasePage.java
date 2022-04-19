package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.JSExecutor;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static pages.ProjectPage.PROJECT_URL;

@Log4j2
public abstract class BasePage {
    public static final String BASE_URL = "https://app.qase.io/login";
    public static final By ADD_ATTACHMENT_BUTTON = By.xpath("//button[text()=' Add attachment']");
    public static final By DROP_FILES_AREA = By.xpath("//input[@class='dz-hidden-input']");
    public static final By UPLOADED_FILE = By.xpath("//div//p[@class='suitecase-attachment-filename']");

    WebDriver driver;
    WebDriverWait wait;
    JSExecutor jsExecutor;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
        jsExecutor = new JSExecutor(driver);
    }


    public void projectOpen() {
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

    @Step("Upload File as attachment")
    public void fileUpload(String filePath) {

        log.info("Upload File with the path "+ filePath +" as attachment");

        WebElement element = driver.findElement(ADD_ATTACHMENT_BUTTON); //scrolling
        jsExecutor.scrollToElement(element);
        jsExecutor.clickOnElement(element);
        File file = new File(filePath);
        WebElement input_field = driver.findElement(DROP_FILES_AREA);
        input_field.sendKeys(file.getAbsolutePath());
        driver.findElement(DROP_FILES_AREA).sendKeys(file.getAbsolutePath());
    }

    public void checkTitleOfFileUploaded(String fileName) {

        log.info("check upload of the file titled " +fileName);

        String titleOfFile = driver.findElement(UPLOADED_FILE).getAttribute("innerText");
        assertEquals(titleOfFile, fileName, "Title of the uploaded file is not equal"); //Проверить, что имя файла
        // на странице совпадает с именем загруженного файла
    }
}
