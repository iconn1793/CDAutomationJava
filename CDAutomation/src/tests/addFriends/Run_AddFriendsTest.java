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
	@Test
	public void test02_AddFriendFromDusts() throws Exception {
		try {
			log("Test02: add a user that messaged you from home +");
			android.test02_AddFriend_from_DustsTab();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test03_AddFriendFromFollowers() throws Exception {
		try {
			log("Test03: add a user that added you");
			android.test03_chat_from_search_bar();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test04_AddFriendFromFollowers() throws Exception {
		try {
			log("Test04: add a user by searching username in AddFriends");
			android.test04_Follow_from_AddFriends();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test05_AddFriendFromFollowers() throws Exception {
		try {
			log("Test05: add a user by searching username in HomeScreen");
			android.test05_AddFriend_from_home();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}