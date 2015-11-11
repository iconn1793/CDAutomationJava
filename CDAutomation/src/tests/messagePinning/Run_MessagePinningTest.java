package tests.messagePinning;

import org.junit.*;
import org.junit.runners.MethodSorters;

import tests.messagePinning.Android_MessagePinningTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_MessagePinningTest extends Android_MessagePinningTest
{
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Android_MessagePinningTest android = new Android_MessagePinningTest();
	
	@Test
	public void test01() throws Exception {
		log("[Start] Starting test");
		try {
			log("Test01");
			android.test01_pinning_messages();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
		@Test
		public void test02() throws Exception {
			try {
				log("Test02");
				android.test02_messagePinning();
				log("Test Complete");
			} catch (Exception e) {
				log("[Fail] Got exception " + e);
				relaunch();
				throw e;
			}
			log("[Finish] Test complete\n");
		}
		
}