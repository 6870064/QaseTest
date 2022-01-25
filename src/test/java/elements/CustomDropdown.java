package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomDropdown {

    WebDriver driver;
    String label;
    String defaultValue;
    String valueToClick;

    String DROPDOWN_LOCATOR = "//label[@class='me-sm-2'][text()='%s']/parent::div/div[contains(@class, 'container')]";
    String DROPDOWN_VALUE = "//*[text()='%s']";

    public CustomDropdown(WebDriver driver, String label, String defaultValue, String valueToClick) {
        this.driver = driver;
        this.label = label;
        this.defaultValue = defaultValue;
        this.valueToClick = valueToClick;
    }

    public void dropDownClick() {
        // System.out.println(String.format("Clicking Dropdown titled '%s' with default value '%s' and choose value '%s'", label, defaultValue, valueToClick));

        driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, label, defaultValue))).click();
        driver.findElement(By.xpath(String.format(DROPDOWN_VALUE, valueToClick))).click();
    }

}
