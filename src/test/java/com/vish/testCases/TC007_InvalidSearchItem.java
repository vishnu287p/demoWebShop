package com.vish.testCases;

import org.testng.annotations.Test;

import com.vish.pageObjects.MainPage;
import com.vish.pageObjects.SearchPage;
import com.vish.testBase.BaseClass;

import junit.framework.Assert;

public class TC007_InvalidSearchItem extends BaseClass{
	@Test(priority = 2)
	public void invalidSearchItem() {
		logger.info("*******TC004_SearchFunctionality Invalid searchItem Started*******");

		logger.info("Entered invlaid item name & clicked on Search Button");
		MainPage mainpage = new MainPage(driver);
		mainpage.searchItemName("protein");
		mainpage.clickSearchbtn();

		logger.info("Asserts on Search Page title & search Invalid Product Item");
		SearchPage searchpage = new SearchPage(driver);
		String actualTitle = searchpage.getSearchPageTitle();
		Assert.assertEquals(actualTitle, "Search");
		String actualNoResultsMessage = searchpage.getNoResultsMessage();
		Assert.assertEquals(actualNoResultsMessage, "No products were found that matched your criteria.");
		logger.info("*******Finished TC004_SearchFunctionality Invalid searchItem *******");
	}
}
