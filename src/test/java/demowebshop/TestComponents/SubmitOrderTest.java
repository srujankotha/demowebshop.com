package demowebshop.TestComponents;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import demowebshop.BaseTests.BaseTest;
import demowebshop.pageobjects.CartPage;
import demowebshop.pageobjects.CheckOutPage;
import demowebshop.pageobjects.LandingPage;
import demowebshop.pageobjects.ProductCatalogPage;

public class SubmitOrderTest extends BaseTest {

	@Test
	public void submitorder() throws IOException {
		String desktopname = "Build your own cheap computer";

		landingpage.loginapp("planittest78@gmail.com", "123456");
		String validationofid = landingpage.idValidation();
		Assert.assertTrue(validationofid.equalsIgnoreCase("planittest78@gmail.com"));
		System.out.println("id is validated successfull");
		landingpage.updatecartitems();
		
//***********************product catalog page*******************************************

		productcatalog.mouseActiononDesktop();
		List<WebElement> Desktopslist = productcatalog.getdesktopList();
		productcatalog.gettheDesktopByname(desktopname);
		String price = productcatalog.getthePriceofDesktop();
		System.out.println(price);
		productcatalog.addingQuantity("2");
		productcatalog.addProductTocart();
		String toastmessage = productcatalog.toastMessageValitdation();
		System.out.println(toastmessage);
		productcatalog.goToCartHeaderPage();
		
//*************************************cart page******************************
	
		String subTotal = cartpage.gettingSubtotalofDektop();
		Assert.assertEquals(subTotal, "1630.00");
		System.out.println("subtotal validated sucesss");
		cartpage.goToCheckoutPage();
		
//***************************Checkoutpage***********************************

		checkoutpage.Billingaddress();
		checkoutpage.ShippingAddress();
		checkoutpage.ShippingMethod();
		checkoutpage.PaymentMethod();
		// String paymentmode=checkoutpage.modeofpayment();
		// Assert.assertEquals(paymentmode, "You will pay by COD");
		checkoutpage.Paymentinfo();
		checkoutpage.Confirmorder();
		checkoutpage.continuebutton();
		checkoutpage.logoutbutton();
//*************************************		
		// String ordernumber = checkoutpage.getordernumber();
		// System.out.println(ordernumber);
		// String ordervalidationmessage=checkoutpage.getorderValidation();
		// Assert.assertEquals(ordervalidationmessage, "Your order has been successfully
		// processed!");
		// WebElement
		// ele1=driver.findElement(By.xpath("//div[@class=\"title\"]/strong[text()=\"Your
		// order has been successfully processed!\"]"));
		// System.out.println(ele1);
//***************************8	
//	String orderconfirmation=driver.findElement(By.xpath("//div[@class=\"section order-completed\"]/div/strong")).getText();
//	System.out.println(orderconfirmation);

////	String Ordernumber=driver.findElement(By.xpath("//div[@class=\"section order-completed\"]//ul[@class=\"details\"]/li[1]")).getText();
//	System.out.println(Ordernumber);

	}

}
