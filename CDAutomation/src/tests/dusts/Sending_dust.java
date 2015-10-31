package tests.dusts;

import elements.Drivers;
import elements.LoginWith;
import io.appium.java_client.TouchAction;
import org.junit.*;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Sending_dust extends Drivers{

	WebDriverWait wait = new WebDriverWait(driver, 20);
	///////////////////////////////////////////////
	String account_name = "existingTest01";
	String account_pw = "password";
	String account_email = "new_existing@cyberdust.com";
	String text_message = "cyber dust";
	String friend_username = "aaaaa2";
	String friend_username2 = "existing02";
	//////////////////////////////////////////////

	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();

	int sw = driver.manage().window().getSize().getWidth();
	int sh = driver.manage().window().getSize().getHeight();

	@Test
	public void test01_chat_from_action_menu() throws Exception
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
		try
		{
			if (sent_text_dust().isDisplayed())
			System.out.println("Started a chat from floating action menu");
		}
		catch (Exception e) {
			System.out.println("Unable to start a chat from floating action menu");
		} 
		
	}
	
	@Test
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
		System.out.println("Sent a dust");
		try
		{
			if (sent_text_dust().isDisplayed())
			System.out.println("Started a chat from floating action menu");
		}
		catch (Exception e) {
			System.out.println("Unable to start a chat from floating action menu");
		} 
		
	}
	@Test
	public void test03_chat_from_search_bar() throws Exception
	{
		back_button().click();
		action_menu().click();
		action_menu_search().click();
		friends_search().click();
		friends_search().sendKeys(friend_username);
		//chat_room_first_friend().click();
		//search_result_first_friend().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		first_friend.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		System.out.println("Sent a dust");
		try
		{
			if (sent_text_dust().isDisplayed())
			System.out.println("Started a chat from floating action menu");
		}
		catch (Exception e) {
			System.out.println("Unable to start a chat from floating action menu");
		} 
		
	}
	
	@Test
	public void test04_chat_from_search_bar() throws Exception
	{
		// you don't have a dust room with that person.
		back_button().click();
		back_button().click();
		action_menu().click();
		action_menu_search().click();
		friends_search().click();
		friends_search().sendKeys(friend_username2);
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username2)));
		first_friend.click();
		chat_room_text_box().click();
		chat_room_text_box().sendKeys(text_message);
		chat_room_send_button().click();
		System.out.println("Sent a dust");
		try
		{
			if (sent_text_dust().isDisplayed())
			System.out.println("Started a chat from floating action menu");
		}
		catch (Exception e) {
			System.out.println("Unable to start a chat from floating action menu");
		} 
		
		
		
	}
	
	
	
	
	
	
}
