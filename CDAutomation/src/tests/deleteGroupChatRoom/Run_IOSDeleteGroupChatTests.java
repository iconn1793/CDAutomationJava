package tests.deleteGroupChatRoom;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_IOSDeleteGroupChatTests extends IOS_DeleteGroupChatTests {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
		
	}
	Android_DeleteGroupChatTests iPhone = new Android_DeleteGroupChatTests();
	
	@Test
	public void test01_delete_all_group_chat_rooms() throws Exception {
		log("[Start] Starting delete group chat room test");
		try {
			log("Test01 Deleteing all group chat rooms");
			iPhone.test01_delete_all_group_chat_rooms();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_delete_group_chat_rooms() throws Exception {
		
		try {
			log("Test02 Deleteing 1-4 group chat rooms");
			iPhone.test02_delete_group_chat_rooms();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}