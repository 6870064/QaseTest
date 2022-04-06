package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

@Log4j2
public class ProjectPage extends BasePage {

    public static final By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    public static final By PROJECT_NAME_FIELD = By.id("inputTitle");
    public static final By PROJECT_CODE_FILED = By.id("inputCode");
    public static final By PROJECT_DESCRIPTION_FIELD = By.id("inputDescription");
    public static final By PROJECT_PUBLIC_ACCESS_RADIOBUTTON = By.id("public-access-type");
    public static final By CREATE_PROJECT_BUTTON = By.xpath("//button[text()='Create project']");
    public static final By CREATE_NEW_SUITE = By.xpath("//*[contains(text(),'Create new suite')]");
    public static final String PROJECT_URL = "https://app.qase.io/project/12";

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

    @Step("Click on the button to create new project")
    public void createNewProjectButtonClick() {

        log.info("info");

        driver.findElement(CREATE_NEW_PROJECT_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Enter project title")
    public void EnterProjectName(String projectName) {

        log.info("info");

        new Input(driver, "Project name").write(projectName);
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Enter project code")
    public void EnterProjectCode(String projectCode) {

        new Input(driver, "Project Code").write(projectCode);
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Enter project description")
    public void EnterProjectDescriptionField(String projectDescription) {

        log.info("info");

        driver.findElement(PROJECT_DESCRIPTION_FIELD).sendKeys(projectDescription);
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Click on the radiobutton 'Public access project'")
    public void ProjectPublicAccessRadioButtonClick() {

        log.info("info");

        driver.findElement(PROJECT_PUBLIC_ACCESS_RADIOBUTTON).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Click on the radiobutton 'Public access project'")
    public void CreateProjectButton() {

        log.info("info");

        driver.findElement(CREATE_PROJECT_BUTTON).click();
        AllureUtils.takeScreenshot(driver);
    }

    @Step("Open the project'")
    public void projectOpen() {

        log.info("info");

        driver.get(PROJECT_URL);
        AllureUtils.takeScreenshot(driver);
    }

    public boolean isProjectCreated() {

        log.info("info");

        return isElementExist(CREATE_NEW_SUITE);
    }
}
