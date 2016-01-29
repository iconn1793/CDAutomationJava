package tests.timestamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.Drivers;
import elements.LoginWith;
import elements.AndroidCamera;
import io.appium.java_client.TouchAction;

public class Android_TimestampTest extends Drivers {
	
	public void test01_timestamp_test() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		String account_name = "timestamptest";
		String account_pw = "password";
		String account_friend = "timestamptestfriend";
		
	}
	String text_message = "CyberDust.com";
	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();
	

	int sw = driver.manage().window().getSize().getWidth();
	int sh = driver.manage().window().getSize().getHeight();
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	
	
}