package demowebshop.BaseTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demowebshop.pageobjects.CartPage;
import demowebshop.pageobjects.CheckOutPage;
import demowebshop.pageobjects.LandingPage;
import demowebshop.pageobjects.ProductCatalogPage;
import dempwebshop.SubmitOrderTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;
	public Properties prop;
	public LandingPage landingpage;
	public ProductCatalogPage productcatalog;
	public CartPage cartpage;
	public CheckOutPage checkoutpage;

	@BeforeMethod
	public void Initializedriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//config.properties");
		prop.load(fis);
		String browsername = prop.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (browsername.equalsIgnoreCase("firefox")) {
			// firefoxcode
		}
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
		

		landingpage = new LandingPage(driver);
		productcatalog = new ProductCatalogPage(driver);
		cartpage = new CartPage(driver);
		checkoutpage = new CheckOutPage(driver);
		// return driver;
	}

	@AfterMethod
	public void teardown() {
		driver.close();
	}
}
