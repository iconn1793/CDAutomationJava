package tests.accountManagement;

import elements.IOSElements;
import elements.LoginWith;

public class IOS_AccountManagementTest extends IOSElements {

	/////////////////////////////////////////////////////
	String account_name = "existing02";
	String account_pw = "password";
	String account_new_pw = "new password";
	String account_new_email = "testuser_02@cyberdust.com";
	String account_email = "new_testuser_02@cyberdust.com";
	/////////////////////////////////////////////////////

	LoginWith loginAs = new LoginWith();
	
	public void test01_changing_password() throws Exception {
		// Logs into existing testing account
		loginAs.user(account_name, account_pw);
		System.out.println("Logged In");

		// Changes password
		more_button().click();
		action.press(followers()).moveTo(back_button()).release().perform();
		change_password().click();
		enter_old_password().click();
		enter_old_password().sendKeys(account_pw);
		enter_new_password().click();
		enter_new_password().sendKeys(account_new_pw);
		confirm_new_password().click();
		confirm_new_password().sendKeys(account_new_pw);
		change_password_ok_button().click();

		// Resets Password
		change_password().click();
		enter_old_password().sendKeys(account_new_pw);
		enter_new_password().click();
		enter_new_password().sendKeys(account_pw);
		confirm_new_password().click();
		confirm_new_password().sendKeys(account_pw);
		change_password_ok_button().click();
		System.out.println("Password reset");
	}

	public void test02_changing_email() throws Exception {
		//temp
		loginAs.user(account_name, account_pw);
		System.out.println("Logged In");
		more_button().click();
		action.press(followers()).moveTo(back_button()).release().perform();
		//end temp
		
		change_email_address().click();
		new_email_text_box().sendKeys(account_new_email);
		change_password_ok_button().click();

		// Reset email address
		change_email_address().click();
		try {
			if (name(account_new_email).isDisplayed()) {
				System.out.println("Email adress changed");
				new_email_text_box().sendKeys(account_email);
				change_password_ok_button().click();
				System.out.println("Email address reset");
			}
		} catch (Exception e) {
			System.out.println("Email adress is not changed");

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
			System.out.println("Loged in into deleted account");
			driver.pressKeyCode(4);
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
