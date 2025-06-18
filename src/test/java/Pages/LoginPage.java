package Pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;

import Utils.ExcelReader;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath="//h2[text()='Login']	")
    WebElement LoginHeading;
    
    @FindBy(css = "#username")
    WebElement userName;

    @FindBy(css = "#password")
    WebElement password;

    @FindBy(css = "#login-form button")
    WebElement loginButton;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public boolean areAllLoginElementsVisible() {
        return LoginHeading.isDisplayed() &&
               userName.isDisplayed() &&
               password.isDisplayed();
    }
    
    public void VerifyLogin(String UserName,String Password) {
    	userName.clear();
    	userName.sendKeys(UserName);
    	password.clear();
    	password.sendKeys(Password);
    	loginButton.click();
    }
    
    public String alertHandle() {
    	Alert alert=driver.switchTo().alert();
    	String ErrorMessge=alert.getText();
    	alert.accept();
    	return ErrorMessge;
    }
   
}