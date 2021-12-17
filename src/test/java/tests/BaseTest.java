package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    ProjectPage projectPage;
    DefectPage defectPage;
    MilestonePage milestonePage;
    TestCasePage testCasePage;
    TestPlanPage testPlanPage;
    TestRunPage testRunPage;

    public static final String USER_LOGIN = "6870064@gmail.com";
    public static final String USER_PASSWORD = "qwe1122qwe";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
      //  chromeOptions.addArguments("--kiosk");
        driver = new ChromeDriver(chromeOptions);
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");
        //driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//Неявные ожидания
        driver.manage().window().maximize();

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
