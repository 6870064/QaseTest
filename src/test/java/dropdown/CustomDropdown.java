package dropdown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomDropdown {

    WebDriver driver;
    String label;
    String defaultValue;
    String valueToClick;
    String defaultLocator = "//*[contains(@class,'me-sm-2')][text()='%s']/ancestor::" +
            "div[contains(@class,'col-sm-12 col-xs-12')]//div[text()='%s']";
    String locatorToClick = "//div[text()='%s']";

    public CustomDropdown(WebDriver driver, String label, String defaultValue, String valueToClick) {
        this.driver = driver;
        this.label = label;
        this.defaultValue = defaultValue;
        this.valueToClick = valueToClick;
    }

    public void dropDownClick() {
        System.out.println(String.format("Clicking Dropdown titled '%s' with default value '%s' and choose value '%s'", label, defaultValue, valueToClick));

        driver.findElement(By.xpath(String.format(defaultLocator, label, defaultValue))).click();
        driver.findElement(By.xpath(String.format(locatorToClick, valueToClick))).click();
    }
}
