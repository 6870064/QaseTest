package pages;

import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestPlanPage extends BasePage {
    public static final By TEST_PLANS_SUBMENU = By.xpath("//*[text()='Test Plans']");
    public static final By CREATE_PLAN_BUTTON = By.id("createButton");
    public static final By ADD_CASES_BUTTON = By.id("edit-plan-add-cases-button");
    public static final By CHECKBOX = By.id("suite-0-checkbox");
    public static final By ADD_CASES_DONE_BUTTON = By.id("select-cases-done-button");
    public static final By SAVE_PLAN_BUTTON = By.id("save-plan");


    public TestPlanPage(WebDriver driver) {
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

    public boolean createPlanButtonIsDisplayed() {
        return isElementExist(CREATE_PLAN_BUTTON);
    }

    public void testPlansButtonClick() {
        driver.findElement(TEST_PLANS_SUBMENU).click();
    }

    public void createPlanButtonClick() {
        driver.findElement(CREATE_PLAN_BUTTON).click();
    }

    public void enterTestPlanTitle(String testPlanTitle) {
        new Input(driver, "Title").write(testPlanTitle);
    }

    public void enterTestPlanDescription(String testPlanDescription) {
        new Input(driver, "Description").write(testPlanDescription);
    }

    public void addCasesButtonClick() {
        driver.findElement(ADD_CASES_BUTTON).click();
    }

    public void checkboxSelect() {
        driver.findElement(CHECKBOX).click();
    }

    public void addCasesDoneButton() {
        driver.findElement(ADD_CASES_DONE_BUTTON).click();
    }

    public void savePlanButtonClick() {
        driver.findElement(SAVE_PLAN_BUTTON).click();
    }

    /**
     * Создание базового Тест плана
     */
    public void createBaseTestPlan(String testPlanTitleForRun, String testPlanDescriptionForRun){
        createPlanButtonClick();
        enterTestPlanTitle(testPlanTitleForRun);
        enterTestPlanDescription(testPlanDescriptionForRun);
        addCasesButtonClick();
        checkboxSelect();
        addCasesDoneButton();
        savePlanButtonClick();
    }
}


