package pages;

import dropdown.Dropdown;
import elements.inputs.NonRequiredInput;
import elements.inputs.RequiredInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class TestCasePage extends BasePage {

    public static final By CREATE_FIRST_CASE_BUTTON = By.xpath("//*[text()='Create new case']");
    public static final By CREATE_CASE_BUTTON = By.id("create-case-button");
    public static final By TYPE_DROPDOWN = By.xpath("//*[text()='Other']");
    public static final By TYPE_DROPDOWN_FUNCTIONAL = By.xpath("//*[text()='Functional']");
    public static final By MILESTONE_DROPDOWN = By.xpath("//*[text()='Not set']");
    public static final By MILESTONE_VALUE = By.xpath("//*[text()='Release 1.0']");
    public static final By SEVERITY_DROPDOWN = By.xpath("//*[text()='Normal']");
    public static final By SEVERITY_VALUE = By.xpath("//*[text()='Major']");
    public static final By LAYER_DROPDOWN = By.xpath("//*[text()='Unknown']");
    public static final By LAYER_VALUE = By.xpath("//*[text()='E2E']");
    public static final By BEHAVIOUR_DROPDOWN = By.xpath("//*[text()='Not set']");
    public static final By BEHAVIOUR_VALUE = By.xpath("//*[text()='Positive']");
    public static final By PRIORITY_DROPDOWN = By.xpath("//*[text()='Not set']");
    public static final By PRIORITY_VALUE = By.xpath("//*[text()='High']");
    public static final By IS_FLAKY_DROPDOWN = By.xpath("//*[text()='No']");
    public static final By IS_FLAKY_VALUE = By.xpath("//*[text()='Yes']");
    public static final By AUTOMATION_STATUS_DROPDOWN = By.xpath("//*[text()='Not automated']");
    public static final By AUTOMATION_STATUS_VALUE = By.xpath("//*[text()='To be automated']");
    public static final By ADD_STEP_BUTTON = By.xpath("//div[@class='btn btn-invisible after-step b-0 p-0']");
    public static final By STEPS_ACTION = By.xpath("//*[text()='For example: Open Sign in page']");
    public static final By STEPS_INPUT_DATA = By.xpath("//*[text()='For example: Login / password']");
    public static final By STEPS_EXPECTED_RESULT = By.xpath("//*[text()='For example: popup is opened']");
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

    public boolean addFirstCaseButtonIsDisplayed(){
        return isElementExist(CREATE_FIRST_CASE_BUTTON);
    }

    public boolean addCaseButtonIsDisplayed(){
        return isElementExist(CREATE_CASE_BUTTON);
    }

    public boolean addStepButtonIsDisplayed() {
        return isElementExist(ADD_STEP_BUTTON);
    }

    @Override
    public boolean isCongratsPageOpened() {
        return false;
    }

    public void createFirstTestCaseButtonClick(){
    driver.findElement(CREATE_FIRST_CASE_BUTTON).click();
    }

    public void createTestCaseButtonClick(){
    driver.findElement(CREATE_CASE_BUTTON).click();
    }

    public void createTestCase(String testCaseTitle, String testCaseDescription, String preConditions, String postConditions) throws InterruptedException {
    new RequiredInput(driver, "Title").write(testCaseTitle);
    new Dropdown(driver, "Status", "Actual", "Draft").dropDownClick();
    new NonRequiredInput(driver,"Description").write(testCaseDescription);
    new Dropdown(driver,"Suite", "Test cases without suite", suiteValue).dropDownClick();
    new Dropdown(driver, "Severity","Normal", "Blocker").dropDownClick();
    new Dropdown(driver,"Priority", "Not set", "High").dropDownClick();
    new Dropdown(driver, "Type", "Other", "Functional").dropDownClick();
    new Dropdown(driver,"Layer", "Unknown","E2E").dropDownClick();
    new Dropdown(driver,"Is Flaky", "No", "Yes").dropDownClick();
    new Dropdown(driver,"Milestone", "Not set", miletonevalue).dropDownClick();
    new Dropdown(driver,"Behavior", "Not set", "Positive").dropDownClick();
    new Dropdown(driver,"Automation status", "Not automated", "To be automated").dropDownClick();
    new NonRequiredInput(driver,"Pre-conditions").write(preConditions);
    new NonRequiredInput(driver, "Post-conditions").write(postConditions);

    //assertTrue(addStepButtonIsDisplayed(), "Add step button is not displayed");

//    for (int i =0;i<3;i++)  {
//    driver.findElement(ADD_STEP_BUTTON).click();
//    driver.findElement(STEPS_ACTION).sendKeys(step);
//    driver.findElement(STEPS_INPUT_DATA).sendKeys(step);
//    driver.findElement(STEPS_EXPECTED_RESULT).sendKeys(step);
//    }

    driver.findElement(SAVE_BUTTON).click();
    }

    public void deleteAllTestCases(){
    List<WebElement> checkBoxes = driver.findElements(ALL_CASES_CHECKBOX);
    assertFalse(checkBoxes.get(1).isSelected(),"Первый чекбокс не выбран");
    checkBoxes.get(1).click();
    driver.findElement(DELETE_CASES_BUTTON).click();
    driver.findElement(DELETE_CASES_CONFIRM_BUTTON).click();
    }
}
