package tests.ian;

import static org.junit.Assert.*;

import org.junit.Test;

public class Run_IOSLoginTest extends IOS_LoginTest {
	
	public static void relaunch(){
		driver.closeApp();
		driver.launchApp();
	}
	
	IOS_LoginTest iPhone = new IOS_LoginTest();
	
	@Test
	public void test01_IOSLogin() throws Exception {
		log("[Start] Starting login test.");
		try{ 
			log("Test01: Log in.");
			iPhone.Login();
		}
		
		catch (Exception e) {
			log("[Fail] Got exception" + e);
			relaunch();
			throw e;
		}
		
		log("Test complete.");
	}
	
}
