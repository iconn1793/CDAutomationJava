package tests.urlShortner;

import elements.AndroidElements;
import elements.LoginWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.WebElement;

public class Android_URLShortenerTest extends AndroidElements {

	///////////////////////////////////////////////
	String account_name = "urlshorttest";
	String account_pw = "password";
	String account_email = "new_existing@cyberdust.com";
	String account_website = "www.cyberdust.com ";
	String shortned_website = "cyberdust.com";
	//////////////////////////////////////////////

	LoginWith loginAs = new LoginWith();
	
	public void test01_shortned_bio() throws Exception {	
		loginAs.user(account_name, account_pw);
		
		more_button().click();
		enter_website().click();
		edit_textbox().clear();
		edit_textbox().sendKeys(account_website);
		wait(2);
		
		save_button().click();
		
		WebElement shortned_url = wait.until(ExpectedConditions.elementToBeClickable(By.name(shortned_website)));
		
		try {
			if (shortned_url.isDisplayed())
				System.out.println("Website name is shortned");
		} catch (Exception e) {
			System.err.println("Unable to shorten the website name");
		}

	}
	
	public void test02_shortned_bio() throws Exception {
		enter_website().click();
		edit_textbox().sendKeys(shortned_website);
		save_button().click();
		
		WebElement shortned_url = wait.until(ExpectedConditions.elementToBeClickable(By.name(shortned_website)));
		
		try {
			if (shortned_url.isDisplayed())
				System.out.println("Website name is not shortned");
		} catch (Exception e) {
			System.err.println("Website is shortned");
		}
		enter_website().click();
		edit_textbox().clear();
		save_button().click();
		logoutAccount();
	}
}