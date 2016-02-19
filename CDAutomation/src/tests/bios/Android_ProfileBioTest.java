package tests.bios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.AndroidElements;
import elements.LoginWith;

public class Android_ProfileBioTest extends AndroidElements {
	
//	///////////////////////////////////////////////
	String text_bio = "Cyberdust1 ";
	//////////////////////////////////////////////
	
	LoginWith loginAs = new LoginWith();
	
	public void test01_text_bio() throws Exception
	{
		loginAs.user(bio_account, bio_password);
		more_button().click();
		enter_bio().click();
	    edit_textbox().clear();
		edit_textbox().sendKeys(text_bio);
		save_button().click();
		Thread.sleep(2000);
		WebElement bio = wait.until(ExpectedConditions.elementToBeClickable(By.name(text_bio)));
		bio.isDisplayed();
		bio.click();
		edit_textbox().clear();
		
	}
	
	public void test02_emoji_bio() throws Exception
	{
		
		
	}
}