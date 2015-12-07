package tests.timeout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.Drivers;
//import elements.Friend;
import elements.LoginWith;
import elements.AndroidCamera;
import io.appium.java_client.TouchAction;


public class Android_TimeOutTests extends Drivers{
	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	AndroidCamera androidCamera = new AndroidCamera();
	
	String account_name = "timeouttest";
	
	String friends_account_name1 = "timeoutfriend1";
	String friends_account_name2 = "timeoutfriend2";
	String friends_account_name3 = "timeoutfriend3";
	String friends_account_name4 = "timeoutfriend4";
	String friends_account_name5 = "timeoutfriend5";
	
	String account_short = "timeouttes";
	String account_pw = "password";
	
	String text_message = "Cyber Dust";
	
	
	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();

	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	
	
	public void test01_text_timeout() throws Exception
	{
		loginAs.user(friends_account_name1, account_pw);
		Thread.sleep(5000);
		action_menu().click();
		Thread.sleep(1000);
		action_menu_dust().click();
		

		search_friends().sendKeys(account_short);
		WebElement user1 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_name)));
		user1.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		logout_account();
		
		loginAs.user(friends_account_name2, account_pw);
		action_menu().click();
		Thread.sleep(1000);
		action_menu_dust().click();
		search_friends().sendKeys(account_short);
		WebElement user2 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_name)));
		user2.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys("+technology");
		group_text_send().click();
		logout_account();
		
		loginAs.user(friends_account_name3, account_pw);
		action_menu().click();
		Thread.sleep(1000);
		action_menu_dust().click();search_friends().sendKeys(account_short);
		WebElement user3 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_name)));
		user3.click();
		chat_room_text_box().click();
		switch_emoji_keyboard().click();
		swipe_view_monkey().click();
		switch_text_keyboard().click();
		logout_account();
		
		loginAs.user(friends_account_name4, account_pw);
		action_menu().click();
		Thread.sleep(1000);
		action_menu_dust().click();
		search_friends().sendKeys(account_short);
		WebElement user4 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_name)));
		user4.click();
		chat_room_text_box().click();
		group_camera_button().click(); Thread.sleep(3000);
        photo_button().click();
        photo_pen().click();
        driver.swipe(photo_back_button().getLocation().x + 50, photo_back_button().getLocation().y - 50,
				photo_pen().getLocation().x, photo_pen().getLocation().y + 50, 1000);
		photo_color().click();
		add_text().click();
        add_text_field().sendKeys(text_message);
		done_button().click();
		next_button().click();
		logout_account();
		
		loginAs.user(friends_account_name5, account_pw);
		action_menu().click();
		Thread.sleep(2000);
		action_menu_dust().click();
		search_friends().sendKeys(account_short);
		WebElement user5 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_name)));
		user5.click();
		group_camera_button().click();
		video_button().click();
		action.longPress(photo_button(), 5000).release().perform();
		add_text().click();
		add_text_field().sendKeys("www.cyberdust.com");
		done_button().click();
		next_button().click();
		Thread.sleep(2000);

		
		logout_account();
		loginAs.user(account_name, account_pw);
		dusts_tab().click();
		
		
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friends_account_name5)));
		first_friend.click();
		Thread.sleep(60000);
		
		WebElement message1 = wait.until(ExpectedConditions.elementToBeClickable(By.name(text_message)));
		WebElement message2 = wait.until(ExpectedConditions.elementToBeClickable(By.name("+technology")));
		Thread.sleep(21000);
		WebElement message5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView[@index='0'][android.widget.LinearLayout[@index='0']][android.widget.RelativeLayout[@index ='1'")));       
		
		if(!message5.isDisplayed())
		{
			System.out.println("Message deleted after 60 seconds");
			
		}
		else
		{	
			System.out.println("ERROR: Message is not deleted after 60 seconds");
			
		}
		if(!message1.isDisplayed())
		{
			System.out.println("Message deleted after 20 seconds");
			
		}
		else
		{	
			System.out.println("ERROR: Message is not deleted after 20 seconds");
			
		}
		if(!swipe_view_monkey().isDisplayed())
		{
			System.out.println("Message deleted after 20 seconds");
			
		}
		else
		{	
			System.out.println("ERROR: Message is not deleted after 20 seconds");
			
		}
		
		WebElement message3 = wait.until(ExpectedConditions.elementToBeClickable(By.name("+technology")));
		WebElement message4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView[@index='0'][android.widget.LinearLayout[@index='0']][android.widget.RelativeLayout[@index ='0'")));       
		
		Thread.sleep(40000);
		if(!message4.isDisplayed())
		{
			System.out.println("Message deleted after 60 seconds");
			
		}
		else
		{	
			System.out.println("ERROR: Message is not deleted after 60 seconds");
			
		}
		
		Thread.sleep(40000);
		if(!message3.isDisplayed())
		{
			System.out.println("Message deleted after 60 seconds");
			
		}
		else
		{	
			System.out.println("ERROR: Message is not deleted after 60 seconds");
			
		}
	}
		
	public void logout_account()
	{
		back_button().click();
		back_button().click();
		more_button().click();
		logoutAccount();
	}
	
	
	
}