package pages;

import dropdown.CustomDropdown;
import dropdown.Dropdown;
import elements.inputs.Input;
import elements.inputs.RequiredInput;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class DefectPage extends BasePage {

    public static final By DEFECTS_BUTTON = By.id("menu-link-test-defects");
    public static final By CREATE_NEW_DEFECT_BUTTON = By.xpath("//*[text()='Create new defect']");
    public static final By CREATE_DEFECT_BUTTON = By.xpath("//button[@class='btn btn-primary me-3 save-button']");

    String milestoneValueToClick = "Release 3.0";
    String assigneeValueToClick = "Dmitry Vyacheslavov";

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

    public void newDefectCreated(String defectTitle, String actualResult) {
    driver.findElement(DEFECTS_BUTTON).click();
    driver.findElement(CREATE_NEW_DEFECT_BUTTON).click();
    new RequiredInput(driver, "Defect title").write(defectTitle);
    new Input(driver, "Actual result").write(actualResult);
    new Dropdown(driver,"Milestone", "Not set", milestoneValueToClick).dropDownClick();
    new Dropdown(driver, "Severity", "Normal", "Blocker").dropDownClick();
    new CustomDropdown(driver, "Assignee", "Unassigned", assigneeValueToClick).dropDownClick();
    //fileUpload();
    driver.findElement(CREATE_DEFECT_BUTTON).click();
    }
}
