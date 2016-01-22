package tools;

import elements.Drivers;
import io.appium.java_client.TouchAction;
import org.junit.*;

public class QuickAccountCreator extends Drivers{
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
			sign_up_OK().click();
			create_password().sendKeys(account_pw+i);
		    confirm_password().sendKeys(account_pw+i);
		    password_OK().click();
		    birthday().click();
		    
		    action.longPress(date().getLocation().x, date().getLocation().y, 3000).release().perform(); 
	        birthday_done().click();
	        birthday_OK().click();
	
	        // Skips email
	        skip_button().click();
	        Thread.sleep(8000);
	        OK_button().click();
	
	        // Skips remaining on boarding
	        skip_button().click();
	        skip_button().click();
	        done_button().click();
	        
	        // Logs out
	        more_button().click();

	        action.press(followers()).moveTo(back_button()).release().perform();
	        logout().click();
	        confirm().click();
		}
        
	}
}