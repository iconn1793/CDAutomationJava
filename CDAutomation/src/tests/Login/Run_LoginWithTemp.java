package tests.Login;

import org.junit.*;
import org.junit.runners.MethodSorters;
import tests.Login.LoginWithTemp; 

import elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_LoginWithTemp extends Drivers {
	
	@Test
	public void test01_LoginTemp() throws Exception {
		try {
			log("Starting test - LoginTemp");
			
			if (Android()) {
				//new Android_AccountManagementTest().test01_changing_password();
			} else if (IOS()) {
				new LoginWithTemp().loginIOS("testacct09", "test09");
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}