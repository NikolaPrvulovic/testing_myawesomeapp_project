package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseURL = "https://vue-demo.daniel-avellaneda.com";
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected SignupPage signupPage;
    protected MessagePopUpPage messagePopUpPage;
    protected CitiesPage citiesPage;
    protected ProfilePage profilePage;

    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        loginPage = new LoginPage(driver, wait);
        navPage = new NavPage(driver, wait);
        signupPage = new SignupPage(driver, wait);
        messagePopUpPage = new MessagePopUpPage(driver, wait);
        citiesPage = new CitiesPage(driver, wait);
        profilePage = new ProfilePage(driver, wait);
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(this.baseURL);
    }


    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("dd-MM-yyyy__hh-mm-ss").format(new Date());
            Files.copy(file.toPath(), new File("screenshots/" + result.getName() +
                    " - " + timestamp + ".png").toPath());
        }
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}

