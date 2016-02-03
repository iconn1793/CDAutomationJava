package elements;

import org.openqa.selenium.By;

import elements.IOSDrivers;

////Designed only to run on iOS simulation
////
//// Will always end with "Failed to establish connection to Appium server", regardless of test success

public class IOS_LoginWith extends IOSDrivers {

	
    public void user(String account, String password) throws Exception {
    	
    	//enters initial log in info
    	//make sure account variable ends with a "\n" to send it to the password line
    	login_button().click();
    	driver.getKeyboard().sendKeys(account);
    	driver.getKeyboard().sendKeys(password);
    
    	//clicks through onboarding
    	push_notifications_OK().click();
    	exit_onboarding().click();   	
       
    }
}
