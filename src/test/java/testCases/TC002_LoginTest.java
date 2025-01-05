 package testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verifyLogin() {
		try {
		logger.info("*******TC002_LoginTest Started*******");
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		logger.info("Entering user Details....");
		LoginPage login = new LoginPage(driver);
		login.setEmail(p.getProperty("email"));
		login.setPassword(p.getProperty("valid_password"));
		login.clickLogin();
		logger.info("*****My Account details******");
		MyAccountPage myAccount = new MyAccountPage(driver);
		String accountDetails = myAccount.getAccountDetails();
		if(accountDetails.equals("vishnu2@gmail.com")) {
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
		logger.info("*****Finished TC002_LoginTest");
	}

}
