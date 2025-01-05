package testCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	@Test(groups={"Regression", "Master"})
	public void verify_acccount_registration(){	
		try {
		logger.info("******TC001_AccountRegistrationTest started****** ");
		HomePage hp = new HomePage(driver);
		hp.clickRegister();
		logger.info("clicked on Register link");
		RegisterPage regpage = new RegisterPage(driver);
		logger.info("Entering Customer details");
		regpage.setFirstname(randomString().toUpperCase());
		regpage.setLastname(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		regpage.setPwd(p.getProperty("valid_password"));
		regpage.setConfirmPwd("Tester123@");
		regpage.clickRegister();

		logger.info("Validating confirmation message....");
		String actlMsg = regpage.getConfirmationMsg();
		if(actlMsg.equals("Your registration completed")) {
			
			Assert.assertTrue(true);
		}
		else {
			logger.error("********Test case failed*********");
			logger.debug("Debug Logs...");
			Assert.assertTrue(false);
		}
	//	Assert.assertEquals(actlMsg, "Your registration completed");
		}
		catch(Exception e) {
			
			Assert.fail();
		}
		logger.info("*****Finished TC001_AccountRegistrationTest test case******");
	}
}
