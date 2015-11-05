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
	iOS_GroupTest iOS = new iOS_GroupTest();
	
	@Test
	public void test01_createGroup() throws Exception {
		try {
			log("Starting test01");
			if (Android()) {
				android.test01_create_group();
			} else if (iOS()) {
				iOS.test01_create_group();
			}
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group01().click();
			throw e;
		}
	}
	
	@Test
	public void test02_addBlockedUser() throws Exception {
		try {
			log("Starting test02");
			android.test02_add_blocked_user();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group01().click();
			throw e;
		}
	}
		
	@Test
	public void test03_groupMembers() throws Exception {
		try {
			log("Starting test03");
			android.test03_group_members();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group01().click();
			throw e;
		}
	}
	
	@Test
	public void test04_sendUsername() throws Exception {
		try {
			log("Starting test04");
			android.test04_send_username();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group01().click();
			throw e;
		}
	}
	
	@Test
	public void test05_sendPhoto() throws Exception {
		try {
			log("Starting test05");
			android.test05_send_photo();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group01().click();
			throw e;
		}
	}
		
	@Test
	public void test06_sendVideo() throws Exception {
		try {
			log("Starting test06");
			android.test06_send_video();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group01().click();
			throw e;
		}
	}
	
	@Test
	public void test07_sendGiphy() throws Exception {
		try {
			log("Starting test07");
			android.test07_send_giphy();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group01().click();
			throw e;
		}
	}
	
	@Test
	public void test08_sendGalleryPhoto() throws Exception {
		try {
			log("Starting test08");
			android.test08_send_gallery_photo();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group01().click();
			throw e;
		}
	}
	
	@Test
	public void test09_openGroupMessages() throws Exception {
		try {
			log("Starting test09");
			android.test09_open_group_messages();
			log("Test Complete");
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}