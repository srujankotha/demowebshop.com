package demowebshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dempwebshop.Reusablecomponents.ReusableComponents;

public class LandingPage extends ReusableComponents {
	WebDriver driver;

	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Log in")
	WebElement loginbutton;
	@FindBy(id = "Email")
	WebElement useremail;
	@FindBy(id = "Password")
	WebElement userpassword;
	@FindBy(xpath = "//input[@value=\"Log in\"]")
	WebElement submitbutton;
	@FindBy(xpath = "//div[@class=\"header-links\"]/ul/li[@id=\"topcartlink\"]/a")
	WebElement shoppintcart;
	@FindBy(xpath = "//div[@class=\"header-links\"]/ul/li[@id=\"topcartlink\"]/a/span[2]")
	WebElement shopingcarttext;
	@FindBy(xpath = "//tr/td[@class=\"remove-from-cart\"]")
	WebElement checkbox;
	@FindBy(xpath = "//input[@name=\"updatecart\"]")
	WebElement updatecart;
	@FindBy(xpath = "//div[@class=\"header-links\"]//ul/li/a[@href=\"/customer/info\"]")
	WebElement idValidation;
	@FindBy(xpath = "//div[@class=\"validation-summary-errors\"]/span")
	WebElement errorMessage;
//@FindBy(xpath="//ul[@class=\"top-menu\"]//a[@href=\"/computers\"]")
//WebElement computers;
//@FindBy(xpath="//ul[@class='sublist firstLevel active']//a[@href='/desktops']") WebElement desktops;

	public void loginapp(String email, String password) {
		loginbutton.click();
		useremail.sendKeys(email);
		userpassword.sendKeys(password);
		submitbutton.click();
	}

	public String idValidation() {
		return idValidation.getText();
	}

	public void updatecartitems() {
		String noofcartitems = shopingcarttext.getText();
		if (!noofcartitems.equalsIgnoreCase("(0)")) {
			shoppintcart.click();
			checkbox.click();
			updatecart.click();

		}
		System.out.println("there were no products addded to cart");
		// return new ProductCatalogPage(driver);
	}

	public String getErrorMessage() {
		visibilityOfWebElement(errorMessage);
		return errorMessage.getText();
	}
}
