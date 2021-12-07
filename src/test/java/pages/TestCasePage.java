package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import static pages.ProjectPage.PROJECT_URL;

public class TestCasePage extends BasePage {

    public static final By CREATE_FIRST_CASE_BUTTON = By.xpath("//*[text()='Create new case']");
    public static final By CREATE_CASE_BUTTON = By.id("create-case-button");
    public static final By TESTCASE_TITLE_FIELD = By.id("title");
    public static final By TESTCASE_DESCRIPTION = By.xpath("//div[@class='ProseMirror toastui-editor-contents']");
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
    public static final By PRE_CONDITIONS_FIELD = By.xpath("//div[@class='ProseMirror toastui-editor-contents']");
    public static final By POST_CONDITIONS_FIELD = By.xpath("//div[@class='ProseMirror toastui-editor-contents']");
    public static final By ADD_STEP_BUTTON = By.xpath("//div[@class='btn btn-invisible after-step b-0 p-0']");
    public static final By STEPS_ACTION = By.xpath("//*[text()='For example: Open Sign in page']");
    public static final By STEPS_INPUT_DATA = By.xpath("//*[text()='For example: Login / password']");
    public static final By STEPS_EXPECTED_RESULT = By.xpath("//*[text()='For example: popup is opened']");
    public static final By SAVE_BUTTON = By.id("save-case");

    public static final By ALL_CASES_CHECKBOX = By.cssSelector("[type='checkbox']");
    public static final By DELETE_CASES_BUTTON = By.xpath("//*[contains(text(),'Delete')]");
    public static final By DELETE_CASES_CONFIRM_BUTTON = By.xpath("//button[text()='Delete']");

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

    public void createTestCase(String testCaseTitle, String testCaseDescription, String preCondition, String postConditions, String step){
    driver.findElement(TESTCASE_TITLE_FIELD).sendKeys(testCaseTitle);
    driver.findElement(TESTCASE_DESCRIPTION).sendKeys(testCaseDescription);
    driver.findElement(TYPE_DROPDOWN).click();
    driver.findElement(TYPE_DROPDOWN_FUNCTIONAL).click();
    driver.findElement(PRIORITY_DROPDOWN).click();
    driver.findElement(PRIORITY_VALUE).click();
    driver.findElement(MILESTONE_DROPDOWN). click();
    driver.findElement(MILESTONE_VALUE).click();
    driver.findElement(BEHAVIOUR_DROPDOWN).click();
    driver.findElement(BEHAVIOUR_VALUE).click();
    driver.findElement(SEVERITY_DROPDOWN).click();
    driver.findElement(SEVERITY_VALUE).click();
    driver.findElement(LAYER_DROPDOWN).click();
    driver.findElement(LAYER_VALUE).click();
    driver.findElement(IS_FLAKY_DROPDOWN).click();
    driver.findElement(IS_FLAKY_VALUE).click();
    driver.findElement(AUTOMATION_STATUS_DROPDOWN).click();
    driver.findElement(AUTOMATION_STATUS_VALUE).click();
    driver.findElement(PRE_CONDITIONS_FIELD).sendKeys(preCondition);
    // driver.findElement(POST_CONDITIONS_FIELD).sendKeys(postConditions); Узнать как решить вопрос с locator
//    JavascriptExecutor jse = (JavascriptExecutor)driver;
//    jse.executeScript("window.scrollBy(0,750)");

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
