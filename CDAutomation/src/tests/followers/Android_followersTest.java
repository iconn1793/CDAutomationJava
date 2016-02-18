package tests.followers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.AndroidElements;
import elements.LoginWith;

public class Android_followersTest extends AndroidElements {
	
	///////////////////////////////////////////////
	String account_name = "followerstest";
	String account_pw = "password";
	String account_email = "new_existing@cyberdust.com";
	String friend_username = "followerstestfriend";

	//////////////////////////////////////////////

	LoginWith loginAs = new LoginWith();
	
	public void test01_add_friends() throws Exception {
		
		loginAs.user(account_name, account_pw);
		more_button().click();
		followers().click();
		add_friend().click();
		
		try {
			waitTime(2);
			if (!add_friend().isDisplayed())
				System.out.println("Friend added from followers menu");
		} catch (Exception e) {
			System.out.println("Unable to add friend from followers menu");
		}
		waitTime(20);
		back_button().click();
		back_button().click();
		more_button().click();
		friends().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		action.longPress(first_friend,3000).release().perform();
		unfollow_button().click();
		okay_button().click();
		back_button().click();

	}
	
	public void test02_add_friends() throws Exception {
		
		followers().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(friend_username)));
		action.longPress(first_friend, 3000).release().perform();
		
		blast_more_block().click();
		okay_button().click();
		Thread.sleep(1000);
		aDriver().pressKeyCode(4);
		back_button().click();
		action.press(followers()).moveTo(back_button()).release().perform();
		muted_blocked_users().click();
		
		try {
			if (first_friend.isDisplayed())
				System.out.println("Friend added from followers menu");
		} catch (Exception e) {
			System.out.println("Unable to add friend from followers menu");
		}
		first_friend.click();
		back_button().click();
		back_button().click();
	}
	
}