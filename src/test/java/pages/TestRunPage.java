package pages;

import elements.CustomDropdown;
import elements.Dropdown;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestRunPage extends BasePage {

    public static final By TEST_RUNS_BUTTON = By.xpath("//*[text()='Test Runs']");
    public static final By START_NEW_TEST_RUN_BUTTON = By.xpath("//*[text()='Start new test run']");
    public static final By DESCRIPTION_FIELD = By.xpath("//div[@class='ProseMirror toastui-editor-contents']");
    public static final By PLAN_FIELD = By.xpath("//*[text()='Select...']");
    public static final By PLAN_FIELD_VALUE = By.xpath("//*[text()='Test plan for regression testing #1']");
    public static final By DEFAULT_ASSIGNEE_DROPDOWN = By.xpath("//div[@class=' css-80li7u-placeholder']");
    public static final By DEFAULT_ASSIGNEE_VALUE = By.xpath("//div[@class=' css-io3r9z-singleValue']");
    public static final By MILESTONE_DROPDOWN = By.xpath("//*[text()='Not set']");
    public static final By MILESTONE_VALUE = By.xpath("//*[text()='Release 1.0']");
    public static final By ADD_CASES_BUTTON = By.id("edit-run-add-cases-button");
    public static final By CHECKBOX = By.id("suite-0-checkbox");
    public static final By DONE_BUTTON = By.id("select-cases-done-button");
    public static final By START_RUN_BUTTON = By.id("save-run-button");

    String planValue = "Test plan for regression testing #1";
    String milestoneValue = "Release 3.0";
    String assigneeValueToClick = "Dmitry Vyacheslavov";

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

    public boolean createTestRunButtonIsDisplayed(){
        return isElementExist(TEST_RUNS_BUTTON);
    }

    public void createTestRun(String testRunDescription) {
    driver.findElement(TEST_RUNS_BUTTON).click();
    driver.findElement(START_NEW_TEST_RUN_BUTTON).click();
    new Input(driver, "Description").write(testRunDescription);
    new Dropdown(driver, "Plan", "Select...", planValue).dropDownClick();
    new Dropdown(driver, "Milestone", "Not set", milestoneValue).dropDownClick();
    new CustomDropdown(driver, "Default assignee", "Select...", assigneeValueToClick).dropDownClick();
    driver.findElement(ADD_CASES_BUTTON).click();
    driver.findElement(CHECKBOX).click();
    driver.findElement(DONE_BUTTON).click();
    driver.findElement(START_RUN_BUTTON).click();
    }
}
