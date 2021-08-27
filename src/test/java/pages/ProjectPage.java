package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectPage extends BasePage {

    public static final By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    public static final By PROJECT_NAME_FIELD = By.id("inputTitle");
    public static final By PROJECT_CODE_FILED = By.id("inputCode");
    public static final By PROJECT_DESCRIPTION_FIELD = By.id("inputDescription");
    public static final By PROJECT_PUBLIC_ACCESS_RADIOBUTTON = By.id("public-access-type");
    public static final By CREATE_PROJECT_BUTTON = By.xpath("//button[text()='Create project']");
    public static final By CREATE_NEW_SUITE = By.xpath("//*[contains(text(),'Create new suite')]");
    public static final String projectName = "Test project title № 111";
    public static final String projectCode = "TPC-111";
    public static final String projectDescription = "Test description of the Test project with the title № 111. " +
            "The best test project written on JAVA.";


    public ProjectPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return isElementExist(PROJECT_NAME_FIELD);
    }

    @Override
    public boolean isCongratsPageOpened() {
        return false;
    }

    public void createNewProjectButtonClick() {
        driver.findElement(CREATE_NEW_PROJECT_BUTTON).click();
    }
    public void createNewProject() {
    driver.findElement(PROJECT_NAME_FIELD).sendKeys(projectName);
    driver.findElement(PROJECT_CODE_FILED).sendKeys(projectCode);
    driver.findElement(PROJECT_DESCRIPTION_FIELD).sendKeys(projectDescription);
    driver.findElement(PROJECT_PUBLIC_ACCESS_RADIOBUTTON).click();
    driver.findElement(CREATE_PROJECT_BUTTON).click();
    }

    public boolean isProjectCreated() {
        return isElementExist(CREATE_NEW_SUITE);
    }
}
