package com.cyberdust.automation.tests.bios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_ProfileBioTest extends IOSElements {
	
	
	String text_bio = "Cyberdust1 ";
	
	LoginWith loginAs = new LoginWith();
	
	public void test01_text_bio() throws Exception
	{
		loginAs.user(bio_account, bio_password);
		System.out.println("Entering text bio");
		more_button().click();
		enter_bio().click();
		driver.getKeyboard().sendKeys(text_bio + "\n");
		close_button().click();
		more_button().click();
		WebElement bio = driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIATableView[1]/UIATableCell[1]/UIATextView[1]"));
		try{
			if ((bio.getAttribute("value")).equals("Cyberdust1 ")) {
				System.out.println("Text bio successful");
			}
			else{
				System.out.println("Text bio failed");
			}
			
			action.longPress(345, 300).release().perform();
			action.longPress(delete_button(), 3000).release().perform();
			action.longPress(delete_button(), 3000).release().perform();
			close_button().click();
		}
		finally {}
		
	}
	
	public void test02_emoji_bio() throws Exception
	{
		
		
	}
}