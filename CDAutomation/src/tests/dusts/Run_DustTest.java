package tests.dusts;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_DustTest extends Android_dustTest {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Android_dustTest android = new Android_dustTest();
	
	@Test
	public void test01_sendTextDusts() throws Exception {
		log("[Start] Starting blast test");
		try {
			log("Test01: Start a chat from Dusts tab from the floating action menu: +dust");
			android.test01_chat_from_action_menu();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_dustRoomTest() throws Exception {
		try {
			log("Test02: Start a chat from Dusts tab - you already have a dust room with that person.");
			android.test02_chat_from_dust_room();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test03_sendTextDusts() throws Exception {
		try {
			log("Test03: Start a chat from Dusts tab (using search) - you already have a dust room with that person.");
			android.test03_chat_from_search_bar();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test04_dustRoomTest() throws Exception {
		try {
			log("Test04 Start a chat from Dusts tab (using search) - you dont have a dust room with that person.");
			android.test04_chat_from_search_bar();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test05_sendTextDusts() throws Exception {
		try {
			log("Test05: Start a chat from Friends page (using search) - you already have a dust room with that person.");
			android.test05_chat_from_friend_list();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test06_dustRoomTest() throws Exception {
		try {
			log("Test06: Start a chat from Friends page (using search) - you dont have a dust room with that person.");
			android.test06_chat_from_friend_list();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
		@Test
		public void test07_sendTextDusts() throws Exception {
			try {
				log("Test07: Start a chat from Friends page - you already have a dust room with that person.");
				android.test07_chat_from_friend_list();
			} catch (Exception e) {
				log("[Fail] Got exception " + e);
				relaunch();
				throw e;
			}
		}
		
		@Test
		public void test08_dustRoomTest() throws Exception {
			try {
				log("Test08: Start a chat from Friends page - you dont have a dust room with that person.");
				android.test08_chat_from_friend_list();
			} catch (Exception e) {
				log("[Fail] Got exception " + e);
				throw e;
			}
			log("Test complete");
	}
}
	