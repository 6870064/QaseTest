package pages;

import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertFalse;

public class TestPlanPage extends BasePage {
    public static final By TEST_PLANS_BUTTON = By.xpath("//*[text()='Test Plans']");
    public static final By CREATE_PLAN_BUTTON = By.id("createButton");
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
        new Input(driver, "Title").write(testPlanTitle);
        new Input(driver, "Description").write(testPlanDescription);
        driver.findElement(ADD_CASES_BUTTON).click();
        driver.findElement(CHECKBOX).click();
        driver.findElement(ADD_CASES_DONE_BUTTON).click();
        driver.findElement(SAVE_PLAN_BUTTON).click();
    }
}
