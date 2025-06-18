package Pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.ElementUtil;

import Base.BaseTest;
import Utils.ElementUtil;

public class PatientDashboardPage {
	WebDriver driver;
    ElementUtil util;
    JavascriptExecutor js;

	public PatientDashboardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        util = new ElementUtil(driver);
    }

	@FindBy(xpath = "//h2[normalize-space()='Login']")
    public WebElement loginHeading;

	@FindBy(xpath = "//h2[normalize-space()='Patients']")
    public WebElement patientsHeading;
	
    @FindBy(id = "logout")
    public WebElement logoutButton;

    @FindBy(id = "add-patient-btn")
    public WebElement addPatientButton;

    @FindBy(id = "patients-table")
    public WebElement patientsTable;

    @FindBy(xpath = "//table[@id='patients-table']/tbody")
    public WebElement patientsTableBody;

    @FindBy(id = "mrn")
    public WebElement mrnInput;

    @FindBy(id = "firstName")
    public WebElement firstNameInput;

    @FindBy(id = "lastName")
    public WebElement lastNameInput;

    @FindBy(id = "dob")
    public WebElement dobInput;

    @FindBy(id = "discharge")
    public WebElement dischargeInput;

    @FindBy(id = "phone")
    public WebElement phoneInput;

    @FindBy(id = "language")
    public WebElement languageDropdown;

    @FindBy(id = "timezone")
    public WebElement timezoneDropdown;
    
    @FindBy(xpath="//table[@id='patients-table']/tbody/tr/td[1]")
    public List<WebElement> mrnColumnCells;
    
    

    @FindBy(xpath = "//form[@id='patient-form']//button[@type='submit']")
    public WebElement submitPatientButton;

    @FindBy(id = "add-patient-form")
    public WebElement addPatientForm;
    
    public void clickOnLogOutButton() {
        js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", logoutButton);
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        js.executeScript("arguments[0].click();", logoutButton);
    }
    
    public boolean areAllDashboardElementsVisible() {
    	return loginHeading.isDisplayed()&&
    	patientsHeading.isDisplayed()&&
    	logoutButton.isDisplayed()&&
    	patientsTable.isDisplayed()&&
    	addPatientButton.isDisplayed();
    }
    
    public boolean bookAppointMentWithValidDetails(String mrnNumber,String fristName,String lastName,String dobdateValue,String dateTimeValue,String phoneNumber,String language,String timeZone ) {
    	addPatientButton.click();
    	mrnInput.sendKeys(mrnNumber);
    	firstNameInput.sendKeys(fristName);
    	lastNameInput.sendKeys(lastName);
    	dobInput.sendKeys(dobdateValue);
    	dischargeInput.sendKeys(dateTimeValue);
    	phoneInput.sendKeys(phoneNumber);   
    	util.selectDropdownByVisibleText(languageDropdown,language);
    	util.selectDropdownByVisibleText(timezoneDropdown, timeZone);
    	submitPatientButton.click();
    	for (WebElement cell : mrnColumnCells) {
            if (cell.getText().trim().equals(mrnNumber)) {
                return true;
            }
        }
        return false;
    }
    
    public void bookAppointMentWithInValidDetails(String mrnNumber,String fristName,String lastName,String dobdateValue,String dateTimeValue,String phoneNumber,String language,String timeZone ) {
    	addPatientButton.click();
    	mrnInput.sendKeys(mrnNumber);
    	firstNameInput.sendKeys(fristName);
    	lastNameInput.sendKeys(lastName);
    	dobInput.sendKeys(dobdateValue);
    	dischargeInput.sendKeys(dateTimeValue);
    	phoneInput.sendKeys(phoneNumber);   
    	util.selectDropdownByVisibleText(languageDropdown,language);
    	util.selectDropdownByVisibleText(timezoneDropdown, timeZone);
    	submitPatientButton.click();
    	js = (JavascriptExecutor) driver;
    	js.executeScript("location.reload()");
    }
    
    public String getEmptyMrndErroeMessage() {
    	js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",mrnInput);    }
    
    public String getEmptyFristNmaeErroeMessage1() {
    	js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",firstNameInput);    }
    

    public String getEmptyLastNameErroeMessage1() {
    	js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",lastNameInput);    }
    

    public String getEmptydobInputErroeMessage1() {
    	js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",dobInput);    }
    

    public String getEmptydischargeInputErroeMessage1() {
    	js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",dischargeInput);    }
    

    public String getEmptyEmailErroeMessage1() {
    	js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;",firstNameInput);    }   
}
    



