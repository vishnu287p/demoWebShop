package testCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.BooksPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MainPage;
import testBase.BaseClass;

public class TC004_AddBooksToCart extends BaseClass{
	
	@Test
	public void addBooksToCart() {
		
		HomePage hp = new HomePage(driver);
		hp.clickLogin();
		LoginPage login = new LoginPage(driver);
		login.setEmail(p.getProperty("email"));
		login.setPassword(p.getProperty("valid_password"));
		login.clickLogin();
		MainPage mp = new MainPage(driver);
		mp.click_booksLink();
		BooksPage booksPage = new BooksPage(driver);	
		int initialCartCount = booksPage.getcartQuantity();
		booksPage.addProductToCart("Health Book");
		int updatedCartCount = booksPage.getcartQuantity();
		
		if(updatedCartCount != initialCartCount + 1 ) {
			Assert.fail("The cart count did not update correctly after adding a product. Expected: " + (initialCartCount+1) + "but got" + updatedCartCount);
		}	
		
	}

}
