package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CustomInput {

    WebDriver driver;
    String locator;
    String value;
    String CUSTOM_LOCATOR = "//input[@name='%s[%s]']";

    public CustomInput(WebDriver driver, String locator, String value) {
        this.driver = driver;
        this.locator = locator;
        this.value = value;
    }

    public void write(String text) {
        System.out.println(String.format("Writing text '%s' into input with label %s", text, locator, value));

        driver.findElement(By.xpath(String.format(CUSTOM_LOCATOR, locator, value))).sendKeys(text);
    }
}
