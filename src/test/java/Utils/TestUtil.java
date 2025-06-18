package Utils;

import org.openqa.selenium.WebDriver;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestUtil {
	
    static Faker faker = new Faker();


    public static void waitForElementVisible(WebDriver driver, WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementClickable(WebDriver driver, WebElement element, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public static WebElement waitUntilElementVisible(WebDriver driver, WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated((By) element));
    }


    public static String takeScreenshot(WebDriver driver, String screenshotName) {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationPath = "screenshots/" + screenshotName + ".png";
        try {
            Files.createDirectories(new File("screenshots").toPath());
            File destFile = new File(destinationPath);
            Files.copy(srcFile.toPath(), destFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destinationPath;
    }
    
    public static String[] genrateUserRegistrationData() {
    	
    	String name=faker.name().firstName();
    	String email=faker.internet().emailAddress();
    	return new String[] {name,email};	
    }
    
    public static String[] genrateSignUpData() {
    	
    	String fullName = faker.name().fullName();
        String password = faker.internet().password(8, 15, true, true);
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String company = faker.company().name();
        String address = faker.address().streetAddress();
        String state = faker.address().state();
        String city = faker.address().city();
        String mobile = faker.phoneNumber().cellPhone().replaceAll("[^0-9]", "").substring(0, 10);
        
        return new String[] {fullName,password,firstName,lastName,company,address,state,city,mobile};
    }
    
    
    public static Map<String, String> generateFakePaymentData() {
        Map<String, String> paymentData = new HashMap<>();

        paymentData.put("name_on_card", faker.name().fullName());
        paymentData.put("card_number", faker.finance().creditCard().replaceAll("-", ""));
        paymentData.put("cvc", String.valueOf(faker.number().numberBetween(100, 999)));
        paymentData.put("expiry_month", String.format("%02d", faker.number().numberBetween(1, 12)));
        paymentData.put("expiry_year", String.valueOf(faker.number().numberBetween(2025, 2030)));

        return paymentData;
    }

}
