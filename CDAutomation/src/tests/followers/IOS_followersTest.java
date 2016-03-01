package tests.followers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.IOSElements;
import elements.LoginWith;

public class IOS_followersTest extends IOSElements {


	LoginWith loginAs = new LoginWith();
	
	public void test01_add_friends() throws Exception {
		
		loginAs.user(followers_account01, followers_password01);
		more_button().click();
		followers().click();
		add_friend().click();
		
		try {
			if (!add_friend().isDisplayed())
				System.out.println("Friend added from followers menu");
		} catch (Exception e) {
			System.out.println("Unable to add friend from followers menu");
		}
		back_button().click();
		back_button().click();
		more_button().click();
		friends().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(followers_account02)));
		action.longPress(first_friend,4000).release().perform();
		unfollow_button().click();
		okay_button().click();
		back_button().click();

	}
	
	public void test02_add_friends() throws Exception {
		
		followers().click();
		WebElement first_friend = wait.until(ExpectedConditions.elementToBeClickable(By.name(followers_account02)));
		action.longPress(first_friend, 4000).release().perform();
		
		blast_more_block().click();
		okay_button().click();
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
	}
	
}