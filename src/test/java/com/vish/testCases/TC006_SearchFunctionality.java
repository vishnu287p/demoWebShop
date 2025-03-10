package com.vish.testCases;

import org.testng.annotations.Test;

import com.vish.pageObjects.HomePage;
import com.vish.pageObjects.LoginPage;
import com.vish.pageObjects.MainPage;
import com.vish.pageObjects.SearchPage;
import com.vish.testBase.BaseClass;

import junit.framework.Assert;

public class TC006_SearchFunctionality extends BaseClass {
	@Test(priority = 1)
	public void searchItem() {
		try {
			logger.info("*******TC004_SearchFunctionality valid searchItem Started*******");
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
			logger.info("*******Finished TC004_SearchFunctionality valid searchItem *******");
		} catch (Exception e) {
			logger.error("Error occurred in searchItem test: " + e.getMessage());
			Assert.fail("searchItem test failed due to exception.");
		}
	}

}
