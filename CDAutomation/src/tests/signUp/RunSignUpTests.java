package tests.signUp;

import org.junit.*;
import org.junit.runners.MethodSorters;
import elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RunSignUpTests extends SignUpTests {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Drivers element = new Drivers();
	
	@Test
	public void test01_checkIfLoggedOut() throws Exception {
		try {
			System.out.println("[SignUp] Starting test01");
			test01_check_logged_out();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			driver.resetApp();
			throw e;
		}
	}
	
	@Test
	public void test02_signUp() throws Exception {
		try {
			System.out.println("[SignUp] Starting test02");
			test02_sign_up();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			driver.resetApp();
			throw e;
		}
	}
	
	@Test
	public void test03_takeProfilePic() throws Exception {
		try {
			System.out.println("[SignUp] Starting test03");
			test03_take_profile_pic();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test04_checkForTutorial() throws Exception {
		try {
			System.out.println("[SignUp] Starting test03");
			test04_check_for_tutorial();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test05_updateProfilePic() throws Exception {
		try {
			System.out.println("[SignUp] Starting test04");
			test05_update_profile_pic();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			element.more_button().click();
			throw e;
		}
	}
	
	@Test
	public void test06_loginLogout() throws Exception {
		try {
			System.out.println("[SignUp] Starting test05");
			test06_login_logout();
	        System.out.println("Test Complete");
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}
