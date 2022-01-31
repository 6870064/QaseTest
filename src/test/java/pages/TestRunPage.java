package pages;

import elements.CustomDropdown;
import elements.Dropdown;
import elements.Input;
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

    public void testRunsSubmenuClick() {
        driver.findElement(TEST_RUNS_SUBMENU).click();
    }

    public void setStartNewTestRunButtonClick() {
        driver.findElement(START_NEW_TEST_RUN_BUTTON).click();
    }

    public void enterRunTitle(String testRunTitle) {
        new Input(driver, "Run title").write(testRunTitle);
    }

    public void enterTestRunDescription(String testRunDescription) {
        new Input(driver, "Description").write(testRunDescription);
    }

    public void planValueSelect(String planValue) {
        new Dropdown(driver, "Plan", "Select...", planValue).dropDownClick();
    }

    public void assigneeSelect(String assigneeValueToClick) {
        new CustomDropdown(driver, "Default assignee", "Select...", assigneeValueToClick).dropDownClick();
    }

    public void setAddCasesButtonClick() {
        driver.findElement(ADD_CASES_BUTTON).click();
    }

    public void checkboxClick() {
        driver.findElement(CHECKBOX).click();
    }

    public void doneButtonClick() {
        driver.findElement(DONE_BUTTON).click();
    }

    public void startRunButtonClick() {
        driver.findElement(START_RUN_BUTTON).click();
    }

}
