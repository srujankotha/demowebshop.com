package demowebshop.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dempwebshop.Reusablecomponents.ReusableComponents;

public class CheckOutPage extends ReusableComponents {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//li[@id=\"opc-billing\"]//div[@id=\"billing-buttons-container\"]/input")
	WebElement Billingbutton;
	@FindBy(xpath = "//li[@id=\"opc-shipping\"]//div[@id=\"shipping-buttons-container\"]/input")
	WebElement ShippingAddressbutton;
	@FindBy(xpath = "//li[@id=\"opc-shipping_method\"]//div[@id=\"shipping-method-buttons-container\"]//input")
	WebElement ShippingMethodbutton;
	@FindBy(xpath = "//li[@id=\"opc-payment_method\"]//div[@id=\"payment-method-buttons-container\"]/input")
	WebElement PaymentMethodbutton;
	@FindBy(xpath = "//li[@id=\"opc-payment_info\"]//div[@id=\"payment-info-buttons-container\"]/input")
	WebElement Paymentinfobutton;
	@FindBy(xpath = "//div[@id=\"confirm-order-buttons-container\"]/input")
	WebElement confirmorder;
	@FindBy(xpath = "//input[@value=\"Confirm\"]")
	WebElement confirmorderbutton;

	@FindBy(xpath="//div[@class=\"info\"]//p[text()=\"You will pay by COD\"]") 
	WebElement paymentmode;
	@FindBy(xpath = "//div[@class=\"title\"]/strong")
	WebElement ordervalidation;
	@FindBy(xpath = "//ul[@class=\"details\"]/li[1]")
	WebElement ordernumber;
	@FindBy(xpath = "//input[@value=\"Continue\"]")
	WebElement continuebutton;
	@FindBy(linkText = "Log out")
	WebElement logout;
	// WebElement
	// e=driver.findElement(By.xpath("//div[@class=\"info\"]//p[text()=\"You will
	// pay by COD\"]"));
	// System.out.println(e.getText());

	public void Billingaddress() {
		Billingbutton.click();
	}

	public void ShippingAddress() {
		visiblityofelement(ShippingAddressbutton);
	}

	public void ShippingMethod() {
		visiblityofelement(ShippingMethodbutton);
	}

	public void PaymentMethod() {
		visiblityofelement(PaymentMethodbutton);
	}

	public String modeofpayment() {
		return paymentmode.getText();
	}

	public void Paymentinfo() {
		visiblityofelement(Paymentinfobutton);
	}

	public void Confirmorder() {
		visiblityofelement(confirmorderbutton);
	}

	public String getorderValidation() {
		return ordervalidation.getText();
	}

	public String getordernumber() {
		return ordernumber.getText();
	}

	public void continuebutton() {
		visiblityofelement(continuebutton);
	}

	public void logoutbutton() {
		logout.click();
	}
}
