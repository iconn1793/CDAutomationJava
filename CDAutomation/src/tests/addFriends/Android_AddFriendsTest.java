package tests.addFriends;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import elements.Drivers;
import elements.LoginWith;
import io.appium.java_client.TouchAction;

public class Android_AddFriendsTest extends Drivers {

	WebDriverWait wait = new WebDriverWait(driver, 20);
	///////////////////////////////////////////////
	String account_name = "existingtest02";
	String account_short = "existingtest0";
	String account_pw = "password";
	String account_email = "existing02@cyberdust.com";
	String text_message = "cyber dust";
	String friend_username = "aaaaa2";
	String friend_username0 = "aaaaa";
	//////////////////////////////////////////////

	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();

	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	public void test01_addFriend_fromChat() throws Exception {
		loginAs.user(friend_username, account_pw);
		action_menu().click();
		action_menu_dust().click();
		Thread.sleep(5000);

		search_friends().sendKeys(account_short);
		WebElement user = wait.until(ExpectedConditions.elementToBeClickable(By.name(account_name)));
		user.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		System.out.println("Sent a dust");
		logout_account();
		//relaunch();
		loginAs.user(account_name, account_pw);
		dusts_tab().click();
		
		
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		first_friend.click();
		group_three_dotted_menu().click();
		follow_from_chat_room().click();
		back_button().click();
		first_friend.click();
		group_three_dotted_menu().click();
		try{
			if(unfollow_from_chat_room().isDisplayed())
				System.out.println("Followed from chat room");
			unfollow_from_chat_room().click();
			okay_button().click();
			
		}
		catch(Exception e)
		{
			System.out.println("Unable to follow from chat menu");
		}
		
		

	}
	
	public void logout_account()
	{
		back_button().click();
		back_button().click();
		more_button().click();
		logoutAccount();
	}

	public void test02_AddFriend_from_DustsTab() throws Exception
	{

		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		action.longPress(first_friend, 4000).release().perform();
		WebElement follow_firstFriend = wait.until(ExpectedConditions.elementToBeClickable(By.name("follow aaaaa2" )));
		follow_firstFriend.click();
		first_friend.click();
		group_three_dotted_menu().click();
		
		try{
			if(unfollow_from_chat_room().isDisplayed())
				System.out.println("Followed from dusts tab");
			unfollow_from_chat_room().click();
			okay_button().click();
		}
		catch(Exception e)
		{
			System.out.println("Unable to follow from dust room");
		}
		
	}

	public void test03_chat_from_search_bar() throws Exception

	{

		more_button().click();
		browse_followers().click();
		add_friend().click();
		back_button().click();
		browse_friends().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username0)));
		action.longPress(first_friend, 4000).release().perform();
		try{
			
			if(unfollow_button().isDisplayed())
				System.out.println("Added a friend from search bar");
			unfollow_button().click();
			okay_button().click();
			
			
		}

		catch (Exception e) {

			System.out.println("Unable to add a friend from search bar");

		}

	}
	public void test04_Follow_from_AddFriends() throws Exception

	{

		
		back_button().click();
		back_button().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		action.longPress(first_friend, 4000).release().perform();
		delete_dust().click();
		okay_button().click();
		more_button().click();
		action.press(friends()).moveTo(followers()).release().perform();
		add_friends().click();
		add_friends_search_button_text().sendKeys(friend_username+Keys.RETURN);
		add_friends_button_inBrowseFriends().click();
		back_button().click();
		browse_friends().click();
		action.longPress(first_friend, 4000).release().perform();
		try{
			
			if(unfollow_button().isDisplayed())
				System.out.println("Added a friend from search bar");
			unfollow_button().click();
			okay_button().click();
			
		}

		catch (Exception e) {

			System.out.println("Unable to add a friend from search bar");

		}
		
	}

	public void test05_AddFriend_from_home() throws Exception

	{

		
		action_menu().click();
		Thread.sleep(2000);
		action_menu_search().click();
		add_friends_search_button_text().sendKeys(friend_username+Keys.RETURN);
		add_friends_button_inBrowseFriends().click();
		back_button().click();
		browse_friends().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		action.longPress(first_friend, 4000).release().perform();
		try{
			
			if(unfollow_button().isDisplayed())
				System.out.println("Added a friend from search bar");
			unfollow_button().click();
			okay_button().click();
			
		}

		catch (Exception e) {

			System.out.println("Unable to add a friend from search bar");

		}
		
	}
}