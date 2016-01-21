package tests.deleteChatRoom;
import org.junit.*;
import org.junit.runners.MethodSorters;

import tests.deleteChatRoom.Android_DeleteChatRoomTests;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_DeleteChatRoomTests extends Android_DeleteChatRoomTests {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
		
	}
	Android_DeleteChatRoomTests android = new Android_DeleteChatRoomTests();
	
	@Test
	public void test01_delete_all_chatrooms() throws Exception {
		log("[Start] Starting delete chat room test");
		try {
			log("Test01 Deleteing chat rooms");
			android.test01_delete_all_chat_rooms();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test02_delete_chatrooms() throws Exception {
		try {
			log("Test02 Deleteing chat rooms");
			android.test02_delete_chat_rooms();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test03_delete_empty_chatrooms() throws Exception {
		try {
			log("Test02 Deleteing empty chat rooms");
			android.test03_delete_empty_chat_rooms();
			log("Test complete");
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}

	
}