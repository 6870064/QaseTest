package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

import static org.testng.Assert.assertEquals;
import static pages.ProjectPage.PROJECT_URL;

public abstract class BasePage {
    public static final String BASE_URL = "https://app.qase.io/login";
    public static final By ADD_ATTACHMENT_BUTTON = By.xpath("//button[text()=' Add attachment']");
    public static final By DROP_FILES_AREA = By.xpath("//input[@class='dz-hidden-input']");
    public static final By UPLOADED_FILE = By.xpath("//div//p[@class='suitecase-attachment-filename']");

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
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

    public void fileUpload(String filePath, String fileName) {

        WebDriverWait wait = new WebDriverWait(driver, 3); //Element is not clickable at point - решение проблемы
        // кнопка addStep не видна/скрыта другими элементами
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        WebElement element = driver.findElement(ADD_ATTACHMENT_BUTTON); //scrolling
        js.executeScript("arguments[0].scrollIntoView();", element);
        wait.until(ExpectedConditions.elementToBeClickable(ADD_ATTACHMENT_BUTTON)); //clickable

        driver.findElement(ADD_ATTACHMENT_BUTTON).click();

        File file = new File(filePath);

        WebElement input_field = driver.findElement(DROP_FILES_AREA);
        input_field.sendKeys(file.getAbsolutePath());
        driver.findElement(DROP_FILES_AREA).sendKeys(file.getAbsolutePath());
        WebDriverWait wait2 = new WebDriverWait(driver, 5);

        String titleOfFile = driver.findElement(UPLOADED_FILE).getText();
    //    assertEquals(titleOfFile, fileName, "Title of the uploaded file is not equal"); //Проверить, что имя файла
        // на странице совпадает с именем загруженного файла
    }
}
