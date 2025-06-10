package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.OrderPage;

public class AbstractComponents {

	WebDriver driver;

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".btn.btn-custom[routerlink='/dashboard/cart")
	WebElement cartHeader;
	
	@FindBy(css=".btn.btn-custom[routerlink='/dashboard/myorders']")
	WebElement orderHeader;
	
	

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForWebElementToAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	
	public void waitForElementToDisAppear(WebElement findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		wait.until(ExpectedConditions.invisibilityOf(findBy));
	}
	
	public CartPage goToCartPage() {
		CartPage cartPage = new CartPage(driver);
		cartHeader.click();
		return cartPage; 
	}
	
	public OrderPage goToOrdersPage()
	{
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
	}
	

}
