package pages;

import elements.CustomDropdown;
import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestRunPage extends BasePage {

    public static final By TEST_RUNS_SUBMENU = By.xpath("//*[text()='Test Runs']");
    public static final By START_NEW_TEST_RUN_BUTTON = By.xpath("//*[text()='Start new test run']");
    public static final By ADD_CASES_BUTTON = By.id("edit-run-add-cases-button");
    public static final By CHECKBOX = By.id("suite-0-checkbox");
    public static final By DONE_BUTTON = By.id("select-cases-done-button");
    public static final By START_RUN_BUTTON = By.id("save-run-button");

    public TestRunPage(WebDriver driver) {
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

    public boolean startNewTestRunButtonIsDisplayed() {
        return isElementExist(START_NEW_TEST_RUN_BUTTON);
    }

    @Step("Click on test run submenu")
    public void testRunsSubmenuClick() {
        driver.findElement(TEST_RUNS_SUBMENU).click();
    }

    @Step("Click on the button to start of the test run")
    public void setStartNewTestRunButtonClick() {
        driver.findElement(START_NEW_TEST_RUN_BUTTON).click();
    }

    @Step("Enter title of the test run")
    public void enterRunTitle(String testRunTitle) {
        new Input(driver, "Run title").write(testRunTitle);
    }

    @Step("Enter description of the test run")
    public void enterTestRunDescription(String testRunDescription) {
        new Input(driver, "Description").write(testRunDescription);
    }

    public void planValueSelect(String planValue) {
        new Dropdown(driver, "Plan", "Select...", planValue).dropDownClick();
    }

    @Step("Select assignee of the test run")
    public void assigneeSelect(String assigneeValueToClick) {
        new CustomDropdown(driver, "Default assignee", "Select...", assigneeValueToClick).dropDownClick();
    }

    @Step("Click on 'Add cases' button")
    public void setAddCasesButtonClick() {
        driver.findElement(ADD_CASES_BUTTON).click();
    }

    @Step("Click on checkbox")
    public void checkboxClick() {
        driver.findElement(CHECKBOX).click();
    }

    @Step("Click on 'Done' button")
    public void doneButtonClick() {
        driver.findElement(DONE_BUTTON).click();
    }

    @Step("Click on 'Start test run' button")
    public void startRunButtonClick() {
        driver.findElement(START_RUN_BUTTON).click();
    }
}
