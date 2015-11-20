package tests.addFriends;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_AddFriendsTest extends Android_AddFriendsTest {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Android_AddFriendsTest android = new Android_AddFriendsTest();
	
	@Test
	public void test01_AddFriendFromChat() throws Exception {
		log("[Start] Starting add friend test");
		try {
			log("Test01: add a user that messaged you from chat");
			android.test01_addFriend_fromChat();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
}