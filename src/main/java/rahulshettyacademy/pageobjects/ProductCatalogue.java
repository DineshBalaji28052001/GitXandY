package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{

	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		super(driver); // to send this driver to parent class (AbstractComponents)
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//PageFactory
	@FindBy(css="div.row div.mb-3")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	By productsBy = By.cssSelector("div.row div.mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By toastMessage = By.cssSelector("#toast-container");
	
	
	public List<WebElement> getProductsList() {
		waitForElementToAppear(productsBy);
		return products;
	}
	
//	 // Search for the particular product
//    WebElement prod = products.stream().filter(product -> 
//    product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
	
	// Search for the particular product
	public WebElement getProductByName(String productName) {
		WebElement actualProduct = getProductsList().stream().filter(product -> 
        product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return actualProduct;
	}
	
	// Click the 'Add To Cart' button
	// Wait until the 'Add to cart' confirmation message appears
	public void addProductToCart(String productName) {
		WebElement actualProduct = getProductByName(productName);
		waitForElementToAppear(addToCart);
		actualProduct.findElement(addToCart).click();
		waitForElementToAppear(toastMessage);
		waitForElementToDisAppear(spinner);
	}
}











//Search for the particular product
//WebElement prod = products.stream().filter(product -> 
//product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
//
//// Click the 'Add To Cart' button
//prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
//
//// Wait until the 'Add to cart' confirmation message appears
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));


