package pages;

import elements.Input;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.AllureUtils;

import static pages.ProjectPage.PROJECT_URL;

@Log4j2
public class MilestonePage extends BasePage {

    public static final By MILESTONES_SUBMENU = By.xpath("//*[text()='Milestones']");
    public static final By CREATE_MILESTONE_BUTTON = By.id("createButton");
    public static final By CREATE_NEW_MILESTONE_BUTTON = By.xpath("//button[@class='btn btn-primary me-3 save-button']");

    public MilestonePage(WebDriver driver) {
        super(driver);
    }

    public void projectOpen() {
        driver.get(PROJECT_URL);
    }

    @Override
    public boolean isPageOpened() {
        return isElementExist(CREATE_MILESTONE_BUTTON);
    }

    @Override
    public boolean isCongratsPageOpened() {
        return false;
    }

    @Step("Click on milestone submenu")
    public void clickMilestoneSubmenu() {

        log.info("info");

        driver.findElement(MILESTONES_SUBMENU).click();
    }

    @Step("Click on the button to create new milestone")
    public void clickCreateMilestoneButton() {

        log.info("info");

        driver.findElement(CREATE_MILESTONE_BUTTON).click();
    }

    @Step("Enter the title for the milestone")
    public void enterMilestoneName(String releaseTitle) {

        log.info("info");

        new Input(driver, "Milestone name").write(releaseTitle);
    }

    @Step("Enter the description for the milestone")
    public void enterMilestoneDescription(String releaseDescription) {

        log.info("info");

        new Input(driver, "Description").write(releaseDescription);
    }

    @Step("Click on 'Create milestone' button")
    public void createNewMilestoneButtonClick() {

        log.info("info");

        driver.findElement(CREATE_NEW_MILESTONE_BUTTON).click();
    }

    @Step("Create base milestone")
    public void createBaseMilestone(String milestoneForTestRunName, String milestoneDescription) {

        log.info("info");

        clickMilestoneSubmenu();
        AllureUtils.takeScreenshot(driver);
        clickCreateMilestoneButton();
        AllureUtils.takeScreenshot(driver);
        enterMilestoneName(milestoneForTestRunName);
        AllureUtils.takeScreenshot(driver);
        enterMilestoneDescription(milestoneDescription);
        AllureUtils.takeScreenshot(driver);
        createNewMilestoneButtonClick();
        AllureUtils.takeScreenshot(driver);
        isPageOpened();
    }
}
