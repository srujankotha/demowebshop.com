package demowebshop.TestComponents;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.WebElement;
import demowebshop.BaseTests.BaseTest;

public class ParameterValidationTest extends BaseTest {
    @Parameters({"desktopname","username","passwrod"})
	@Test
	public void submitorder(String desktopname,String username,String passwrod) throws IOException {
		//String desktopname = "Build your own cheap computer";

		landingpage.loginapp(username,passwrod );
		String validationofid = landingpage.idValidation();
		Assert.assertTrue(validationofid.equalsIgnoreCase(username));
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
		Assert.assertTrue(toastmessage.equalsIgnoreCase("The product has been added to your shopping cart"));
		System.out.println("toastmessage is validated");
		productcatalog.goToCartHeaderPage();
		
//*************************************cart page******************************
	    String totalofDesktop =cartpage.gettotalOfDesktop();
		String subTotal = cartpage.getSubtotalofDektop();
		Assert.assertEquals(subTotal, totalofDesktop);
		System.out.println("subtotal validated sucesss");
		cartpage.goToCheckoutPage();
		
//***************************Checkoutpage***********************************

		checkoutpage.Billingaddress();
		checkoutpage.ShippingAddress();
		checkoutpage.ShippingMethod();
		checkoutpage.PaymentMethod();
		String paymentmode=checkoutpage.modeofpayment();
	    Assert.assertEquals(paymentmode, "You will pay by COD");
	    System.out.println(paymentmode);
		checkoutpage.Paymentinfo();
		checkoutpage.Confirmorder();
		checkoutpage.getorderMessageValidation();
		String orderConfirMessage=checkoutpage.getorderMessageValidation();
		Assert.assertTrue(orderConfirMessage.equalsIgnoreCase("Your order has been successfully processed!"));
		String ordernumber=checkoutpage.getordernumber();
		System.out.println("ordernumber is "+ordernumber);
		checkoutpage.continuebutton();
		checkoutpage.logoutbutton();
		
		
	}

}
