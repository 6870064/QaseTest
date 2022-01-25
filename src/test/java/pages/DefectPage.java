package pages;

import elements.CustomDropdown;
import elements.Dropdown;
import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DefectPage extends BasePage {

    public static final By DEFECTS_BUTTON = By.id("menu-link-test-defects");
    public static final By CREATE_NEW_DEFECT_BUTTON = By.xpath("//*[text()='Create new defect']");
    public static final By CREATE_DEFECT_BUTTON = By.xpath("//button[@class='btn btn-primary me-3 save-button']");

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

    public void defectsButtonClick(){
        driver.findElement(DEFECTS_BUTTON).click();
    }

    public void createNewDefectButton(){
        driver.findElement(CREATE_NEW_DEFECT_BUTTON).click();
    }

    public void enterDefectTitle(String defectTitle) {
        new Input(driver, "Defect title").write(defectTitle);
    }

    public void enterActualResult(String actualResult) {
        new Input(driver, "Actual result").write(actualResult);
    }

    public void milestoneValueSelect(String mileStoneValue) {
        new Dropdown(driver, "Milestone", "Not set", mileStoneValue).dropDownClick();
    }

    public void severitySelect(String severityValue) {
        new Dropdown(driver, "Severity", "Normal", severityValue).dropDownClick();
    }

    public void assigneeValueSelect(String assigneeValueToClick) {
        new CustomDropdown(driver, "Assignee", "Unassigned", assigneeValueToClick).dropDownClick();
    }

    public void createDefectButtonClick() {
        driver.findElement(CREATE_DEFECT_BUTTON).click();
    }
}
