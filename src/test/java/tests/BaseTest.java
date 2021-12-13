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

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk");
        driver = new ChromeDriver(chromeOptions);
        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--start-maximized");
        //driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);//Неявные ожидания

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

// тесты

// 1) validUserLogin +1
// 2) createNewProject 2+
// 3) createNewProject и удаление проекта
// 4) поиск проекта
// 5) поиск и удаление существующего проекта
// 6) создание нового тест кейса
// 7 создание нового тест сьюита
// 8) создание нового дефекта в существующем проекте 3+
// 9 создание нового тест плана



//именование бранчей:
//feature/ITA-1-page-object
//bugfix/ITA-2-npe-fix - фиксим баг или добавляем фичу. Номер тикета. Краткое описание маленькими буквами через тире

//TODO
// Что должно быть во фреймворке:
//- Минимум 10 тестов
//        - Page Object
//        - TestNG - запуск в параллели, ретрай, TestListener
//        - Allure - скриншотинг и steps pattern
//        - CircleCI интеграция
//        - API тесты

/*
git branch *feature/8-tests
git add .
git status
git tag v1.5
git commit -am ' text of message'
git push
 */

//https://javarush.ru/quests/lectures/questmultithreading.level02.lecture06