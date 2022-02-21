package elements;

import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class Dropdown {

    WebDriver driver;
    String label;
    String defaultValue;
    String valueToClick;

    String DROPDOWN_LOCATOR = "//label[@class='control-label'][text()='%s']/parent::div/div[contains(@class, 'container')]";
    String DROPDOWN_VALUE = "//*[contains(@id, 'react-select') and contains(text(), '%s')]";

    public Dropdown(WebDriver driver, String label, String defaultValue, String valueToClick) {
        this.driver = driver;
        this.label = label;
        this.defaultValue = defaultValue;
        this.valueToClick = valueToClick;
    }

    public void dropDownClick() {

        log.debug("debug");

        driver.findElement(By.xpath(String.format(DROPDOWN_LOCATOR, label, defaultValue))).click();
        driver.findElement(By.xpath(String.format(DROPDOWN_VALUE, valueToClick))).click();
    }
}
