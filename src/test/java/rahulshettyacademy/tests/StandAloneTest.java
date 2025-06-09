package rahulshettyacademy.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.CondirmationPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;

public class StandAloneTest extends BaseTest {
	
	//String productName = "ZARA COAT 3";

		@Test (dataProvider = "getData", groups = {"Purchase"})
		public void SubmitOrder(HashMap<String, String> input) throws IOException 
		{
        
        //LandingPage landingPage = launchApplication();

        ProductCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password")); // As we are using inheritance, the methods in the parent class (Base Test - landingPage)is accessible 
        
        List<WebElement> products = productCatalogue.getProductsList();
        productCatalogue.addProductToCart(input.get("productName"));
        
        CartPage cartPage = productCatalogue.goToCartPage(); //Created an object in the CartPage -> goToCartPage() method itself
        
        Boolean match = cartPage.VerifyProductDisplay(input.get("productName"));
        Assert.assertTrue(match);
        
        CheckoutPage checkoutPage = cartPage.goToCheckout(); //the CheckoutPage object is created in its class itself //return new CondirmationPage(driver);
        checkoutPage.selectCountry("India");
        CondirmationPage confirmationPage = checkoutPage.submitOrder();
        
        String confirmMessage = confirmationPage.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
        
        System.out.println("GitHub Success");
        System.out.println("Done2");
        
       //Close the browser
       //driver.close();
    }
		
	@Test(dependsOnMethods = {"SubmitOrder"})	
	public void orderHistoryTest() {
		
		ProductCatalogue productCatalogue = landingPage.loginApplication("dineshbalaji@gmail.com", "Dinesh@2001");
		
		OrderPage orderPage = productCatalogue.goToOrdersPage();
		//Assert.assertTrue(orderPage.VerifyOrderDisplay(productName));
		
	}
	
	
	/**Initial - 1
	@DataProvider
	public Object[][] getData(){
		return new Object[][] {{"dineshbalaji@gmail.com", "Dinesh@2001", "ZARA COAT 3"}, {"marichetty@gmail.com", "Mari@1976", "ADIDAS ORIGINAL"}};
		
	}
	
	*/
	
	
	@DataProvider
	public Object[][] getData(){
		
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "dineshbalaji@gmail.com");
		map.put("password", "Dinesh@2001");
		map.put("productName", "ZARA COAT 3");
		
		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "marichetty@gmail.com");
		map1.put("password", "Mari@1976");
		map1.put("productName", "ADIDAS ORIGINAL");
		
		return new Object[][] {{map}, {map1}};
		
	}
	
		
		
		
		
}
