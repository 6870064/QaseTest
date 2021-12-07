package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import static org.testng.Assert.assertEquals;

public class DefectPage extends BasePage {

    public static final By DEFECTS_BUTTON = By.id("menu-link-test-defects");
    public static final By CREATE_NEW_DEFECT_BUTTON = By.xpath("//*[text()='Create new defect']");
    public static final By DEFECT_TITLE = By.id("title");
    public static final By ACTUAL_RESULT = By.xpath("//div[@class='ProseMirror toastui-editor-contents']");
    public static final By SEVERITY_DROPDOWN = By.xpath("//*[text()='Normal']");
    public static final By SEVERITY_MAJOR_DROPDOWN = By.xpath("//*[text()='Major']");
    public static final By ASSIGNEE_DROPDOWN = By.xpath("//*[text()='Unassigned']");
    public static final By ASSIGNEE_DV = By.xpath("//*[text()='Dmitry Vyacheslavov']");
    public static final By CREATE_DEFECT_BUTTON = By.xpath("//*[text()='Create defect']");

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
    driver.findElement(DEFECT_TITLE).sendKeys(defectTitle);
    driver.findElement(ACTUAL_RESULT).sendKeys(actualResult);
    driver.findElement(MILESTONE_DROPDOWN).click(); // клик на дропдаун список Milestone
    driver.findElement(MILESTONE_VALUE).click(); //Выбор Milestone Release 1.0
    driver.findElement(SEVERITY_DROPDOWN).click(); // клик на дропдаун список Severity
    driver.findElement(SEVERITY_MAJOR_DROPDOWN).click(); //Выбор severity Major
    driver.findElement(ASSIGNEE_DROPDOWN).click();// клик на дропдаун список Assignee
    driver.findElement(ASSIGNEE_DV).click(); //Выбор Assignee Dmitry Vyacheslavov
    fileUpload();
    driver.findElement(CREATE_DEFECT_BUTTON).click();
    }
}
