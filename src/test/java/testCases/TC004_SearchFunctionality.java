package testCases;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC004_SearchFunctionality extends BaseClass {
	@Test
	public void searchItem() {
		logger.info("*******TC002_LoginTest Started*******");
		HomePage hp = new HomePage(driver);
		hp.clickLogin(); 
		logger.info("Entering user Details....");
		LoginPage login = new LoginPage(driver);
		login.setEmail(p.getProperty("email"));
		login.setPassword(p.getProperty("valid_password"));
		login.clickLogin();
		
		logger.info("Entered item name & clicked on Search Button");
		MainPage mainpage = new MainPage(driver);
		mainpage.searchItemName("laptop");
		mainpage.clickSearchbtn();
		
		logger.info("Asserts on Search Page title & search Product Item");
		SearchPage searchpage = new SearchPage(driver);
		String actualTitle = searchpage.getSearchPageTitle();
		Assert.assertEquals(actualTitle, "Search");
		String actualSearchTxt = searchpage.getProductTile();
		Assert.assertEquals(actualSearchTxt, "14.1-inch Laptop");
		logger.info("*******Finished TC004_SearchFunctionality*******");
		
	}
}
