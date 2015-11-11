package elements;

import io.appium.java_client.TouchAction;

public class AndroidCamera extends Drivers {
	
	TouchAction action = new TouchAction(driver);
	
	public void takePhoto() throws Exception {
		// Tries to take a photo with several different kinds of android phones
        driver.pressKeyCode(25); Thread.sleep(1000); driver.pressKeyCode(27); Thread.sleep(5000);
        
        try {
        	driver.findElementById("com.motorola.camera:id/review_approve").click();  // For Moto phones
        } catch (Exception e) {
        	
        }
        try {
        	driver.findElementById("com.android.camera:id/select_this").click();  // For older HTC one phones
        } catch (Exception e) {
        	
        }
        try {
        	action.press(1660, 530).release().perform();  // For new HTC One phones
        } catch (Exception e) {
        	
        }
        try {
        	driver.findElementByName("OK").click();  // For Galaxy Note 4
        } catch (Exception e) {
        	
        }
        try {
        	driver.findElementByName("Save").click();  // For Galaxy Note 3
        	
        } catch (Exception e) {
        	
        }
        try {
        	driver.findElementById("com.android.camera2:id/done_butto").click();  // For Nexus phones
        } catch (Exception e) {
        	
        }
        try {
        	profile_picture_done().click(); Thread.sleep(3000);
        } catch (Exception e) {
            log("Could not take a photo, going back");
            for (int i = 0; i < 2; i++) {
                driver.pressKeyCode(4); Thread.sleep(3000);  // If none of the above works, go back
            try {
                skip_button().click();
            } catch (Exception f) {
      	
            }
            }
        }
		
	}

}
