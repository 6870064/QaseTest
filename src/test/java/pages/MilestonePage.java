package pages;

import elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.ProjectPage.PROJECT_URL;

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


    public void clickMilestoneSubmenu() {
        driver.findElement(MILESTONES_SUBMENU).click();
    }

    public void clickCreateMilestoneButton() {
        driver.findElement(CREATE_MILESTONE_BUTTON).click();
    }

    public void enterMilestoneName(String releaseTitle) {
        new Input(driver, "Milestone name").write(releaseTitle);
    }

    public void enterMilestoneDescription(String releaseDescription) {
        new Input(driver, "Description").write(releaseDescription);
    }

    public void createNewMilestoneButtonClick() {
        driver.findElement(CREATE_NEW_MILESTONE_BUTTON).click();
    }

    public void createBaseMilestone(String milestoneForTestRunName, String milestoneDescription) {
        clickMilestoneSubmenu();
        clickCreateMilestoneButton();
        enterMilestoneName(milestoneForTestRunName);
        enterMilestoneDescription(milestoneDescription);
        createNewMilestoneButtonClick();
        isPageOpened();
    }

}
