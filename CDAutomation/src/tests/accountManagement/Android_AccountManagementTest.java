package tests.accountManagement;

import elements.AndroidElements;
import elements.LoginWith;

public class Android_AccountManagementTest extends AndroidElements {

	/////////////////////////////////////////////////////
	String account_name = "existing02";
	String account_pw = "password";
	String account_new_pw = "new password";
	String account_email = "testuser_02@cyberdust.com";
	String account_new_email = "new_testuser_02@cyberdust.com";
	/////////////////////////////////////////////////////

	LoginWith loginAs = new LoginWith();
	
	public void test01_changing_password() throws Exception {
		// Logs into existing testing account
		loginAs.user(account_name, account_pw);

		// Changes password
		log("Changing password");
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
		log("Password reset");
	}

	public void test02_changing_email() throws Exception {
		
		change_email_address().click();
		new_email_text_box().sendKeys(account_new_email);
		change_password_ok_button().click();

		// Reset email address
		change_email_address().click();
		try {
			if (name(account_new_email).isDisplayed()) {
				log("Email address changed");
				new_email_text_box().sendKeys(account_email);
				change_password_ok_button().click();
				log("Email address reset");
			}
		} catch (Exception e) {
			log("[Warning] Could not change email address");

		}
	}

	public void test03_account_deleting() throws Exception {
		log("Deleting account");
		delete_account().click();
		confirm().click();

		try {
			login_button().click();
			login_username().sendKeys(account_name);
			login_password().click();
			login_password().sendKeys(account_pw);
			login_OK().click();
			invalid_username().isDisplayed();
			log("Could not log into deleted account");
			relaunch();
		} catch (Exception e) {
			log("[Warning] logged into deleted account!");
			
			more_button().click(); Thread.sleep(1000);
	        action.press(followers()).moveTo(back_button()).release().perform();
	        delete_account().click();
	        log("Deleting account again");
	        confirm().click();
		}

		// Recreating the account
		log("Recreating account");
		sign_up_button().click();
		pick_username().sendKeys(account_name);
		sign_up_OK().click();
		create_password().sendKeys(account_pw);
		confirm_password().sendKeys(account_pw);
		password_OK().click();
		birthday().click();
		Thread.sleep(2000);

		action.longPress(date().getLocation().x, date().getLocation().y, 3000).release().perform();
		birthday_done().click();
		birthday_OK().click();
		email().sendKeys(account_email);
		email_OK().click();
		OK_button().click();
		
		relaunch();
		blasts_tab();
	}
}
