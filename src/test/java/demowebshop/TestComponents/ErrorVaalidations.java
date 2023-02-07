package demowebshop.TestComponents;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import demowebshop.BaseTests.BaseTest;

public class ErrorVaalidations extends BaseTest {

	@Parameters({"username","invalidpassword"})
	@Test
	public void invalidPassword(String username,String invalidpassword) {
	//	String desktopname = "Build your own cheap computer";
		//LandingPage landingpage = new LandingPage(driver);
		landingpage.loginapp(username, invalidpassword);
		Assert.assertTrue(landingpage.getErrorMessage().equalsIgnoreCase("Login was unsuccessful. Please correct the errors and try again."));
		System.out.println("error validation succesfull");
		
	}


}
