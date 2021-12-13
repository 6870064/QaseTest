package pages;

import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pages.ProjectPage.PROJECT_URL;

public class MilestonePage extends BasePage {

    public static final By MILESTONES_DEFECTS = By.xpath("//*[text()='Milestones']");
    public static final By CREATE_MILESTONE_BUTTON = By.id("createButton");
    public static final By MILESTONE_NAME = By.id("title");
    public static final By DESCRIPTION_FIELD = By.xpath("//div[@class='ProseMirror toastui-editor-contents']");
    public static final By CREATE_NEW_MILESTONE_BUTTON = By.xpath("//div[@class='btn btn-primary me-3 save-button']");

    public MilestonePage(WebDriver driver) {
        super(driver);
    }

    public void projectOpen(){
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

    public void newMilestoneCreated(String releaseTitle, String releaseDescription){
    driver.findElement(MILESTONES_DEFECTS).click();
    driver.findElement(CREATE_MILESTONE_BUTTON).click();
    driver.findElement(MILESTONE_NAME).sendKeys(releaseTitle);
    driver.findElement(DESCRIPTION_FIELD).sendKeys(releaseDescription);
    driver.findElement(CREATE_NEW_MILESTONE_BUTTON).click();
    }
}
