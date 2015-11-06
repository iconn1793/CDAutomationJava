package tests.signUp;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_SignUpTest extends Android_SignUpTest {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Android_SignUpTest android = new Android_SignUpTest();
	
	@Test
	public void test01_checkIfLoggedOut() throws Exception {
		log("[Start] Starting sign up test");
		try {
			log("Test01 checking if logged out");
			android.test01_check_logged_out();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			driver.resetApp();
			throw e;
		}
	}
	
	@Test
	public void test02_signUp() throws Exception {
		try {
			log("Test02 starting on boarding process");
			android.test02_sign_up();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			driver.resetApp();
			throw e;
		}
	}
	
	@Test
	public void test03_takeProfilePic() throws Exception {
		try {
			log("Test03 taking a profile picture");
			android.test03_take_profile_pic();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test04_checkForTutorial() throws Exception {
		try {
			log("Test04 checking for first time tutorial");
			android.test04_check_for_tutorial();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test05_updateProfilePic() throws Exception {
		try {
			log("Test05 updating profile picture");
			android.test05_update_profile_pic();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			more_button().click();
			throw e;
		}
	}
	
	@Test
	public void test06_loginLogout() throws Exception {
		try {
			log("Test06 logging out then back in");
			android.test06_login_logout();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		log("[Finish] Test Complete\n");
	}
}
