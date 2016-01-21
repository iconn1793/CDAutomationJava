package tests.deleteChatRoom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.Drivers;
import elements.LoginWith;
import elements.AndroidCamera;
import io.appium.java_client.TouchAction;


public class Android_DeleteChatRoomTests extends Drivers{
	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	AndroidCamera androidCamera = new AndroidCamera();
	
	String account_name = "deletechatroom";
	String account_pw = "password";
	String friend_account_short = "testaccount";
	
	String text_message = "CyberDust.com";
	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();
	
	String account_friend1 = "testaccount";
	String account_friend2 = "testaccount1";
	String account_friend3 = "testaccount2";
	String account_friend4 = "testaccount3";
	String account_friend5 = "testaccount4";

	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	public void test01_delete_all_chat_rooms() throws Exception
	{
		loginAs.user(account_name, account_pw);
		Thread.sleep(5000);
		action_menu().click();
		Thread.sleep(1000);
		action_menu_dust().click();
		
		search_friends().sendKeys(friend_account_short);
		
		WebElement user1 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend1)));
		user1.click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		back_button().click();
		
		WebElement user2 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend2)));
		user2.click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		back_button().click();
		
		
		WebElement user3 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend3)));
		user3.click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		back_button().click();
		
		WebElement user4 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend4)));
		user4.click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		back_button().click();
		action.press(user3).moveTo(user1).release().perform();
			
		WebElement user5 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend5)));
		user5.click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		back_button().click();
		
		back_button().click();
		
		dusts_tab().click();
		 action.press(user1).moveTo(user3).release().perform();
		 delete_all_dusts().click();
		 yes_button().click();
		 try{
			 
		 
		 if((delete_all_dusts().isDisplayed()))
		 {
			 System.out.println("Error: Dusts are not deleted");
		 }
		 }
		 catch(Exception e)
		 {
			 System.out.println("Dusts are deleted");
		 }
				 
		
		
	}
	public void test02_delete_chat_rooms() throws Exception
	{
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_dust().click();
		
		search_friends().sendKeys(friend_account_short);
		
		WebElement user1 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend1)));
		user1.click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		back_button().click();
		
		WebElement user2 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend2)));
		user2.click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		back_button().click();
		
		
		WebElement user3 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend3)));
		user3.click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		back_button().click();
		
		WebElement user4 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend4)));
		user4.click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		back_button().click();
		back_button().click();
		
		friends_more_button().click();
		delete_dust().click();
		friends_more_button().click();
		delete_dust().click();
		friends_more_button().click();
		delete_dust().click();
		friends_more_button().click();
		delete_dust().click();
		
		try{
			if(friends_more_button().isDisplayed())
			{
				System.out.println("Error: Dusts are not deleted");
			}
		}
			catch(Exception e)
			{
				System.out.println("Dusts are deleted");
			}
		
		
	}
	public void test03_delete_empty_chat_rooms() throws Exception
	{
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_dust().click();
		
		search_friends().sendKeys(friend_account_short);
		
		WebElement user1 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend1)));
		user1.click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		back_button().click();
		
		WebElement user2 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend2)));
		user2.click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		back_button().click();
		
		WebElement user3 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend3)));
		user3.click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		back_button().click();
		
		WebElement user4 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend4)));
		user4.click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		back_button().click();
		action.press(user3).moveTo(user1).release().perform();
			
		WebElement user5 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend5)));
		user5.click();
		chat_room_text_box().sendKeys(text_message);
		group_text_send().click();
		back_button().click();
		back_button().click();
		
		
		Thread.sleep(2000);
		user1.click();
		Thread.sleep(1000);
		back_button().click();
		action.press(user1).moveTo(user3).release().perform();
		delete_empty_rooms_button().click();
		try{
			if(user1.isDisplayed())
			{
				System.out.println("Error: Dusts are not deleted");
			}
		}
			catch(Exception e)
			{
				System.out.println("Dusts are deleted");
			}
		
	}
}
		
		
	












