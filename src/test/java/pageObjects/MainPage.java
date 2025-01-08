package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{
	//Constructor
	public MainPage(WebDriver driver) {
		super(driver);
	}
    
    //WebElement for Books link
	@FindBy(xpath = "//ul[@class='top-menu']//a[normalize-space()='Books']")
	WebElement lnk_topMenuBooks;
	
	//WebElements for search functionality
	@FindBy(id = "small-searchterms")
	WebElement txtSearchBox;
	
	@FindBy(xpath = "//input[@class='button-1 search-box-button']")
	WebElement btnSearch;
	
	//Action Method to click books link
	public void click_booksLink() {
		lnk_topMenuBooks.click();
	}
	
	//Action methods to search item
	public void searchItemName(String itemName) {
		txtSearchBox.sendKeys(itemName);
	}
	public void clickSearchbtn() {
		btnSearch.click();
	}
}
