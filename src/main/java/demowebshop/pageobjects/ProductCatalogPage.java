package demowebshop.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dempwebshop.Reusablecomponents.ReusableComponents;

public class ProductCatalogPage extends ReusableComponents {
	WebDriver driver;

	public ProductCatalogPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class=\"top-menu\"]//a[@href=\"/computers\"]")
	WebElement computers;
	@FindBy(xpath = "//ul[@class='sublist firstLevel active']//a[@href='/desktops']")
	WebElement desktops;
	@FindBy(xpath = "//div[@class=\"product-grid\"]//div[@class=\"item-box\"]//div/h2/a")
	List<WebElement> Desktopslist;
	@FindBy(xpath = "//span[@itemprop=\"price\"]")
	WebElement priceofDesktop;
	@FindBy(xpath = "//div[@class=\"add-to-cart-panel\"]//input[1]")
	WebElement quantityTextbox;
	@FindBy(xpath = "//div[@class=\"add-to-cart-panel\"]//input[@value=\"Add to cart\"]")
	WebElement addtocart;
	@FindBy(xpath = "//div[@class=\"ajax-loading-block-window\"]/div")
	WebElement spinner;
	@FindBy(xpath = "//*[@id=\"bar-notification\"]/p")
	WebElement addedcartmessage;

	By toastmessage = By.xpath("//p[@class=\"content\"]");

	public void mouseActiononDesktop() {
		Actions action = new Actions(driver);
		action.moveToElement(computers).perform();
		desktops.click();
	}

	public List<WebElement> getdesktopList() {
		return Desktopslist;
	}

	public void gettheDesktopByname(String desktopname) {
		for (WebElement product : Desktopslist) {
			String productname = product.getText();
			System.out.println(productname);
			if (productname.equalsIgnoreCase(desktopname)) {
				product.click();
				break;
			}
		}
	}

	public String getthePriceofDesktop() {
		return priceofDesktop.getText();
	}

	public void addingQuantity(String quantity) {
		quantityTextbox.click();
		quantityTextbox.clear();
		quantityTextbox.sendKeys(quantity);
	}

	public void addProductTocart() {
		addtocart.click();
		waitforElementDisappear(spinner);
		waitforElementToAppear(toastmessage);
	}

	public String toastMessageValitdation() {
		return addedcartmessage.getText();
	}

}
