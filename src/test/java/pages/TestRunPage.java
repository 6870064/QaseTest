package pages;

import elements.CustomDropdown;
import elements.Dropdown;
import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

@Log4j2
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

        log.info("info");

        driver.findElement(TEST_RUNS_SUBMENU).click();
    }

    @Step("Click on the button to start of the test run")
    public void setStartNewTestRunButtonClick() {

        log.info("info");

        driver.findElement(START_NEW_TEST_RUN_BUTTON).click();
    }

    @Step("Enter title of the test run")
    public void enterRunTitle(String testRunTitle) {

        log.info("info");

        new Input(driver, "Run title").write(testRunTitle);
    }

    @Step("Enter description of the test run")
    public void enterTestRunDescription(String testRunDescription) {

        log.info("info");

        new Input(driver, "Description").write(testRunDescription);
    }

    public void planValueSelect(String planValue) {

        log.info("info");

        new Dropdown(driver, "Plan", "Select...", planValue).dropDownClick();
    }

    @Step("Select assignee of the test run")
    public void assigneeSelect(String assigneeValueToClick) {

        log.info("info");

        new CustomDropdown(driver, "Default assignee", "Select...", assigneeValueToClick).dropDownClick();
    }

    @Step("Click on 'Add cases' button")
    public void setAddCasesButtonClick() {

        log.info("info");

        driver.findElement(ADD_CASES_BUTTON).click();
    }

    @Step("Click on checkbox")
    public void checkboxClick() {

        log.info("info");

        driver.findElement(CHECKBOX).click();
    }

    @Step("Click on 'Done' button")
    public void doneButtonClick() {

        log.info("info");

        driver.findElement(DONE_BUTTON).click();
    }

    @Step("Click on 'Start test run' button")
    public void startRunButtonClick() {

        log.info("info");

        driver.findElement(START_RUN_BUTTON).click();
    }
}
