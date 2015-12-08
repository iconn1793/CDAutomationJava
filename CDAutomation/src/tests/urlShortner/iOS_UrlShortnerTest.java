package tests.urlShortner;

import elements.LoginWith;

import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;


import elements.Drivers;
import io.appium.java_client.TouchAction;

public class iOS_UrlShortnerTest extends Drivers {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	///////////////////////////////////////////////
	String account_name = "existingTest01";
	String account_pw = "password";
	String account_email = "new_existing@cyberdust.com";
	String account_website = "www.cyberdust.com";
	String shortned_website = "cyberdust.com";
	
	//////////////////////////////////////////////

	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();
	@Test
	public void test01_shortned_bio() throws Exception {
	}
	
}