package tests.onBoarding;

import elements.Drivers;
import io.appium.java_client.TouchAction;

public class AndroidCamera extends Drivers {
	
	TouchAction action = new TouchAction(driver);
	
	public void takePhoto() throws Exception {
		// Tries to take a photo with several different kinds of android phones
        driver.pressKeyCode(25); wait(1000); driver.pressKeyCode(27); wait(5000);
        
        try {
        	driver.findElementById("comotorola.camera:id/review_approve").click();  // For Moto phones
        } catch (Exception e) {
        	
        }
        try {
        	driver.findElementById("coandroid.camera:id/select_this").click();  // For older HTC one phones
        } catch (Exception e) {
        	
        }
        try {
        	action.press(1660, 530).release().perform();  // For new HTC One phones
        } catch (Exception e) {
        	
        }
        try {
        	driver.findElementByName("OK").click();  // For Galaxy phones
        } catch (Exception e) {
        	
        }
        try {
        	driver.findElementById("coandroid.camera2:id/done_button").click();  // For Nexus phones
        } catch (Exception e) {
        	
        }
        try {
        	profile_picture_done().click(); wait(3000);
        } catch (Exception e) {
            System.out.println("Could not take a photo, going back");
            for (int i = 0; i < 2; i++) {
                driver.pressKeyCode(4); wait(1000);  // If none of the above works, go back
            skip_button().click();
            }
        }
		
	}

}
