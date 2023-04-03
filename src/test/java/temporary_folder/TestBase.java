package temporary_folder;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import pages.*;

public class TestBase implements GlobalActions {
    public static String headlessMode = System.getProperty("headlessMode", "false");
    public static String debugMode = System.getProperty("debugMode", "false");
    public static String isMobileBrowser = System.getProperty("mobile", "false");
    public static String mobileDevice = System.getProperty("device", "iPad Pro");

    private static final String PROPERTY_PATH = getPropertyPath();
    public static Properties_Initializer properties_initializer = Properties_Initializer.getInstance(PROPERTY_PATH);
    private final WebDriver_Initializer webDriverInitializer = WebDriver_Initializer.getInstance();
    public static WebDriver driver;
    public static JavascriptExecutor JSExecutor;
    public static Actions ActionBuilder;

    //Page Factory block
    protected static SignIn_Page SignIn_Page = PageFactory.initElements(driver, SignIn_Page.class);

    ///OLD
    protected static General_Page General_Page = PageFactory.initElements(driver, General_Page.class);

    protected void startTest() {
        driver = webDriverInitializer.driverInitialization();
        JSExecutor = (JavascriptExecutor) TestBase.driver;
        ActionBuilder = new Actions(driver);
    }
    protected void endTest() {
        webDriverInitializer.closeDriver();
        JSExecutor = null;//delete object
        ActionBuilder = null;//delete object
    }
    private static String getPropertyPath(){
        ConsoleLogger.displayOSVersionInConsole();
        ConsoleLogger.showAllSettingsForTests();
        if (System.getProperty("os.name").equalsIgnoreCase("mac os x")){
            return "src/main/resources/local_env.properties";
        } else {
            return "src/main/resources/ci_env.properties";
        }
    }
}