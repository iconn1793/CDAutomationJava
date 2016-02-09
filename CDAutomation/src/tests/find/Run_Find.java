package tests.find;

import org.junit.*;
import org.junit.runners.MethodSorters;

import elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_Find extends Drivers {
	
	@Test
	public void test01_ChangePassword() throws Exception {
		try {
			log("Starting test - xxx");
			
			if (Android()) {
				//new Android_Find().xxx();
			} else if (IOS()) {
				//new IOS_Find().xxx();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}