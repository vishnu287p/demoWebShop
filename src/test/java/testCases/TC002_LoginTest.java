 package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


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
		logger.info("*****Finished TC002_LoginTest valid case");
	}
	
	@Test(groups={"Sanity","Master"})
	public void invalidLogin() {
		logger.info("*****TC002_LoginTest invlaid case Started*****");
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		logger.info("Entering Invalid user Details....");
		LoginPage login = new LoginPage(driver);
		login.setEmail(p.getProperty("email"));
	    login.setPassword(p.getProperty("invalid_password"));
	    login.clickLogin();
	    String expected_errmsg = "Login was unsuccessful. Please correct the errors and try again.";
	    String expected_InvalidCreds_errmsg = "The credentials provided are incorrect";
	    
	    if(login.checkErrorMsg().equals(expected_errmsg) && login.checkPrimaryErrorMsg().equals(expected_InvalidCreds_errmsg)){
	    	Assert.assertTrue(true);
	    }
	    else{
			logger.error("****Test Case Failed******");
			logger.debug("****Debug Logs****");
	    	Assert.assertFalse(false);
	    }	    
	    logger.info("*****Finished TC002_LoginTest Invalid case*****");
	}
	@Test(groups={"Sanity","Master"})
	public void blankLogin() {
		logger.info("*****TC002_LoginTest Blank case Started*****");
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		logger.info("Entering Invalid user Details....");
		LoginPage login = new LoginPage(driver);
		login.clickLogin();
	    String expected_errmsg = "Login was unsuccessful. Please correct the errors and try again.";
	    String expected_blankLogin_errmsg = "No customer account found";
	    
	    if(login.checkErrorMsg().equals(expected_errmsg) && login.checkPrimaryErrorMsg().equals(expected_blankLogin_errmsg)){
	    	Assert.assertTrue(true);
	    }
	    else{
			logger.error("****Test Case Failed******");
			logger.debug("****Debug Logs****");
	    	Assert.assertFalse(false);
	    }	    
	    logger.info("*****Finished TC002_LoginTest Blank case*****");
	}

}
