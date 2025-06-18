package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Pages.LoginPage;
import Pages.PatientDashboardPage;
import Utils.TestDataUtil;

public class LoginTest extends BaseTest {
	LoginPage loginPage;
	PatientDashboardPage patientDashboardPage;
	@Test(priority=1)
	public void verifyAreAllLoginElementsVisible() {
		loginPage = new LoginPage(driver);
		patientDashboardPage=new PatientDashboardPage(driver);
		loginPage.areAllLoginElementsVisible();
	}
	@Test(dataProvider = "ValidloginData", dataProviderClass = TestDataUtil.class,description="Login with valid details")
	public void LoginWithValidDetails(String UserName,String Password) {
		loginPage = new LoginPage(driver);
		loginPage.VerifyLogin(UserName,Password);
		patientDashboardPage=new PatientDashboardPage(driver);
		patientDashboardPage.clickOnLogOutButton();
        String expectedURL = "https://qa-takehome.dtxplus.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "URL does not match");
	}
	
	@Test(dataProvider = "InValidLogin",dataProviderClass = TestDataUtil.class,description="Login with valid details")
	public void loginWithInValidDetails(String UserName,String Password) {
		loginPage = new LoginPage(driver);
		loginPage.VerifyLogin(UserName,Password);
		String actualErrorMessage=loginPage.alertHandle();
		String expectedErrorMessage="Invalid login";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage);
	}
}
