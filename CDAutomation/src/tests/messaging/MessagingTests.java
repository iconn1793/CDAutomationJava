package tests.messaging;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.Drivers;
import elements.LoginWith;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MessagingTests extends Drivers
{
	WebDriverWait wait = new WebDriverWait(driver, 20);
	///////////////////////////////////////////////
	String account_name = "existingTest01";
	String account_pw = "password";
	String account_email = "new_existing@cyberdust.com";
	String text_message = "cyber dust";
	String friend_username = "aaaaa2";
	String friend_username0 = "aaaaa";
	//////////////////////////////////////////////
	
	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();
	
	
	public void test01_send_text() throws Exception
	{
		loginAs.user(account_name, account_pw);
		action_menu().click();
		action_menu_dust().click();
		Thread.sleep(5000);
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		first_friend.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		System.out.println("Sent a dust");
		
	}
}