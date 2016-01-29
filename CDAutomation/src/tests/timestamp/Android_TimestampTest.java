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
	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	String account_name = "timestamptest";
	String account_pw = "password";
	String account_friend = "timestamptestfriend";
	String account_friend2 = "timestampfriend2";
	
	String friend_account_short ="timestamp";
	String text_message = "CyberDust.com";
	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();
	

	int sw = driver.manage().window().getSize().getWidth();
	int sh = driver.manage().window().getSize().getHeight();
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	public void test01_sent_dust_timestamp() throws Exception {
		loginAs.user(account_name, account_pw);
		Thread.sleep(5000);
		action_menu().click();
		
		Thread.sleep(1000);
		action_menu_dust().click();
		search_friends().sendKeys(friend_account_short);
		WebElement user1 = name(account_friend);
		user1.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		back_button().click();
		back_button().click();
		dusts_tab().click();
		try{
			
			//if(dust_info_text().getText().contains("you sent")&&(dust_info_text().getText().contains("minute ago")||dust_info_text().getText().contains("minute ago")))
			if((dust_info_text().getText()).contains("You sent less than a minute ago"))
			{
				log("timestamp is correct");
			}
			else
			{
				log("incorrect");
			}
			
		}
		catch(Exception e)
		{
			log("timestamp is incorrect");
		}
		Thread.sleep(60000);
		try{
			
			//if(dust_info_text().getText().contains("you sent")&&(dust_info_text().getText().contains("minute ago")||dust_info_text().getText().contains("minute ago")))
			if((dust_info_text().getText()).contains("You sent a minute ago"))
			{
				log("timestamp is correct");
			}
			else
			{
				log("incorrect");
			}
			
		}
		catch(Exception e)
		{
			log("timestamp is incorrect");
		}
	}
	
	public void test01_sent_group_timestamp() throws Exception {
		
		
	}
	
}