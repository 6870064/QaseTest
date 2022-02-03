package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JSExecutor {
    WebDriver driver;
    WebDriverWait wait;

    JavascriptExecutor js = ((JavascriptExecutor) driver);
}
