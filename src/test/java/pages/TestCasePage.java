package pages;

import elements.Dropdown;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertFalse;

public class TestCasePage extends BasePage {

    public static final By CREATE_FIRST_CASE_BUTTON = By.xpath("//*[text()='Create new case']");
    public static final By CREATE_CASE_BUTTON = By.id("create-case-button");
    public static final By ADD_STEP_BUTTON = By.xpath("//div[@class='btn btn-invisible after-step b-0 p-0']");
    public static final By SAVE_BUTTON = By.id("save-case");

    public static final By ALL_CASES_CHECKBOX = By.cssSelector("[type='checkbox']");
    public static final By DELETE_CASES_BUTTON = By.xpath("//*[contains(text(),'Delete')]");
    public static final By DELETE_CASES_CONFIRM_BUTTON = By.xpath("//button[text()='Delete']");
    String suiteValue = "Test cases without suite";
    String miletonevalue = "Release 3.0";


    public TestCasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return false;
    }

    public boolean addFirstCaseButtonIsDisplayed() {
        return isElementExist(CREATE_FIRST_CASE_BUTTON);
    }

    public boolean addCaseButtonIsDisplayed() {
        return isElementExist(CREATE_CASE_BUTTON);
    }

    public boolean addStepButtonIsDisplayed() {
        return isElementExist(ADD_STEP_BUTTON);
    }

    @Override
    public boolean isCongratsPageOpened() {
        return false;
    }

    public void createFirstTestCaseButtonClick() {
        driver.findElement(CREATE_FIRST_CASE_BUTTON).click();
    }

    public void createTestCaseButtonClick() {
        driver.findElement(CREATE_CASE_BUTTON).click();
    }

    public void createTestCase(String testCaseTitle, String testCaseDescription, String preConditions, String postConditions) {
        new Input(driver, "Title").write(testCaseTitle);
        new Dropdown(driver, "Status", "Actual", "Draft").dropDownClick();
        new Input(driver, "Description").write(testCaseDescription);
        new Dropdown(driver, "Suite", "Test cases without suite", suiteValue).dropDownClick();
        new Dropdown(driver, "Severity", "Normal", "Blocker").dropDownClick();
        new Dropdown(driver, "Priority", "Not set", "High").dropDownClick();
        new Dropdown(driver, "Type", "Other", "Functional").dropDownClick();
        new Dropdown(driver, "Layer", "Unknown", "E2E").dropDownClick();
        new Dropdown(driver, "Is Flaky", "No", "Yes").dropDownClick();
        new Dropdown(driver, "Milestone", "Not set", miletonevalue).dropDownClick();
        new Dropdown(driver, "Behavior", "Not set", "Positive").dropDownClick();
        new Dropdown(driver, "Automation status", "Not automated", "To be automated").dropDownClick();
        new Input(driver, "Pre-conditions").write(preConditions);
        new Input(driver, "Post-conditions").write(postConditions);
        fileUpload();

        //assertTrue(addStepButtonIsDisplayed(), "Add step button is not displayed");

//    for (int i =0;i<3;i++)  {
//    driver.findElement(ADD_STEP_BUTTON).click();
//    driver.findElement(STEPS_ACTION).sendKeys(step);
//    driver.findElement(STEPS_INPUT_DATA).sendKeys(step);
//    driver.findElement(STEPS_EXPECTED_RESULT).sendKeys(step);
//    }

        driver.findElement(SAVE_BUTTON).click();
    }

    public void deleteAllTestCases() {
        List<WebElement> checkBoxes = driver.findElements(ALL_CASES_CHECKBOX);
        assertFalse(checkBoxes.get(1).isSelected(), "Первый чекбокс не выбран");
        checkBoxes.get(1).click();
        driver.findElement(DELETE_CASES_BUTTON).click();
        driver.findElement(DELETE_CASES_CONFIRM_BUTTON).click();
    }
}
