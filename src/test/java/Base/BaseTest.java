package Base;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import Utils.ConfigReader;
import Utils.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import Pages.LoginPage;
import Pages.PatientDashboardPage;

public class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    ConfigReader configReader;
    String url;
    
    @BeforeSuite
    public void setupExtentReport() {
        ExtentReportManager.setupReport();
    }
    
    @BeforeClass
    public void setUp() {
    	WebDriverManager.chromedriver().setup(); // Optional but safe
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        configReader = new ConfigReader();
        url = configReader.getProperty("url");
        driver.get(url);
    }
    
   @AfterClass
   public void quit() {
	   driver.quit();
   }
   
    @AfterSuite
    public void tearDownExtentReport() {
        ExtentReportManager.flushReport();
    }
    
}