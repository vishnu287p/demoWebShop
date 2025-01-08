package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//div[@class='page-title']/h1")
	WebElement titleSearchPage;
	
	@FindBy(xpath="//h2[@class='product-title']")
	WebElement searchedItem;
	
	public String getSearchPageTitle() {
		return titleSearchPage.getText();
	}
		
	public String getProductTile() {
		return searchedItem.getText();
	}
}
