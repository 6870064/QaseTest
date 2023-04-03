package temporary_folder;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

public class WebDriver_Initializer {

    private static WebDriver driver;
    public static WebDriverWait waitUntil;
    private static WebDriver_Initializer instance;

    public static WebDriver_Initializer getInstance() {
        if (instance == null) {
            instance = new WebDriver_Initializer();
        }
        return instance;
    }

    public WebDriver driverInitialization() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(setOptionsForChromeDriver());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(TestBase.properties_initializer.getIMPLICITLY_WAIT()), TimeUnit.SECONDS);
        waitUntil = new WebDriverWait(driver, Integer.parseInt(TestBase.properties_initializer.getWAIT_UNTIL()));
        return driver;
    }

    public void closeDriver() {
        driver.quit();
    }

    private ChromeOptions setOptionsForChromeDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        if (TestBase.headlessMode.equals("false")) {
            chromeOptions.setHeadless(false);
        } else if (TestBase.headlessMode.equals("true")) {
            chromeOptions.setHeadless(true);
        }
        if (TestBase.isMobileBrowser.equals("true")) {
            Map<String, String> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceName", TestBase.mobileDevice);
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        }
        if (TestBase.debugMode.equals("true")) {
            LoggingPreferences logPrefs = new LoggingPreferences();
            logPrefs.enable(LogType.BROWSER, Level.ALL);
            chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        }
        return chromeOptions;
    }
}