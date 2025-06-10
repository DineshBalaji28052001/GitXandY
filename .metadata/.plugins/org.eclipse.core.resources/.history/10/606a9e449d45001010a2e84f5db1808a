package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.CondirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class ErrorValidationTest extends BaseTest {

	@Test (groups = {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException {
		// String productName = "ZARA COAT 3";
		// LandingPage landingPage = launchApplication();

		landingPage.loginApplication("dinebala@gmail.com", "Dinebah@2001"); // As we are using inheritance, the methods
																			// in the parent class (Base Test -
																			// landingPage)is accessible

		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
		//driver.close();
	}
	
	

	@Test
	public void ProductErrorValidation() throws IOException 
	{
    String productName = "ZARA COAT 3";
    //LandingPage landingPage = launchApplication();

    ProductCatalogue productCatalogue = landingPage.loginApplication("dinesh2001@gmail.com", "Dinesh@2001"); // As we are using inheritance, the methods in the parent class (Base Test - landingPage)is accessible 
    
    List<WebElement> products = productCatalogue.getProductsList();
    productCatalogue.addProductToCart(productName);
    
    CartPage cartPage = productCatalogue.goToCartPage(); //Created an object in the CartPage -> goToCartPage() method itself
    
    Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
    Assert.assertFalse(match);
    
    driver.close();
    
}
}
