package tests.dusts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.AndroidElements;
import elements.LoginWith;

public class Android_DustTest extends AndroidElements {

	///////////////////////////////////////////////
	String account_name = "dusttest";
	String account_pw = "password";
	String account_email = "new_existing@cyberdust.com";
	String text_message = "cyber dust";
	String friend_username = "dustfriend1";
	String friend_username0 = "dustfriend";
	String friend_username2 = "dustfriend2";
	//////////////////////////////////////////////

	LoginWith loginAs = new LoginWith();

	public void test01_chat_from_action_menu() throws Exception {
		loginAs.user(account_name, account_pw);
		action_menu().click();
		action_menu_dust().click();
		Thread.sleep(5000);
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		first_friend.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");
		try {
			if (sent_text_dust().isDisplayed())
				log("Started a chat from floating action menu");
		} catch (Exception e) {
			log("Unable to start a chat from floating action menu");
		}

	}

	public void test02_chat_from_dust_room() throws Exception

	{

		back_button().click();
		back_button().click();
		dusts_tab().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		first_friend.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try

		{

			if (sent_text_dust().isDisplayed())
				log("Started a chat from dust room");

		}

		catch (Exception e) {

			log("Unable to start a chat from dust room");

		}

	}

	public void test03_chat_from_search_bar() throws Exception

	{

		back_button().click();
		more_button().click();
		action.press(share_twitter()).moveTo(enter_bio()).release().perform();
		add_friends().click();
		add_friends_search_button_text().click();
		
		friends_search().click();
		friends_search().sendKeys(friend_username0);
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		first_friend.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try

		{

			if (sent_text_dust().isDisplayed())
				log("Started a chat from action menu search bar");

		}

		catch (Exception e) {

			log("Unable to start a chat from action menu search bar");

		}

	}

	public void test04_chat_from_search_bar() throws Exception

	{

		// you don't have a dust room with that person.
		back_button().click();
		back_button().click();
		remove_dustroom();
		
		more_button().click();
		action.press(share_twitter()).moveTo(enter_bio()).release().perform();
		add_friends().click();
		add_friends_search_button_text().click();
		
		friends_search().click();
		friends_search().sendKeys(friend_username0);
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		first_friend.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try

		{

			if (sent_text_dust().isDisplayed())
				log("Started a chat from action menu search bar");

		}

		catch (Exception e) {

			log("Unable to start a chat from action menu search bar");

		}

	}

	public void test05_chat_from_friend_list() throws Exception

	{

		back_button().click();
		back_button().click();
		back_button().click();
		friends().click();
		friends_list_search().sendKeys(friend_username0);
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		first_friend.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try

		{

			if (sent_text_dust().isDisplayed())
				log("Started a chat from floating action menu");

		}

		catch (Exception e) {

			log("Unable to start a chat from floating action menu");

		}

	}

	public void test06_chat_from_friend_list() throws Exception { // You do not
		// have a
		// dust room

		back_button().click();
		remove_dustroom();
		blasts_tab().click();
		more_button().click();
		friends().click();
		friends_list_search().sendKeys(friend_username0);
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		first_friend.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try

		{

			if (sent_text_dust().isDisplayed())
				log("Started a chat from floating action menu");

		}

		catch (Exception e) {
			log("Unable to start a chat from floating action menu");

		}

	}

	public void test07_chat_from_friend_list() throws Exception {

		back_button().click();
		back_button().click();
		back_button().click();
		more_button().click();
		friends().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		first_friend.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try

		{

			if (sent_text_dust().isDisplayed())
				log("Started a chat from floating action menu");

		}

		catch (Exception e) {
			log("Unable to start a chat from floating action menu");

		}

	}


	public void test08_chat_from_friend_list() throws Exception { // You do not
																	// have a
																	// dust room

		back_button().click();
		remove_dustroom();
		blasts_tab();
		more_button().click();
		friends().click();
		friends_list_search().click();
		friends_list_search().sendKeys(friend_username0);
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		first_friend.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		log("Sent a dust");

		try

		{

			if (sent_text_dust().isDisplayed())
				log("Started a chat from floating action menu");

		}

		catch (Exception e) {
			log("Unable to start a chat from floating action menu");

		}

	}

	public void remove_dustroom()

	{
		back_button().click();
		back_button().click();
		dusts_tab().click();
		friends_more_button().click();
		delete_dust().click();

	}

}
