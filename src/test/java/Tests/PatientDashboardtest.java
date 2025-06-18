package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;	
import Base.BaseTest;
import Pages.LoginPage;
import Pages.PatientDashboardPage;
import Utils.TestDataUtil;

public class PatientDashboardtest extends BaseTest {
	
	LoginPage loginPage;
    PatientDashboardPage patientDashboardPage;

	@Test(dataProvider = "ValidloginData", dataProviderClass = TestDataUtil.class,description="Login with valid details")
	public void verifyareAllDashboardElementsVisible(String userName,String Password) {
		loginPage = new LoginPage(driver);
		patientDashboardPage=new PatientDashboardPage(driver);
		loginPage.VerifyLogin(userName, Password);
		patientDashboardPage.areAllDashboardElementsVisible();		
	}
	
	@Test(dataProvider = "BookAppointmentData", dataProviderClass = TestDataUtil.class)
	public void testBookAppointmentWithValidData(String userName,String password,String mrn,String firstName,String lastName,String dob,
		    String dischargeDateTime,String phoneNumber,String language,String timeZone) {
		loginPage = new LoginPage(driver);
		patientDashboardPage=new PatientDashboardPage(driver);
		loginPage.VerifyLogin(userName, password);	    
		boolean isPresent =patientDashboardPage.bookAppointMentWithValidDetails(mrn,firstName,lastName,dob,dischargeDateTime,phoneNumber,language,
				timeZone );
        Assert.assertTrue(isPresent, "MRN " + mrn + " not found in the patient table.");
		patientDashboardPage.clickOnLogOutButton();
	}
	
	@Test(dataProvider = "InvalidBookAppointmentData", dataProviderClass = TestDataUtil.class)
	public void testBookAppointmentNegativeScenarios(String userName,String password,String mrn,String firstName,String lastName,String dob,String dischargeDateTime,
	    String phoneNumber,String language,String timeZone) {
	    loginPage = new LoginPage(driver);
	    patientDashboardPage = new PatientDashboardPage(driver);
	    loginPage.VerifyLogin(userName, password);
	    patientDashboardPage.bookAppointMentWithInValidDetails(mrn, firstName, lastName, dob, dischargeDateTime, phoneNumber, language, timeZone);
		patientDashboardPage.clickOnLogOutButton();
	}

}
