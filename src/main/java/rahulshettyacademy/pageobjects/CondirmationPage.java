package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CondirmationPage {
	
	WebDriver driver;

	public CondirmationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	//String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
    //Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	
	public String getConfirmationMessage() {
		String cnfMsg = confirmationMessage.getText();
		return cnfMsg;
	}
}
