package elements;

import elements.IOSDrivers;

////Designed only to run on iOS simulation
////
////For some reason the test will always end with "failed to establish server connection", regardless of test success

public class IOS_LoginWith extends IOSDrivers {

	
    public void user(String account, String password) throws Exception {
    	
    	//enters initial log in info
    	login_button().click();
    	driver.getKeyboard().sendKeys(account);
    	login_password().click();
    	driver.getKeyboard().sendKeys(password);
    
    	//clicks through onboarding
    	Thread.sleep(600);
    	push_notifications_OK().click();
    	Thread.sleep(600);
    	exit_onboarding().click();   	
       
    }
}
