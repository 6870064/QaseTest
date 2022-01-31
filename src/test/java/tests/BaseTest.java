package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.*;
import tests.base.TestListener;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public abstract class BaseTest {

    public static final String USER_LOGIN = "6870064@gmail.com";
    public static final String USER_PASSWORD = "qwe1122qwe";

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ProjectPage projectPage;
    DefectPage defectPage;
    MilestonePage milestonePage;
    TestCasePage testCasePage;
    TestPlanPage testPlanPage;
    TestRunPage testRunPage;


    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(@Optional("chrome") String browser) {

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//Неявные ожидания
            driver.manage().window().maximize();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }

        loginPage = new LoginPage(driver); // и перечислять все последующие Pages так же туть
        homePage = new HomePage(driver);
        projectPage = new ProjectPage(driver);
        defectPage = new DefectPage(driver);
        milestonePage = new MilestonePage(driver);
        testCasePage = new TestCasePage(driver);
        testPlanPage = new TestPlanPage(driver);
        testRunPage = new TestRunPage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
