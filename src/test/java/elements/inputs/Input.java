package elements.inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input extends BaseInput {

    String inputLocator = "//*[contains(@class,'required')][text()='%s']/ancestor::" +
            "div[contains(@class,'form-group')]//div[contains(@class,'ProseMirror toastui-editor-contents')]";

    public Input(WebDriver driver, String label) {
        super(driver, label);
    }

    public void write(String text) {
        System.out.println(String.format("Writing text '%s' into input with label %s", text, label));

        driver.findElement(By.xpath(String.format(inputLocator, label))).sendKeys(text);
    }
}
