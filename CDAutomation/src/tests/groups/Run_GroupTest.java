package tests.groups;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_GroupTest extends Android_GroupTest {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Android_GroupTest android = new Android_GroupTest();
	IOS_GroupTest iOS = new IOS_GroupTest();
	
	@Test
	public void test01_createGroup() throws Exception {
		log("[Start] Starting group test");
		try {
			log("Test01 creating a group");
			if (Android()) {
				android.test01_create_group();
			} else if (iOS()) {
				iOS.test01_create_group();
			}
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group1().click();
			throw e;
		}
	}
	
	@Test
	public void test02_addBlockedUser() throws Exception {
		try {
			log("Test02 trying to add blocked user");
			android.test02_add_blocked_user();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group1().click();
			throw e;
		}
	}
		
	@Test
	public void test03_groupMembers() throws Exception {
		try {
			log("Test03 checking group members");
			android.test03_group_members();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group1().click();
			throw e;
		}
	}
	
	@Test
	public void test04_sendUsername() throws Exception {
		try {
			log("Test04 sending a +username");
			android.test04_send_username();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group1().click();
			throw e;
		}
	}
	
	@Test
	public void test05_sendPhoto() throws Exception {
		try {
			log("Test05 sending a photo");
			android.test05_send_photo();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group1().click();
			throw e;
		}
	}
		
	@Test
	public void test06_sendVideo() throws Exception {
		try {
			log("Test06 sending a video");
			android.test06_send_video();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group1().click();
			throw e;
		}
	}
	
	@Test
	public void test07_sendGiphy() throws Exception {
		try {
			log("Test07 sending a giphy");
			android.test07_send_giphy();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group1().click();
			throw e;
		}
	}
	
	@Test
	public void test08_sendGalleryPhoto() throws Exception {
		try {
			log("Test08 sending a picture from gallery");
			android.test08_send_gallery_photo();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group1().click();
			throw e;
		}
	}
	
	@Test
	public void test09_openGroupMessages() throws Exception {
		try {
			log("Test09 checking group messages");
			android.test09_open_group_messages();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		log("[Finish] Test complete\n");
	}
}