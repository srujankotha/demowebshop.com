package dempwebshop;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demowebshop.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
      ChromeOptions options=new ChromeOptions();
      //options.setCapability("strictFileInteractability", true);
        options.setAcceptInsecureCerts(true);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(options);
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.MILLISECONDS);
//		driver.findElement(By.linkText("Log in")).click();
//		
//		driver.findElement(By.id("Email")).sendKeys("planittest78@gmail.com");
//		driver.findElement(By.id("Password")).sendKeys("123456");
//		driver.findElement(By.xpath("//input[@value=\"Log in\"]")).click();
		
		LandingPage lp=new LandingPage(driver);
		lp.loginapp("planittest78@gmail.com", "123456");
		lp.updatecartitems();
		////clicking on shiping butoon
//		driver.findElement(By.xpath("//div[@class=\"header-links\"]/ul/li[@id=\"topcartlink\"]/a")).click();
//		try {
//		driver.findElement(By.xpath("//tr/td[@class=\"remove-from-cart\"]")).click();
//		driver.findElement(By.xpath("//input[@name=\"updatecart\"]")).click();
//		}catch(Exception e) {
//			System.out.println("there were no products addded to cart");
//		}
		Thread.sleep(4000);
		WebDriverWait wait=new WebDriverWait(driver,15);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Actions action=new Actions(driver);
	WebElement mouseover=	driver.findElement(By.xpath("//ul[@class=\"top-menu\"]//a[@href=\"/computers\"]"));
	action.moveToElement(mouseover).perform();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//ul[@class='sublist firstLevel active']//a[@href='/desktops']")).click();

	//List<WebElement> listofdesktops= driver.findElements(By.xpath("//div[@class=\"product-grid\"]//div[@class=\"item-box\"]"));
	List<WebElement> productslist=driver.findElements(By.xpath("//div[@class=\"product-grid\"]//div[@class=\"item-box\"]//div/h2/a"));
	for(WebElement product: productslist) {
		String productname=product.getText();
		System.out.println(productname);
		if(productname.equalsIgnoreCase("Build your own cheap computer") ){
			product.click();
			break;
		}
	}
	//WebElement addcartpopup=driver.findElement(By.xpath("//p[@class=\"content\"]"));

	String priceofproduct=driver.findElement(By.xpath("//span[@itemprop=\"price\"]")).getText();
	System.out.println(priceofproduct);
	//WebElement quan=driver.findElement(By.id("addtocart_72_EnteredQuantity"));
	//System.out.println(quan.getAttribute("value"));
	//driver.findElement(By.xpath("//input[@class=\"qty-input valid\"]")).sendKeys("2");
	driver.findElement(By.xpath("//input[@id=\"addtocart_72_EnteredQuantity\"]")).click();
	driver.findElement(By.xpath("//input[@id=\"addtocart_72_EnteredQuantity\"]")).clear();
	driver.findElement(By.xpath("//input[@id=\"addtocart_72_EnteredQuantity\"]")).sendKeys("2");
	driver.findElement(By.xpath("//div[@class=\"add-to-cart-panel\"]//input[@value=\"Add to cart\"]")).click();
	

	WebElement spinner=driver.findElement(By.xpath("//div[@class=\"ajax-loading-block-window\"]/div"));
	wait.until(ExpectedConditions.invisibilityOf(spinner));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class=\"content\"]")));
	
	//driver.findElement(By.xpath("//ul//li[@id=\"topcartlink\"]/a")).click();
	WebElement shippingcartitems=driver.findElement(By.xpath("//div[@class=\"header-links\"]/ul/li[@id=\"topcartlink\"]/a"));
	js.executeScript("arguments[0].click();", shippingcartitems);
	String subtotalofproduct=driver.findElement(By.xpath("//table[@class=\"cart-total\"]//tr[1]/td/following-sibling::td//span[@class=\"product-price\"]")).getText();
	
	if(subtotalofproduct.equalsIgnoreCase("1630.00")) {
		System.out.println("the subtotal validation is successfull");
	}else {
		System.out.println("the subtotal validation is Not successfull");
	}
	
	driver.findElement(By.id("termsofservice")).click();
	driver.findElement(By.id("checkout")).click();
	
	driver.findElement(By.xpath("//li[@id=\"opc-billing\"]//div[@id=\"billing-buttons-container\"]/input")).click();
	WebElement Shippingbutton=driver.findElement(By.xpath("//li[@id=\"opc-shipping\"]//div[@id=\"shipping-buttons-container\"]/input"));
	
	
	wait.until(ExpectedConditions.visibilityOf(Shippingbutton)).click();
//	driver.findElement(By.xpath("//div[@class=\"method-name\"]/input[@id=\"shippingoption_1\"]")).click();
//	driver.findElement(By.xpath("//label[@for=\"shippingoption_1\"]/parent::div/input")).click();
//	driver.findElement(By.xpath("//label[@for=\"shippingoption_1\"]/preceding-sibling::input")).click();
	
//	WebElement radiobutton=driver.findElement(By.id("shippingoption_1"));
//	wait.until(ExpectedConditions.elementToBeClickable(radiobutton)).click();
//	JavascriptExecutor js=(JavascriptExecutor)driver;
//	js.executeScript("arguments[0].click();", radiobutton);
	WebElement continubutton=driver.findElement(By.xpath("//li[@id=\"opc-shipping_method\"]//div[@id=\"shipping-method-buttons-container\"]//input"));
	wait.until(ExpectedConditions.visibilityOf(continubutton)).click();
	WebElement paymentmethodbutton=driver.findElement(By.xpath("//li[@id=\"opc-payment_method\"]//div[@id=\"payment-method-buttons-container\"]/input"));
	wait.until(ExpectedConditions.visibilityOf(paymentmethodbutton)).click();
	WebElement paymentmode=driver.findElement(By.xpath("//div[@class=\"info\"]//p"));
    System.out.println(paymentmode.getText());
	//String paymentmode=driver.findElement(By.xpath("//li[@id=\"opc-payment_info\"]//table//p")).getText();
	//String paymentmode=driver.findElement(By.xpath("//tbody/tr/td/p")).getText();
//	String paymentmode=driver.findElement(By.xpath("//*[@id=\"checkout-payment-info-load\"]/div/div/div[1]/table/tbody/tr/td/p")).getText();
//	if(paymentmode.equalsIgnoreCase("You will pay by COD")) {
//		System.out.println("payment mode is successfully validated");
//	}else {
//		System.out.println("the payment mode is not validated");
//	}
	WebElement paymentinfobutton=driver.findElement(By.xpath("//li[@id=\"opc-payment_info\"]//div[@id=\"payment-info-buttons-container\"]/input"));
	wait.until(ExpectedConditions.visibilityOf(paymentinfobutton)).click();
	WebElement confirmorder=driver.findElement(By.xpath("//div[@id=\"confirm-order-buttons-container\"]/input"));
	wait.until(ExpectedConditions.visibilityOf(confirmorder)).click();
	
	String orderconfirmation=driver.findElement(By.xpath("//div[@class=\"section order-completed\"]/div/strong")).getText();
	System.out.println(orderconfirmation);
	if(orderconfirmation.equalsIgnoreCase("Your order has been successfully processed!")) {
      System.out.println("you order is successfully placed");		
	}else {
		System.out.println("your order is not placed ");
	}
	
	String Ordernumber=driver.findElement(By.xpath("//div[@class=\"section order-completed\"]//ul[@class=\"details\"]/li[1]")).getText();
	System.out.println(Ordernumber);
	}

}
