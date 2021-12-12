package elements.inputs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class BaseInput {

    WebDriver driver;
    String label;
    String inputLocator = "//*[contains(@class,'required')][text()='%s']/ancestor::" +
            "div[contains(@class,'form-group')]//div[contains(@class,'ProseMirror toastui-editor-contents')]";

    public BaseInput(WebDriver driver, String label) {
        this.driver = driver;
        this.label = label;
    }

    public void write(String text) {
        System.out.println(String.format("Writing text '%s' into input with label %s", text, label));

        driver.findElement(By.xpath(String.format(inputLocator, label))).sendKeys(text);
    }
}
