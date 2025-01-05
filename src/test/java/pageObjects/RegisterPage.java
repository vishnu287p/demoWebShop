package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
    
	@FindBy(id="gender-male")
	WebElement radioGender_Male;
	
	@FindBy(id = "FirstName")
	WebElement txtfirstName;
	
	@FindBy(id="LastName")
	WebElement txtlastname;
	
	@FindBy(id="Email")
	WebElement txtemail;
	
	@FindBy(id="Password")
	WebElement txtpassword;
	
	@FindBy(id="ConfirmPassword")
	WebElement txtCfmPassword;
	
	@FindBy(id="register-button")
	WebElement btnRegister;
	
	
	@FindBy(xpath = "//div[@class='result']")
	WebElement msgConfirmation;
	
	public void setGender() {
		radioGender_Male.click();
	}
	public void setFirstname(String fname) {
		txtfirstName.sendKeys(fname);
	}
	public void setLastname(String lname) {
		txtlastname.sendKeys(lname);
	}
	public void setEmail(String email) {
		txtemail.sendKeys(email);
	}
	public void setPwd(String pwd) {
		txtpassword.sendKeys(pwd);
	}
	public void setConfirmPwd(String CnfmPwd) {
		txtCfmPassword.sendKeys(CnfmPwd);
	}
	
	public void clickRegister() {
		btnRegister.click();
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
}
