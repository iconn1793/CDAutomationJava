package com.cyberdust.automation.tests.accountManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.cyberdust.automation.elements.IOSElements;
import com.cyberdust.automation.elements.LoginWith;

public class IOS_AccountManagementTest extends IOSElements {

	LoginWith loginAs = new LoginWith();
	
	public void test01_changing_password() throws Exception {
		// Logs into existing testing account
		loginAs.user(acctmgnt_account01, acctmgnt_password01);
		System.out.println("Logged In");

		// Changes password
		more_button().click();
		action.press(followers()).moveTo(close_button()).release().perform();
		Thread.sleep(1100);
		change_password().click();

		enter_old_password().sendKeys(acctmgnt_password01 + "\n");
		enter_new_password().sendKeys(accmgnt_new_password + "\n");
		confirm_new_password().sendKeys(accmgnt_new_password + "\n");
		Alert_OK_button().click();
		System.out.println("Password Changed");
		
		// Resets Password
		change_password().click();
		enter_old_password().sendKeys(accmgnt_new_password + "\n");
		enter_new_password().sendKeys(acctmgnt_password01 + "\n");
		confirm_new_password().sendKeys(acctmgnt_password01 + "\n");
		Alert_OK_button().click(); 
		System.out.println("Password reset");
	}

	public void test02_changing_email() throws Exception {
		
		change_email_address().click();
		clear_text_button().click();
		driver.getKeyboard().sendKeys(accmgnt_new_email + "\n");
		OK_button().click();
		Alert_OK_button().click();
				
		// Reset email address
		change_email_address().click();
		
		try {
			if (driver.findElement(By.id(accmgnt_new_email)).isDisplayed()) {
				System.out.println("Email address changed");
				clear_text_button().click();
				new_email_text_box().sendKeys(accmgnt_email + "\n");
				OK_button().click();
				Alert_OK_button().click();
				System.out.println("Email address reset");
			}
		} catch (Exception e) {
			System.out.println("Email address is not changed");

		}
	}

	public void test03_account_deleting() throws Exception {
			 
			
		System.out.println("Deleting");
		delete_account().click();
		confirm_delete().click();
		confirm_delete_again().click();
		System.out.println("Account Deleted");
		
		try {
			login_button().click();
			driver.getKeyboard().sendKeys(acctmgnt_account01 + "\n");
			driver.getKeyboard().sendKeys(acctmgnt_password01 + "\n");
			driver.findElement(By.name("Invalid username & password combination"));
			System.out.println("Could not login into deleted account");
			back_button().click();
		} catch (Exception e) {
			System.out.println("Logged in into deleted account");
			//sign_up_button().click();
		}

		// Recreating the account
		sign_up_button().click();
		driver.getKeyboard().sendKeys(acctmgnt_account01 + "\n");
		driver.getKeyboard().sendKeys("\n" + acctmgnt_password01 + "\n" + acctmgnt_password01 + "\n");

		System.out.println("Entering birthday");
		date_year().sendKeys("2003");
		birthday_OK().click();
		System.out.println("Entering email");
		driver.getKeyboard().sendKeys(accmgnt_email + "\n");
		skip_button().click();
		Thread.sleep(1000);
		skip_button().click();
		Thread.sleep(1000);
		skip_button().click();
		Thread.sleep(1000);
		WebElement OK = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//UIAApplication[1]/UIAWindow[4]/UIAAlert[1]/UIACollectionView[1]/UIACollectionCell[2]/UIAButton[1]")));
		OK.click();
		Thread.sleep(1000);
		skip_button().click();
		
	}
}