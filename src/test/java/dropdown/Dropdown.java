package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dropdown {

    WebDriver driver;
    String label;
    String defaultValue;
    String valueToClick;

    String defaultLocator = "//*[contains(@class,'control-label')][text()='%s']/ancestor::" +
            "div[contains(@class,'form-group')]//div[text()='%s']";
    String locatorToClick = "//div[text()='%s']";

    public Dropdown(WebDriver driver, String label, String defaultValue, String valueToClick) {
        this.driver = driver;
        this.label = label;
        this.defaultValue = defaultValue;
        this.valueToClick = valueToClick;
    }

    public void dropDownClick() throws InterruptedException {
        System.out.println(String.format("Clicking Dropdown titled '%s' with default value '%s' and choose value '%s'", label, defaultValue, valueToClick));

        driver.findElement(By.xpath(String.format(defaultLocator, label, defaultValue))).click();
        driver.findElement(By.xpath(String.format(locatorToClick, valueToClick))).click();
    }
}
