package elements.inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RequiredInput extends BaseInput {

    String inputRequiredLocator = "//*[contains(@class,'required')][text()='%s']/ancestor::" +
            "div[contains(@class,'form-group')]//input[contains(@class,'form-control')]";

    public RequiredInput(WebDriver driver, String label) {
        super(driver, label);
    }

    public void write(String text) {
        System.out.println(String.format("Writing text '%s' into input with label %s", text, label));

        driver.findElement(By.xpath(String.format(inputRequiredLocator, label))).sendKeys(text);
    }
}
