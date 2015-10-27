package tools;

import elements.Drivers;
import io.appium.java_client.TouchAction;
import org.junit.*;

public class QuickAccountCreator extends Drivers{
	String account_name = "onboarding999";
	String account_pw = "onboarding999";
	String account_email = "onboarding999@cyberdust.com";
	
	TouchAction action = new TouchAction(driver);
	
	@Test
	public void onBoarding() throws Exception {
		//Starts on boarding
		sign_up_button().click();
		pick_username().sendKeys(account_name);
		sign_up_OK().click();
		create_password().sendKeys(account_pw);
	    confirm_password().sendKeys(account_pw);
	    password_OK().click();
	    birthday().click();
	    
	    action.longPress(date().getLocation().x, date().getLocation().y, 3000).release().perform(); 
        birthday_done().click();
        birthday_OK().click();

        // Enters email
        email().sendKeys(account_email);
        email_OK().click();
        OK_button().click();

        // Skips remaining on boarding
        for(int i=0; i < 2; i++) {
            skip_button().click();
        done_button().click();
        }
	}
}