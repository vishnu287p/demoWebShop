package com.vish.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vish.pageObjects.HomePage;
import com.vish.pageObjects.LoginPage;
import com.vish.testBase.BaseClass;

public class TC003_InvalidLoginTest extends BaseClass{
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
}
