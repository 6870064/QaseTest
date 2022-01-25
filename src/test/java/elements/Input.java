package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {

    WebDriver driver;
    String label;
    String INPUT_VALUE_LOCATOR = "//label[text()='%s']/parent::div//input";

    public Input(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        //    System.out.println(String.format("Writing text '%s' into input with label %s", text, label));

        driver.findElement(By.xpath(String.format(INPUT_VALUE_LOCATOR, label))).sendKeys(text);
    }
}
