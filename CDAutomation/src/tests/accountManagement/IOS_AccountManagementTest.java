package tests.accountManagement;
import org.openqa.selenium.By;

import elements.IOSDrivers;
import elements.IOS_LoginWith;
import io.appium.java_client.TouchAction;

public class IOS_AccountManagementTest extends IOSDrivers {

	/////////////////////////////////////////////////////
	String account_name = "existing02";
	String account_pw = "password";
	String account_new_pw = "new password";
	String account_email = "testuser_02@cyberdust.com";
	String account_new_email = "new_testuser_02@cyberdust.com";
	/////////////////////////////////////////////////////

	TouchAction action = new TouchAction(driver);
	IOS_LoginWith loginAs = new IOS_LoginWith();

	public void test01_changing_password() throws Exception {
		// Logs into existing testing account
		loginAs.user(account_name + "\n", account_pw + "\n");
		System.out.println("Logged In");

		// Changes password
		more_button().click();
		action.press(followers()).moveTo(close()).release().perform();
		change_password().click();
		driver.getKeyboard().sendKeys(account_pw + "\n");
		driver.getKeyboard().sendKeys(account_new_pw + "\n");
		driver.getKeyboard().sendKeys(account_new_pw + "\n");
		change_password_ok_button().click();
		System.out.println("Password changed");
		

		// Resets Password
		change_password().click();
		driver.getKeyboard().sendKeys(account_new_pw + "\n");
		driver.getKeyboard().sendKeys(account_pw + "\n");
		driver.getKeyboard().sendKeys(account_pw + "\n");
		change_password_ok_button().click();
		System.out.println("Password reset");
	}

	public void test02_changing_email() throws Exception {
		//temp area start
		loginAs.user(account_name + "\n", account_pw + "\n");
		System.out.println("Logged In");
		more_button().click();
		action.press(followers()).moveTo(close()).release().perform();
		//temp area end
		
		change_email_address().click();
		clear_text_button().click();
		driver.getKeyboard().sendKeys(account_new_email + "\n");
		OK_button().click();
		OK_button().click();

		// Reset email address
		change_email_address().click();
		Thread.sleep(1000);
		try {
			if ((driver.findElement(By.id("new_testuser_02@cyberdust.com"))).getAttribute("value").equals(account_new_email)) {
				System.out.println("Email address changed");
				clear_text_button().click();
				driver.getKeyboard().sendKeys(account_email + "\n");
				OK_button().click();
				OK_button().click();
				System.out.println("Email address reset");
			}
		} catch (Exception e) {
			System.out.println("Email address is not changed");

		}
	}

	public void test03_account_deleting() throws Exception {
		System.out.println("Deleting");
		delete_account().click();
		confirm().click();
		System.out.println("Account Deleted");

		try {
			login_button().click();
			login_username().sendKeys(account_name);
			login_password().click();
			login_password().sendKeys(account_pw);
			login_OK().click();
			invalid_username().isDisplayed();
			System.out.println("Could not login into deleted account");
			driver.closeApp();
			driver.launchApp();
			sign_up_button().click();
		} catch (Exception e) {
			System.out.println("Logged in into deleted account");
			//driver.pressKeyCode(4);
			sign_up_button().click();
		}

		// Recreating the account
		pick_username().sendKeys(account_name);
		sign_up_OK().click();
		create_password().sendKeys(account_pw);
		confirm_password().sendKeys(account_pw);
		password_OK().click();
		birthday().click();
		Thread.sleep(2000);

		System.out.println("Entering birthday");
		action.longPress(date().getLocation().x, date().getLocation().y, 3000).release().perform();
		birthday_done().click();
		birthday_OK().click();
		System.out.println("Entering email");
		email().sendKeys(account_email);
		email_OK().click();
		OK_button().click();
	}
}
