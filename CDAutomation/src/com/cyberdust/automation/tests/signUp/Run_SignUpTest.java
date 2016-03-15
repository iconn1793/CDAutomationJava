package com.cyberdust.automation.tests.signUp;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_SignUpTest extends Drivers {
	
	@Test
	public void test01_checkIfLoggedOut() throws Exception {
		log("[Start] Starting sign up test");
		try {
			log("[Test01]");
			
			if (Android()) {
				new Android_SignUpTest().test01_check_logged_out();
			} else if (IOS()) {
				new IOS_SignUpTest().test01_check_logged_out();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			driver.resetApp();
			throw e;
		}
	}
	
	@Test
	public void test02_signUp() throws Exception {
		try {
			log("[Test02]");

			if (Android()) {
				new Android_SignUpTest().test02_sign_up();
			} else if (IOS()) {
				new IOS_SignUpTest().test02_sign_up();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			driver.resetApp();
			throw e;
		}
	}
	
	@Test
	public void test03_takeProfilePic() throws Exception {
		try {
			log("[Test03]");

			if (Android()) {
				new Android_SignUpTest().test03_take_profile_pic();
			} else if (IOS()) {
				new IOS_SignUpTest().test03_take_profile_pic();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test04_checkForTutorial() throws Exception {
		try {
			log("[Test04]");

			if (Android()) {
				new Android_SignUpTest().test04_check_for_tutorial();
			} else if (IOS()) {
				new IOS_SignUpTest().test04_check_for_tutorial();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test05_updateProfilePic() throws Exception {
		try {
			log("[Test05]");

			if (Android()) {
				new Android_SignUpTest().test05_update_profile_pic();
			} else if (IOS()) {
				new IOS_SignUpTest().test05_update_profile_pic();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			//more_button().click();
			throw e;
		}
	}
	
	@Test
	public void test06_loginLogout() throws Exception {
		try {
			log("[Test06]");

			if (Android()) {
				new Android_SignUpTest().test06_login_logout();
			} else if (IOS()) {
				new IOS_SignUpTest().test06_login_logout();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		log("[Finish] Test Complete\n");
	}
}
