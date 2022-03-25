package pages;

import elements.CustomInput;
import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class TestCasePage extends BasePage {

    public static final By CREATE_FIRST_CASE_BUTTON = By.xpath("//*[text()='Create new case']");
    public static final By CREATE_CASE_BUTTON = By.id("create-case-button");
    public static final By ADD_STEP_BUTTON = By.id("add-step");
    public static final By SAVE_BUTTON = By.id("save-case");
    public static final By ALL_CASES_WITHOUT_SUITE_CHECKBOX = By.xpath("//h3[@class='style_title-3jKh2']/label");
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

    @Step("Click on the button 'Create test case'")
    public void createTestCaseButtonClick() {
        driver.findElement(CREATE_CASE_BUTTON).click();
    }

    @Step("Enter title of the test case")
    public void enterTestCaseTitle(String testCaseTitle) {

        log.info("info");

        new Input(driver, "Title").write(testCaseTitle);
    }

    @Step("Select status of test case'")
    public void selectStatus(String testCaseStatus) {

        log.info("info");

        new Dropdown(driver, "Status", "Actual", testCaseStatus).dropDownClick();
    }

    @Step("Enter of the test case description")
    public void enterDescription(String testCaseDescription) {

        log.info("info");

        new Input(driver, "Description").write(testCaseDescription);
    }

    @Step("Select severity of the test case")
    public void selectSeverity(String testCaseSeverity) {

        log.info("info");

        new Dropdown(driver, "Severity", "Normal", testCaseSeverity).dropDownClick();
    }

    @Step("Select priority of the test case")
    public void selectPriority(String testCasePriority) {

        log.info("info");

        new Dropdown(driver, "Priority", "Not set", testCasePriority).dropDownClick();
    }

    @Step("Select type of the test case")
    public void selectType(String testCaseType) {
        new Dropdown(driver, "Type", "Other", testCaseType).dropDownClick();
    }

    @Step("Select layer of the test case")
    public void selectLayer(String testCaseLayer) {
        new Dropdown(driver, "Layer", "Unknown", testCaseLayer).dropDownClick();
    }

    @Step("Select staus of test case 'isFlaky'")
    public void selectIsFlaky(String testCaseIsFlaky) {
        new Dropdown(driver, "Is Flaky", "No", testCaseIsFlaky).dropDownClick();
    }

    @Step("Select behavior of the test case")
    public void selectBehavior(String testCaseBehavior) {
        new Dropdown(driver, "Behavior", "Not set", testCaseBehavior).dropDownClick();
    }

    @Step("Select automation status of the test case")
    public void selectAutomationStatus(String testCaseAutoStatus) {
        new Dropdown(driver, "Automation status", "Not automated", testCaseAutoStatus).dropDownClick();
    }

    @Step("Enter pre-conditions of the test case")
    public void enterPreConditions(String preConditions) {
        new Input(driver, "Pre-conditions").write(preConditions);
    }

    @Step("Enter post-conditions of the test case")
    public void enterPostConditions(String postConditions) {
        new Input(driver, "Post-conditions").write(postConditions);
    }

    @Step("Enter preconditions of the test case")
    public void saveButtonClick() {
        driver.findElement(SAVE_BUTTON).click();
    }

    @Step("Click on the checkbox to select all test cases")
    public void allCasesCheckBoxClick() {
        driver.findElement(ALL_CASES_WITHOUT_SUITE_CHECKBOX).click();
    }

    @Step("Click on the button to delete all test cases")
    public void deleteCasesButtonClick() {
        driver.findElement(DELETE_CASES_BUTTON).click();
    }

    @Step("Enter the text to confirm removal of all test cases")
    public void enterTextConfirmDeleteField(String text) {
        driver.findElement(CONFIRM_DELETE_FIELD).sendKeys(text);
    }

    @Step("Click on the button to confirm deletion of all test cases")
    public void deleteCasesConfirmButtonClick() {
        driver.findElement(DELETE_CASES_CONFIRM_BUTTON).click();
    }


    /**
     * обобщенный метод, который принимает много параметров и переиспользует все эти мелкие
     */

    @Step("Create the base test case")
    public void createBaseTestCase(String testCaseTitle, String testCaseDescription, String testCaseStatus, String testCaseSeverity,
                                   String testCasePriority, String testCaseType, String testCaseLayer, String testCaseIsFlaky,
                                   String testCaseBehavior, String testCaseAutoStatus) {

        log.info("info");

        createTestCaseButtonClick();
        enterTestCaseTitle(testCaseTitle);
        enterDescription(testCaseDescription);
        selectStatus(testCaseStatus);
        selectSeverity(testCaseSeverity);
        selectPriority(testCasePriority);
        selectType(testCaseType);
        selectLayer(testCaseLayer);
        selectIsFlaky(testCaseIsFlaky);
        selectBehavior(testCaseBehavior);
        selectAutomationStatus(testCaseAutoStatus);
        saveButtonClick();
    }

    @Step("Adding the step of test case")
    public void addStep(int i, String action, String inputData, String expectedResult) {  //Метод по добавлению шагов в тест-кейс испольуя CustomInput

        log.warn("warn");
        log.error("error");

        WebElement element = driver.findElement(ADD_STEP_BUTTON); //scrolling
        jsExecutor.scrollToElement(element);
        jsExecutor.clickOnElement(element);

        int a = i + 1;
        new CustomInput(driver, "action", Integer.toString(i)).write(action + a);
        new CustomInput(driver, "data", Integer.toString(i)).write(inputData + a);
        new CustomInput(driver, "expected_result", Integer.toString(i)).write(expectedResult + a);
    }
}
