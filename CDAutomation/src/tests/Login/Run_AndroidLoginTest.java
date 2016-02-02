package tests.Login;

import static org.junit.Assert.*;

import org.junit.Test;

public class Run_AndroidLoginTest extends Android_LoginTest {
	
	public static void relaunch(){
		driver.closeApp();
		driver.launchApp();
	}
	
	Android_LoginTest android = new Android_LoginTest();
	
	@Test
	public void test01_AndroidLogin() throws Exception {
		log("[Start] Starting login test.");
		try{ 
			log("Test01: Log in.");
			android.Login();
		}
		
		catch (Exception e) {
			log("[Fail] Got exception" + e);
			relaunch();
			throw e;
		}
		
		log("Test complete.");
	}
	
}
