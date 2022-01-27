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

public class TestCasePage extends BasePage {

    public static final By CREATE_FIRST_CASE_BUTTON = By.xpath("//*[text()='Create new case']");
    public static final By CREATE_CASE_BUTTON = By.id("create-case-button");
    public static final By ADD_STEP_BUTTON = By.id("add-step");
    public static final By SAVE_BUTTON = By.id("save-case");
    public static final By ALL_CASES_CHECKBOX = By.xpath("//label[@class='style_checkbox-tLOSg style_checkbox-1ztec style_inHeader-18FWp']");
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

    public void enterTestCaseTitle(String testCaseTitle) {
        new Input(driver, "Title").write(testCaseTitle);
    }

    public void selectStatus(String testCaseStatus) {
        new Dropdown(driver, "Status", "Actual", testCaseStatus).dropDownClick();
    }

    public void enterDescription(String testCaseDescription) {
        new Input(driver, "Description").write(testCaseDescription);
    }

    public void selectSeverity(String testCaseSeverity) {
        new Dropdown(driver, "Severity", "Normal", testCaseSeverity).dropDownClick();
    }

    public void selectPriority(String testCasePriority) {
        new Dropdown(driver, "Priority", "Not set", testCasePriority).dropDownClick();
    }

    public void selectType(String testCaseType) {
        new Dropdown(driver, "Type", "Other", testCaseType).dropDownClick();
    }

    public void selectLayer(String testCaseLayer) {
        new Dropdown(driver, "Layer", "Unknown", testCaseLayer).dropDownClick();
    }

    public void selectIsFlaky(String testCaseIsFlaky) {
        new Dropdown(driver, "Is Flaky", "No", testCaseIsFlaky).dropDownClick();
    }

    public void selectBehavior(String testCaseBehavior) {
        new Dropdown(driver, "Behavior", "Not set", testCaseBehavior).dropDownClick();
    }

    public void selectAutomationStatus(String testCaseAutoStatus) {
        new Dropdown(driver, "Automation status", "Not automated", testCaseAutoStatus).dropDownClick();
    }

    public void enterPreConditions(String preConditions) {
        new Input(driver, "Pre-conditions").write(preConditions);
    }

    public void enterPostConditions(String postConditions) {
        new Input(driver, "Post-conditions").write(postConditions);
    }

    public void saveButtonClick() {
        driver.findElement(SAVE_BUTTON).click();
    }

    public void allCasesCheckBoxClick() {
        driver.findElement(ALL_CASES_CHECKBOX).click();
    }

    public void deleteCasesButtonClick() {
        driver.findElement(DELETE_CASES_BUTTON).click();
    }

    public void enterTextConfirmDeleteField(String text) {
        driver.findElement(CONFIRM_DELETE_FIELD).sendKeys(text);
    }

    public void deleteCasesConfirmButtonClick() {
        driver.findElement(DELETE_CASES_CONFIRM_BUTTON).click();
    }

    public void addStep(int i, String action, String inputData, String expectedResult) {  //Метод по добавлению шагов в тест-кейс испольуя CustomInput

        WebDriverWait wait = new WebDriverWait(driver, 3); //Element is not clickable at point - решение проблемы
        // кнопка addStep не видна/скрыта другими элементами
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        WebElement element = driver.findElement(ADD_STEP_BUTTON); //scrolling
        js.executeScript("arguments[0].scrollIntoView();", element);
        wait.until(ExpectedConditions.elementToBeClickable(element)); //clickable
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);

        int a = i + 1;
        new CustomInput(driver, "action", Integer.toString(i)).write(action + a);
        new CustomInput(driver, "data", Integer.toString(i)).write(inputData + a);
        new CustomInput(driver, "expected_result", Integer.toString(i)).write(expectedResult + a);
    }
}
