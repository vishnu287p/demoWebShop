package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends BasePage{
	
	public BooksPage(WebDriver driver) {
		 super(driver);
	 }
	 //WebElements for products & cart
    @FindBy(xpath = "//h2[@class='product-title']")
    List<WebElement> bookItems;
    
    @FindBy(xpath = "//span[@class='cart-qty']")
    WebElement cartQuantity;
    
    @FindBy(xpath = "//input[@value='Add to cart']")
    WebElement btnAddToCart;
    
    //Action method to get the current cart quantity
    public int getcartQuantity() {
    	String cartQtyText = cartQuantity.getText(); 
    	return Integer.parseInt(cartQtyText.replace("(","").replace(")",""));
    }
    
    //Action method: Add a product to the cart by name
    public boolean addProductToCart(String bookName) {
    	for(int i=1; i<bookItems.size(); i++) {
    		String name = bookItems.get(i).getText();
    		if(name.equalsIgnoreCase(bookName)) {
    			btnAddToCart.click(); // use same index to click Add To Cart button
    			return true; // Product found and added
    		}
    	}
    	return false; //product not found
    }
	 
	 
}
