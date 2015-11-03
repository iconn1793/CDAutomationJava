package tests.groups;

import elements.Drivers;
import io.appium.java_client.TouchAction;

public class AndroidAlbum extends Drivers {
	
	TouchAction action = new TouchAction(driver);
	
	int sw = driver.manage().window().getSize().getWidth();
	int sh = driver.manage().window().getSize().getHeight();
	
	public void selectPhoto() throws Exception {
		// Tries to select a photo from the gallery
		waitTime(2);
		try {
			name("Photos").click();
			Thread.sleep(2000);// Note 4
			action.press((sw/10*1), (sh/10*3)).release().perform();
		} catch (Exception e) {
			Thread.sleep(2000);
			action.press((sw/10*1), (sh/10*3)).release().perform();
		}
		Thread.sleep(1000);
	}
}
