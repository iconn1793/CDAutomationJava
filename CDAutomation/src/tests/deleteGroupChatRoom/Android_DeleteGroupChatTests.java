package tests.deleteGroupChatRoom;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.Drivers;
import elements.LoginWith;
import elements.AndroidCamera;
import io.appium.java_client.TouchAction;


public class Android_DeleteGroupChatTests extends Drivers{
	
	WebDriverWait wait = new WebDriverWait(driver, 20);
	AndroidCamera androidCamera = new AndroidCamera();
	
	String account_name = "deletegroupchatroom";
	String account_pw = "password";
	String friend_account_short = "testaccount";
	
	String text_message = "CyberDust.com";
	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();
	
	String account_friend1 = "testaccount1";
	String account_friend2 = "testaccount2";
	String account_friend3 = "testaccount3";
	String account_friend4 = "testaccount4";
	String account_friend5 = "testaccount5";

	int sw = driver.manage().window().getSize().getWidth();
	int sh = driver.manage().window().getSize().getHeight();
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	public void test01_delete_all_group_chat_rooms() throws Exception
	{
		loginAs.user(account_name, account_pw);
		Thread.sleep(5000);
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
		search_friends().sendKeys(friend_account_short);
		
		WebElement user1 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend1)));
		user1.click();
		WebElement user2 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend2)));
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(sw/10*4.86), (int)(sh/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 1");
        confirm().click();
		back_button().click();
		log("First group created");
		
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
		search_friends().sendKeys(friend_account_short);
		
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(sw/10*4.86), (int)(sh/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 2");
        confirm().click();
		back_button().click();
		log("Second group created");
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
		search_friends().sendKeys(friend_account_short);
		
		
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(sw/10*4.86), (int)(sh/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 3");
        confirm().click();
		back_button().click();
		log("Third group created");
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
		search_friends().sendKeys(friend_account_short);
		
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(sw/10*4.86), (int)(sh/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 4");
        confirm().click();
		back_button().click();
		log("Fourth group created");
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
		search_friends().sendKeys(friend_account_short);
		
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(sw/10*4.86), (int)(sh/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 5");
        confirm().click();
		back_button().click();
		log("Fifth group created");
		
		groups_tab().click();
		WebElement Group1 = wait.until(ExpectedConditions.elementToBeClickable(By.name(" Group 1")));
		log("Got group 1");
		
		WebElement Group5 = wait.until(ExpectedConditions.elementToBeClickable(By.name(" Group 5")));
		log("Got group 1");
		
		
		action.press(Group1).moveTo(Group5).release().perform();
		delete_all_groups().click();
		yes_button().click();
		
		try{
			if(!Group1.isDisplayed())
				log("Groups are deleted");
			
		}
		catch(Exception e)
		{
			log("Error: Groups are not deleted");
		}
	}
	
	public void test02_delete_group_chat_rooms() throws Exception
	{
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
		search_friends().sendKeys(friend_account_short);
		
		WebElement user1 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend1)));
		user1.click();
		WebElement user2 = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_friend2)));
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(sw/10*4.86), (int)(sh/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 1");
        confirm().click();
		back_button().click();
		log("First group created");
		
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
		search_friends().sendKeys(friend_account_short);
		
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(sw/10*4.86), (int)(sh/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 2");
        confirm().click();
		back_button().click();
		log("Second group created");
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
		search_friends().sendKeys(friend_account_short);
		
		
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(sw/10*4.86), (int)(sh/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 3");
        confirm().click();
		back_button().click();
		log("Third group created");
		
		action_menu().click();
		Thread.sleep(1000);
		action_menu_group().click();
		search_friends().sendKeys(friend_account_short);
		
		user1.click();
		user2.click();
		OK_button().click();
        Thread.sleep(500);
        action.press((int)(sw/10*4.86), (int)(sh/10*5.07)).release().perform();
        groups_title_field().sendKeys(" Group 4");
        confirm().click();
		back_button().click();
		log("Fourth group created");
		WebElement Group1 = wait.until(ExpectedConditions.elementToBeClickable(By.name(" Group 1")));
		log("Got group 1");
		
		friends_more_button().click();
		delete_group_button().click();
		friends_more_button().click();
		delete_group_button().click();
		friends_more_button().click();
		delete_group_button().click();
		friends_more_button().click();
		delete_group_button().click();
		
		
		try{
			if(!Group1.isDisplayed())
			{
				log("Groups deleted");
			}
		}
		catch(Exception e)
		{
			log("Error: Groups are not deleted");
		}
		
	}
	
		
	
}
