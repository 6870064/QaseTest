package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.*;
import utils.WebDriver_Initializer;
import tests.base.TestListener;
import utils.PropertyReader;

import java.util.concurrent.TimeUnit;

@Log4j2
@Listeners(TestListener.class)
public abstract class BaseTest {

    private final WebDriver_Initializer webDriverInitializer = WebDriver_Initializer.getInstance();
    public String loginFieldTitle = "Email";
    public String passwordFieldTitle = "Password";
    protected PropertyReader propertyReader = new PropertyReader("src/test/resources/configuration.properties");
    protected final String USER_LOGIN = System.getProperty("username", propertyReader.getPropertyValueByKey("username"));
    protected final String USER_PASSWORD = System.getProperty("username", propertyReader.getPropertyValueByKey("password"));
    WebDriver driver;
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    ProjectPage projectPage = new ProjectPage(driver);
    DefectPage defectPage = new DefectPage(driver);
    MilestonePage milestonePage = new MilestonePage(driver);
    TestCasePage testCasePage = new TestCasePage(driver);
    TestPlanPage testPlanPage = new TestPlanPage(driver);
    TestRunPage testRunPage = new TestRunPage(driver);

    @Parameters({"browser"})
    @BeforeMethod(description = "Open browser")
    public void setUp(@Optional("chrome") String browser) {
        driver = webDriverInitializer.driverInitialization();

        if (browser.equals("chrome")) {

            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//Неявные ожидания
            driver.manage().window().maximize();
            /**
             * --headless - запуск тестов в браузере без UI
             */
            if (propertyReader.getPropertyValueByKey("headless").equals("true")) {
                chromeOptions.addArguments("--headless");
            }

        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
    }

    @AfterMethod(alwaysRun = true, description = "Close browser")
    public void tearDown() {
        webDriverInitializer.closeDriver();
//        if (driver != null) {
//            driver.quit();
//        }
    }
}
