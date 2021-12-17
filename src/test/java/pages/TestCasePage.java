package pages;

import elements.CustomInput;
import elements.Dropdown;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.testng.Assert.assertFalse;

public class TestCasePage extends BasePage {

    public static final By CREATE_FIRST_CASE_BUTTON = By.xpath("//*[text()='Create new case']");
    public static final By CREATE_CASE_BUTTON = By.id("create-case-button");
    public static final By ADD_STEP_BUTTON = By.id("add-step");
    public static final By SAVE_BUTTON = By.id("save-case");
    public static final By ALL_CASES_CHECKBOX = By.cssSelector("[type='checkbox']");
    public static final By DELETE_CASES_BUTTON = By.xpath("//*[contains(text(),'Delete')]");
    public static final By CONFIRM_DELETE_FIELD = By.xpath("//input[@class='form-control'][@name='confirm']");
    public static final By DELETE_CASES_CONFIRM_BUTTON = By.xpath("//button[text()='Delete']");

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

    public void createTestCase(String testCaseTitle, String testCaseDescription, String suiteValue, String milestoneValue, String preConditions, String postConditions) {
        new Input(driver, "Title").write(testCaseTitle);
        new Dropdown(driver, "Status", "Actual", "Draft").dropDownClick();
        new Input(driver, "Description").write(testCaseDescription);
        new Dropdown(driver, "Suite", "Test cases without suite", suiteValue).dropDownClick();
        new Dropdown(driver, "Severity", "Normal", "Blocker").dropDownClick();
        new Dropdown(driver, "Priority", "Not set", "High").dropDownClick();
        new Dropdown(driver, "Type", "Other", "Functional").dropDownClick();
        new Dropdown(driver, "Layer", "Unknown", "E2E").dropDownClick();
        new Dropdown(driver, "Is Flaky", "No", "Yes").dropDownClick();
        new Dropdown(driver, "Milestone", "Not set", milestoneValue).dropDownClick();
        new Dropdown(driver, "Behavior", "Not set", "Positive").dropDownClick();
        new Dropdown(driver, "Automation status", "Not automated", "To be automated").dropDownClick();
        new Input(driver, "Pre-conditions").write(preConditions);
        new Input(driver, "Post-conditions").write(postConditions);
    }

    public void saveButtonClick(){
    driver.findElement(SAVE_BUTTON).click();
    }

    public void deleteAllTestCases(String text) {
        List<WebElement> checkBoxes = driver.findElements(ALL_CASES_CHECKBOX);
        assertFalse(checkBoxes.get(1).isSelected(), "Первый чекбокс не выбран");
        checkBoxes.get(0).click();
        driver.findElement(DELETE_CASES_BUTTON).click();
        driver.findElement(CONFIRM_DELETE_FIELD).sendKeys(text);
        driver.findElement(DELETE_CASES_CONFIRM_BUTTON).click();
    }

    public void addStep(int i, String action, String inputData, String expectedResult) {  //Метод по добавлению шагов в тест-кейс испольуя CustomInput

        WebDriverWait wait = new WebDriverWait(driver, 3); //Element is not clickable at point - решение проблемы
        // кнопка addStep не видна/скрыта другими элементами
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        WebElement element = driver.findElement(ADD_STEP_BUTTON); //scrolling
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        wait.until(ExpectedConditions.elementToBeClickable(ADD_STEP_BUTTON)); //clickable


            driver.findElement(ADD_STEP_BUTTON).click();
            int a = i+1;
            new CustomInput(driver, "action",Integer.toString(i)).write(action + a);
            new CustomInput(driver, "data",Integer.toString(i)).write(inputData + a);
            new CustomInput(driver, "expected_result",Integer.toString(i)).write(expectedResult + a);
    }
}
