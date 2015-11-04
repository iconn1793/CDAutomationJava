package tests.onBoarding;

import org.junit.*;
import org.junit.runners.MethodSorters;
import elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RunSignUpTests extends SignUpTests {
	
	Drivers element = new Drivers();
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	@Test
	public void test01_checkIfLoggedOut() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test01");
			test01_check_logged_out();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			driver.resetApp();
			throw e;
		}
	}
}
