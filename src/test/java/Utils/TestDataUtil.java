package Utils;

import org.testng.annotations.DataProvider;

import Utils.ExcelReader;

public class TestDataUtil {
	
    @DataProvider(name = "ValidloginData")
    public static Object[][] getLoginData() {
            return ExcelReader.readExcelData("ValidLogin","/TestData/LoginData.xlsx");
        };
       
    @DataProvider(name = "InValidLogin")
    public static Object[][] getInValidLoginData() {
            return ExcelReader.readExcelData("InValidLogin","/TestData/LoginData.xlsx");
        };
        
     @DataProvider(name = "BookAppointmentData")
        public static Object[][] BookAppointmentData() {
                return ExcelReader.readExcelData("BookAppointmentData","/TestData/LoginData.xlsx");
            };
            
     @DataProvider(name = "InvalidBookAppointmentData")
        public Object[][] getInvalidBookAppointmentData() {
                return ExcelReader.readExcelData("AddPatientWithInvalidData","/TestData/AddPatientData.xlsx");
            };

    }
