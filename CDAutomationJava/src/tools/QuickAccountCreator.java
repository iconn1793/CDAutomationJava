package tools;

import elements.Drivers;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.TouchAction;
import org.junit.*;
import org.openqa.selenium.Point;


public class QuickAccountCreator extends Drivers{
	String account_name = "onboarding001";
	String account_pw = "onboarding001";
	String account_email = "onboarding001@cyberdust.com";
	
	@Test
	public void onBoarding() throws Exception {
		sign_up_button().click();
		pick_username().sendKeys(account_name);
		sign_up_OK().click();
		create_password().sendKeys(account_pw);
	    confirm_password().sendKeys(account_pw);
	    password_OK().click();
	    birthday().click();
	    Point mylist = date().getLocation();
	    System.out.println(mylist.x);
	    System.out.println(mylist.y);
	    TouchAction action = new TouchAction(driver); 
	    action.longPress(mylist.x, mylist.y).release().perform(); 

	}
//insert assertions here
}