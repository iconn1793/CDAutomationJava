package com.cyberdust.automation.tools;

import com.cyberdust.automation.elements.AndroidElements;
import io.appium.java_client.TouchAction;
import org.junit.*;

public class QuickAccountCreator extends AndroidElements {
	String account_name = "devtest";
	String account_pw = "devtest";
	String account_email = "devtest01@cyberdust.com";
	int startAtNum = 1;
	int endAtNum = 20;
	
	TouchAction action = new TouchAction(driver);
	
	@Test
	public void onBoarding() throws Exception {
		for (int i = startAtNum; i <= endAtNum; i++) {
			//Starts on boarding
			sign_up_button().click();
			pick_username().sendKeys(account_name+i);
			username_confirm().click();
			create_password().sendKeys(account_pw+i);
		    password_confirm().click();
		    birthday_confirm().click();
	
	        // Skips email
	        skip_button().click();
	
	        // Skips remaining on boarding
	        skip_button().click();
	        
	        // Logs out
	        more_button().click();

	        action.press(followers()).moveTo(back_button()).release().perform();
	        logout().click();
	        confirm().click();
		}
        
	}
}