package rahulshettyacademy.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import rahulshettyacademy.pageobjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;

	public WebDriver initializeDriver() throws IOException {
		
		//properties class
		
		//Default class to get the global properties
		Properties property = new Properties();
		//D:\SeleniumFrameworkDesign\SeleniumFrameworkDesign\src\main\java\rahulshettyacademy\resources
		FileInputStream file = new FileInputStream("D:\\SeleniumFrameworkDesign\\SeleniumFrameworkDesign\\src\\main\\java\\rahulshettyacademy\\resources\\GlobalData.properties");
		property.load(file); // to load this we need to create default class
		String browserName = property.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome"))
		{
		//WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		}
		
		else if(browserName.equalsIgnoreCase("firefox")) {
			//FireFox
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			//Edge
			driver = new EdgeDriver();
			driver.manage().window().maximize();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(16));
		driver.manage().window().maximize();
		return driver;
	}
	
	@BeforeMethod (alwaysRun =  true)
	public LandingPage launchApplication() throws IOException {
		driver = initializeDriver(); //Initializing an driver based on browser in the global properties
		landingPage = new LandingPage(driver);  // Created an Object variable outside the methods
		landingPage.goTo(); // created an object and we are calling goTo() method for URL
		return landingPage; // 
	}
	
	@AfterMethod (alwaysRun =  true)
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000); // 2-second wait before closing
		driver.quit();

	}
}
