package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.BooksPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import testBase.BaseClass;

public class TC003_AddBooksToCart extends BaseClass{
	
	@Test
	public void addBooksToCart() {
		logger.info("*******TC002_LoginTest Started*******");
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		logger.info("Entering user Details....");
		LoginPage login = new LoginPage(driver);
		login.setEmail(p.getProperty("email"));
		login.setPassword(p.getProperty("valid_password"));
		login.clickLogin();
		logger.info("*****Clicking on Books link******");
		MainPage mp = new MainPage(driver);
		mp.click_booksLink();
		logger.info("*****Adding book to the cart*****");
		BooksPage booksPage = new BooksPage(driver);		
		int initialCartCount = booksPage.getcartQuantity();
		booksPage.addProductToCart("Health Book");
		logger.info("*****checking book quantity in the cart*****");
		int updatedCartCount = booksPage.getcartQuantity();
		
		if(updatedCartCount != initialCartCount + 1 ) {
			Assert.fail("The cart count did not update correctly after adding a product. Expected: " + (initialCartCount+1) + "but got" + updatedCartCount);
			logger.info("*****TC004_AddBooksToCart Test Case failed*****");
		}	
		logger.info("*****Finished TC004_AddBooksToCart Test Case*****");
	}

}
