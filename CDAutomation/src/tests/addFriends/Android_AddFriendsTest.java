package tests.addFriends;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.AndroidElements;
import elements.LoginWith;

public class Android_AddFriendsTest extends AndroidElements {

	String account_name = "existingtest02";
	String account_short = "existingtest0";
	String account_pw = "password";
	String account_email = "existing02@cyberdust.com";
	String text_message = "cyber dust";
	String friend_username = "aaaaa2";
	String friend_username0 = "aaaaa";

	LoginWith loginAs = new LoginWith();
	
	public void test01_addFriend_fromChat() throws Exception {
		loginAs.user(friend_username, account_pw);
		Thread.sleep(5000);
		action_menu().click();
		Thread.sleep(1000);
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
	
	public void logout_account() throws Exception
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
	public void test04_Follow_from_AddFriends() throws Exception{
		
		back_button().click();
		back_button().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		action.longPress(first_friend, 4000).release().perform();
		delete_dust().click();
		//okay_button().click();
		more_button().click();
		action.press(friends()).moveTo(followers()).release().perform();
		add_friends().click();
		add_friends_search_button_text().click();
		friends_search().sendKeys(friend_username);
		aDriver().pressKeyCode(66);
		
		add_friends_button_inBrowseFriends().click();
		back_button().click();
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

		back_button().click();
		back_button().click();
		action_menu().click();
		Thread.sleep(2000);
		action_menu_search().click();
		friends_search().click();
		friends_search().sendKeys(friend_username);
		aDriver().pressKeyCode(66);
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
	public void test06_popular_page() throws Exception

	{

		
		action_menu().click();
		Thread.sleep(2000);
		action_menu_discover().click();
		Thread.sleep(4000);
	
		try{
			
			if(discover_tab().isDisplayed())
				System.out.println("Popular tab is accessible");
			}

		catch (Exception e) {

			System.out.println("Discover tab is not accessible");

		}
		
	}
	
	public void test07_chatters_page() throws Exception
	{
		try{
			if(chatters_tab().isDisplayed())
				System.out.println("Chatters tab is accessible");
		}

		catch (Exception e) {
			System.out.println("Discover tab is not accessible");

		}
		
	}
	
	public void test08_Popular_page() throws Exception

	{

	
		try{
			
			if(chatters_tab().isDisplayed())
			{
				
				WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RelativeLayout[@index='3']")));
				first_friend.click();
				yes_button().click();
				Thread.sleep(2000);
				first_friend.click();
				yes_button().click();
				
				if(Friend_already_added().isDisplayed())
				{
					System.out.println("Popular page - a user can be added");
				}
			}
		}
		catch (Exception e) {

			System.out.println("Discover tab is not accessible");
		
		}
	}
}