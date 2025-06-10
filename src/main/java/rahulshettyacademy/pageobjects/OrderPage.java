package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents{
	
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//tbody/tr/td[2]")
	List<WebElement> productTitles;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
//	// Verify if the product is in the cart
//    List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
//    Boolean match = cartProducts.stream().anyMatch(cartproduct -> cartproduct.getText().equalsIgnoreCase(productName));
//    Assert.assertTrue(match, "Product not present in the cart");
    
    
    public boolean VerifyOrderDisplay(String productName) {
    	Boolean match = productTitles.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
    	return match;
    }
    
    public CheckoutPage goToCheckout() {
    	checkoutEle.click();
    	return new CheckoutPage(driver);
    }

}
