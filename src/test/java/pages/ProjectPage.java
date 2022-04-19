package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class ProjectPage extends BasePage {

    public static final By CREATE_NEW_PROJECT_BUTTON = By.id("createButton");
    public static final By PROJECT_NAME_FIELD = By.id("inputTitle");
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
        driver.findElement(CREATE_NEW_PROJECT_BUTTON).click();

        log.warn("Click on the button to create new project");
        log.error("Click on the button to create new project");
    }

    @Step("Enter project title")
    public void EnterProjectName(String projectName) {

        new Input(driver, "Project name").write(projectName);
    }

    @Step("Enter project description")
    public void EnterDescription(String projectDescription) {
        driver.findElement(PROJECT_DESCRIPTION_FIELD).sendKeys(projectDescription);

        log.info("Enter project description");
    }

    @Step("Click on the radiobutton 'Public access project'")
    public void ProjectPublicAccessRadioButtonClick() {

        driver.findElement(PROJECT_PUBLIC_ACCESS_RADIOBUTTON).click();

        log.info("Click on the radiobutton 'Public access project'");
    }

    @Step("Click on the 'Create project' button")
    public void CreateProjectButton() {

        driver.findElement(CREATE_PROJECT_BUTTON).click();
        log.info("Click on the 'Create project' button");
    }

    @Step("Open the project'")
    public void projectOpen() {
        driver.get(PROJECT_URL);
    }

    public boolean isProjectCreated() {
        return isElementExist(CREATE_NEW_SUITE);
    }
}
