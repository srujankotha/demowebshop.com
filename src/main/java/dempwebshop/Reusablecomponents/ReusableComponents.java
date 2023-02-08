package dempwebshop.Reusablecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import demowebshop.pageobjects.CartPage;

public class ReusableComponents {

	WebDriver driver;

	public ReusableComponents(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class=\"header-links\"]/ul/li[@id=\"topcartlink\"]/a")
	WebElement cartHeader;

	public void waitforElementToAppear(By FindBy) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
	}
	public void waitforLocatortToAppear(By FindBy) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy)).click();
	}
	public void waitforElementDisappear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}

	public void goToCartHeaderPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", cartHeader);

	}

	public void visiblityofelement(WebElement ele1) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(ele1)).click();
	}

	public void visibilityOfWebElement(WebElement FindBy) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(FindBy));
	}

}
