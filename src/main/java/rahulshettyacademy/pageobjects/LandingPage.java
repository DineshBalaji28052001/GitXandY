package rahulshettyacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		// Initialization
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// PageFactory
	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement userPassword;

	@FindBy(id = "login")
	WebElement submit;

	// div[aria-label='Incorrect email or password.']

	@FindBy(css = "div[aria-label='Incorrect email or password.']")
	WebElement invalidError;

	// Action Methods
	public ProductCatalogue loginApplication(String email, String password) {
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		submit.click();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}

	public String  getErrorMessage() {
		waitForWebElementToAppear(invalidError);
		return invalidError.getText();
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

}

//// Login
//driver.findElement(By.id("userEmail")).sendKeys("dineshbalaji@gmail.com");
//driver.findElement(By.id("userPassword")).sendKeys("Dinesh@2001");
//driver.findElement(By.id("login")).click();
