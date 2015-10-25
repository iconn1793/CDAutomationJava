package tests.onBoarding;

import elements.Drivers;
import tests.onBoarding.AndroidCamera;
import io.appium.java_client.TouchAction;
import org.junit.*;


public class OnBoardingTest extends Drivers{
	String account_name = "onboarding001";
	String account_pw = "onboarding001";
	String account_email = "onboarding001@cyberdust.com";
	
	TouchAction action = new TouchAction(driver);
	AndroidCamera androidCamera = new AndroidCamera();
	
	@Test
	public void checkIfLoggedOut() throws Exception {
		// Check if logged out
		boolean isLoggedOut;
		try {
            sign_up_button();
            isLoggedOut = true;
        } catch (Exception e) {
            isLoggedOut = false;
        }
		if (isLoggedOut) {
            more_button().click(); wait(1000);
            action.press(followers()).moveTo(back_button()).release().perform();
            // try this: driver.scrollTo("Logout");
            logout().click();
            System.out.println("Logging out before starting test");
            confirm().click();
		}
	}
	
	@Test
	public void signUp() throws Exception {
		// Create new account and check if special characters can be used
	    sign_up_button().click();
	    pick_username().sendKeys(account_name + "!@//$");
	    try {
	        sign_up_OK().click();
	        System.out.println("Special characters used in username");
	    } catch (Exception e) {
	        System.out.println("Could not use special characters in username");
	    }
	    pick_username().sendKeys(account_name);
	    sign_up_OK().click();
	    create_password().sendKeys(account_pw);
	    confirm_password().sendKeys(account_pw);
	    password_OK().click();
	    birthday().click(); wait(2000);
	    		
        // Sets birthday
        System.out.println("Entering birthday");
        action.longPress(date().getLocation().x, date().getLocation().y, 3000).release().perform();
        birthday_done().click();
        birthday_OK().click();

        // Enters email
        System.out.println("Entering email");
        email().sendKeys(account_email);
        email_OK().click();
        OK_button().click();
	}
	
	@Test
	public void takeProfilePic() throws Exception {
		// Takes a picture with camera and sets as profile picture
        profile_picture().click();
        camera_button().click(); wait(3000);
        System.out.println("Taking a photo and setting it as the profile picture");
        androidCamera.takePhoto();
        System.out.println("Skipping checking contacts and sending text message");
        OK_button().click();
        skip_button().click();
        done_button().click();
        System.out.println("New account created");
	}
	
	@Test
    public void test_updating_profile_picture() throws Exception {
        // Changes profile picture
        more_button().click();
        profile_picture().click();
        change_profile_picture().click();
        System.out.println("Changing profile picture");
        camera_button().click(); wait(3000);
        androidCamera.takePhoto();
        System.out.println("Profile picture updated");
	}
	
	@Test
    public void loginLogout() throws Exception {
        // Logout and login test
        System.out.println("Testing System.out.printlnout and System.out.printlnin");
        action.press(followers()).moveTo(back_button()).release().perform();
        logout().click();
        confirm().click();
        login_button().click();
        login_username().sendKeys(account_name.toUpperCase());
        login_password().sendKeys(account_pw);
        login_OK().click();
        System.out.println("Username is not case sensitive");

        // Deletes account
        more_button().click(); wait(1000);
        action.press(followers()).moveTo(back_button()).release().perform();
        delete_account().click();
        System.out.println("Deleting account");
        confirm().click();
        System.out.println("On boarding test completed");
        
        // End test
	}
}
