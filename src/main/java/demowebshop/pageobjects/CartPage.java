package demowebshop.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dempwebshop.Reusablecomponents.ReusableComponents;

public class CartPage extends ReusableComponents{
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//table[@class=\"cart-total\"]//tr[1]/td/following-sibling::td//span[@class=\"product-price\"]") WebElement subtotalofitem;
	@FindBy(id="termsofservice") WebElement checkbox;
	@FindBy(id="checkout") WebElement checkoutbutton;
	@FindBy(xpath="//table[@class=\"cart-total\"]//tr[4]//strong") WebElement Total;

public String getSubtotalofDektop() {
	String  actualsubtotal=subtotalofitem.getText();
	return actualsubtotal;
}
public String gettotalOfDesktop() {
	return Total.getText();
}
public void goToCheckoutPage() {
	checkbox.click();
	checkoutbutton.click();
	
}
}
