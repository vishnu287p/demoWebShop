package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id ="Email")
	WebElement txtEmail;
	
	@FindBy(id = "Password")
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Log in']")
	WebElement btnLogin;
	
	@FindBy(xpath = "//div[@class='validation-summary-errors']/span")
	WebElement errormsg;
	
	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void clickLogin() {
		btnLogin.click();
	}
	public String checkErrorMsg() {
		String expErr = errormsg.getText();
		return expErr;
		
	}
}
