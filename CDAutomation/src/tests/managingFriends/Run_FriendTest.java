package tests.managingFriends;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_FriendTest extends Android_FriendTest {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Android_FriendTest android = new Android_FriendTest();
	
	@Test
	public void test01_sendDusts() throws Exception {
		log("[Start] Starting test");
		try {
			log("Test01");
			android.test01_send_dusts();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
		@Test
		public void test02_receiveDusts() throws Exception {
			try {
				log("Test02");
				android.test02_receive_dusts();
				log("Test Complete");
			} catch (Exception e) {
				log("[Fail] Got exception " + e);
				relaunch();
				throw e;
			}
			log("[Finish] Test complete\n");
		}
}