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
		enter_old_password().sendKeys(account_pw + "\n");
		enter_new_password().sendKeys(account_new_pw + "\n");
		confirm_new_password().sendKeys(account_new_pw + "\n");
		OK_button().click(); 
		
		// Resets Password
		change_password().click();
		enter_old_password().sendKeys(account_new_pw + "\n");
		enter_new_password().sendKeys(account_pw + "\n");
		confirm_new_password().sendKeys(account_pw + "\n");
		System.out.println("Password reset");
	}


		

public void test02_changing_email() throws Exception {
		
		change_email_address().click();
		driver.getKeyboard().sendKeys(account_new_email + "\n");

		// Reset email address
		change_email_address().click();
		try {
			if (name(account_new_email).getAttribute("value").equals(account_new_email)) {
				System.out.println("Email address changed");
				new_email_text_box().sendKeys(account_email + "\n");
				change_password_ok_button().click();
				System.out.println("Email address reset");
			}
		} catch (Exception e) {
			System.out.println("Email address is not changed");

		}
	}
/*
	public void test03_account_deleting() throws Exception {
		System.out.println("Deleting");
		delete_account().click();
		confirm_delete().click();
		confirm_delete_account().click();
		System.out.println("Account Deleted");
		
		try {
			login_button().click();
			driver.getKeyboard().sendKeys(account_name + "\n");
			driver.getKeyboard().sendKeys(account_pw + "\n");
			driver.findElement(By.name("Invalid username & password combination"));
			System.out.println("Could not login into deleted account");
			back_button().click();
		} catch (Exception e) {

			System.out.println("Logged in into deleted account");
			//driver.pressKeyCode(4);
			sign_up_button().click();
		}

		// Recreating the account
		sign_up_button().click();
		driver.getKeyboard().sendKeys(account_name + "\n");
		driver.getKeyboard().sendKeys("\n");
		driver.getKeyboard().sendKeys(account_pw + "\n");
		driver.getKeyboard().sendKeys(account_pw + "\n");

		System.out.println("Entering birthday");
		date_year().sendKeys("2003");
		birthday_done().click();
		System.out.println("Entering email");
		driver.getKeyboard().sendKeys(account_email + "\n");
		skip_button().click();
		skip_button().click();
		skip_button().click();
		okay_button().click();
		skip_button().click();
		dont_allow().click();
	}*/
}
