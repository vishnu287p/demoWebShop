package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage{
	
	public MainPage(WebDriver driver) {
		super(driver);
	}
    
	@FindBy(xpath = "//ul[@class='top-menu']//a[normalize-space()='Books']")
	WebElement lnk_topMenuBooks;
	
	public void click_booksLink() {
		lnk_topMenuBooks.click();
	}
}
