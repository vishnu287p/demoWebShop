package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid - login success - test pass
Data is valid - login failed - test fail

Data is invalid - login success - test fail
Data is invalid -- login failed - test pass
*/

public class LoginDDT extends BaseClass {
	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class)
	public void verifyLoginDDT(String email, String pwd, String exp) {
		try {
		logger.info("*******TC002_LoginTest Started*******");
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		logger.info("Entering user Details....");
		LoginPage login = new LoginPage(driver);
		Thread.sleep(2000);
		login.setEmail(email);
		login.setPassword(pwd);
		login.clickLogin();
		logger.info("*****My Account details******");
		MyAccountPage myAccount = new MyAccountPage(driver);
		String accountDetails = myAccount.getAccountDetails();
		if(accountDetails.equals("vishnu2@gmail.com")) {
			myAccount.clickLogout();
			Assert.assertTrue(true);
		}
		else {
			logger.error("****Test Case Failed******");
			logger.debug("****Debug Logs****");
			Assert.assertFalse(false);
		}
	}
		catch(Exception e) {
			Assert.fail();
		}
		logger.info("*****Finished TC003_LoginDDT");
	}
}
