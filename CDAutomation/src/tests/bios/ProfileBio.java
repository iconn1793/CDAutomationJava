package tests.bios;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import elements.Drivers;
import elements.LoginWith;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfileBio extends Drivers
{
	WebDriverWait wait = new WebDriverWait(driver, 20);
	///////////////////////////////////////////////
	String account_name = "testProfilebio";
	String account_pw = "password";
	String text_bio = "CyberdustText ";
    
	//////////////////////////////////////////////
	
	TouchAction action = new TouchAction(driver);
	LoginWith loginAs = new LoginWith();
	
	
	public void test01_text_bio() throws Exception
	{
		loginAs.user(account_name, account_pw);
		more_button().click();
		enter_bio().click();
		
		
		int unicode = 0x1F60A;
	    String text = String.valueOf(Character.toChars(unicode));
	    //inputConnection.commitText(text, mComposing.length());
		edit_textbox().sendKeys(text);
		save_button().click();
		WebElement bio = wait.until(ExpectedConditions.elementToBeClickable(By.name(text_bio)));
		bio.isDisplayed();
		bio.click();
		edit_textbox().clear();
		
	}
	
	public void test02_emoji_bio() throws Exception
	{
		
		
	}
	
	
	
	
	
	
	
	
}