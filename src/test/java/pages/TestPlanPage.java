package pages;

import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertFalse;

public class TestPlanPage extends BasePage {
    public static final By TEST_PLANS_BUTTON = By.xpath("//*[text()='Test Plans']");
    public static final By CREATE_PLAN_BUTTON = By.id("createButton");
    public static final By TITLE_FIELD = By.name("title");
    public static final By DESCRIPTION_FIELD = By.xpath("//div[@class='ProseMirror toastui-editor-contents']");
    public static final By ADD_CASES_BUTTON = By.id("edit-plan-add-cases-button");
    public static final By CHECKBOX = By.id("suite-0-checkbox");
    public static final By ADD_CASES_DONE_BUTTON = By.id("select-cases-done-button");
    public static final By SAVE_PLAN_BUTTON = By.id("save-plan");


    public TestPlanPage(WebDriver driver) {
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

    public boolean createPlaneButtonIsDisplayed(){
        return isElementExist(TEST_PLANS_BUTTON);
    }
    public void createTestPlanClick(){
        driver.findElement(TEST_PLANS_BUTTON);
    }

    public void createTestPlan(String testPlanTitle, String testPlanDescription){
        driver.findElement(TEST_PLANS_BUTTON).click();
        driver.findElement(CREATE_PLAN_BUTTON).click();
        driver.findElement(TITLE_FIELD).sendKeys(testPlanTitle);
        driver.findElement(DESCRIPTION_FIELD).sendKeys(testPlanDescription);
        driver.findElement(ADD_CASES_BUTTON).click();
        driver.findElement(CHECKBOX).click();
        driver.findElement(ADD_CASES_DONE_BUTTON).click();
        driver.findElement(SAVE_PLAN_BUTTON).click();
    }
}
