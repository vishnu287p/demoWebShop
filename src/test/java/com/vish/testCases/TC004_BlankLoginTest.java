package com.vish.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vish.pageObjects.HomePage;
import com.vish.pageObjects.LoginPage;
import com.vish.testBase.BaseClass;

public class TC004_BlankLoginTest extends BaseClass{
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
