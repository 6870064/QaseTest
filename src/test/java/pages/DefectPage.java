package pages;

import elements.CustomDropdown;
import elements.Dropdown;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DefectPage extends BasePage {

    public static final By DEFECTS_SUBMENU = By.id("menu-link-test-defects");
    public static final By CREATE_NEW_DEFECT_BUTTON = By.xpath("//*[text()='Create new defect']");
    public static final By CREATE_DEFECT_BUTTON = By.xpath("//button[@class='btn btn-primary me-3 save-button']");
    String TITLE_OF_DEFECT_CREATED = "//*[contains(text(),'%s')]";
    String TITLE_OF_DEFECT_ON_PAGE = "//div[@class='col-lg-12']/h1";
    String DESCRIPTION_OF_DEFECT_CREATED = "//p[@class='defect-result-header' and contains (text(), 'Description')]/../div/div";
    String CASE_PARAM_LOCATOR = "//div[@class='case-param-title' and contains (text(), '%s')]/../div/div/span";
    String SEVERITY_PARAM_LOCATOR = "//i[contains(@class,'fa-angle-double-up')]/..";

    public DefectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementExist(CREATE_NEW_DEFECT_BUTTON);
    }

    @Override
    public boolean isCongratsPageOpened() {
        return false;
    }

    public void clickDefectsButton() {
        driver.findElement(DEFECTS_SUBMENU).click();
    }

    /**
     * Click on the button for creation new defect
     */
    public void createNewDefectButton() {
        driver.findElement(CREATE_NEW_DEFECT_BUTTON).click();
    }

    public void enterDefectTitle(String defectTitle) {
        new Input(driver, "Defect title").write(defectTitle);
    }

    public void enterActualResult(String actualResult) {
        new Input(driver, "Actual result").write(actualResult);
    }

    public void selectMilestoneValue(String mileStoneValue) {
        new Dropdown(driver, "Milestone", "Not set", mileStoneValue).dropDownClick();
    }

    public void selectSeverity(String severityValue) {
        new Dropdown(driver, "Severity", "Normal", severityValue).dropDownClick();
    }

    public void selectAssigneeValue(String assigneeValueToClick) {
        new CustomDropdown(driver, "Assignee", "Unassigned", assigneeValueToClick).dropDownClick();
    }

    /**
     * Allows saving defect
     */
    public void createDefectButtonClick() {
        driver.findElement(CREATE_DEFECT_BUTTON).click();
    }

    /**
     * Метод для открытия созданного баг репорта
     */

    public void createdDefectOpen(String titleOfDefect) {
        driver.findElement(By.xpath(String.format(TITLE_OF_DEFECT_CREATED, titleOfDefect))).click();
    }

    /**
     * Метод для проверки правильности заполнения параметра Title в созданном баг репорте
     */
    public String titleValueCheck() {
        String titleCreatedValue = driver.findElement(By.xpath(String.format(TITLE_OF_DEFECT_ON_PAGE))).getText();

        return titleCreatedValue;
    }

    /**
     * Метод для проверки правильности заполнения параметра Description в созданном баг репорте
     */
    public String descriptionValueCheck() {
        String bugCreatedValue = driver.findElement(By.xpath(String.format(DESCRIPTION_OF_DEFECT_CREATED))).getText();

        return bugCreatedValue;
    }

    /**
     * Метод для проверки правильности заполнения параметров Reporter и Assignee в созданном баг репорте
     */
    public String caseParameterValueCheck(String reporterValue) {
        String bugCreatedValue = driver.findElement(By.xpath(String.format(CASE_PARAM_LOCATOR, reporterValue))).getText();

        return bugCreatedValue;
    }

    /**
     * Метод для проверки правильности заполнения параметра Severity в созданном баг репорте
     */
    public String caseSeverityValueCheck() {
        String bugSeverityValue = driver.findElement(By.xpath(SEVERITY_PARAM_LOCATOR)).getText();

        return bugSeverityValue;
    }
}
