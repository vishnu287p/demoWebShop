package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{
	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//a[@class='account']")
	WebElement msgAccountDetails;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement clkLogout;
	
	public String getAccountDetails() {
		try {
			return (msgAccountDetails.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
		
	}
	public void clickLogout() {
		clkLogout.click();
	}
}
