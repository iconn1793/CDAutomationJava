package tests.groups;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_GroupTests extends Android_GroupTests {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Android_GroupTests android = new Android_GroupTests();
	iOS_GroupTests iOS = new iOS_GroupTests();
	
	@Test
	public void test01_createGroup() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test01");
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
			System.out.println("[GroupTest] Starting test02");
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
			System.out.println("[GroupTest] Starting test03");
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
	public void test04_sendUsernamePhoto() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test04");
			android.test04_send_username_photo();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group01().click();
			throw e;
		}
	}
		
	@Test
	public void test05_sendVideoGiphy() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test05");
			android.test05_send_video_giphy();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group01().click();
			throw e;
		}
	}
	
	@Test
	public void test06_sendGalleryPhoto() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test06");
			android.test06_send_gallery_photo();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			groups_tab().click();
			group01().click();
			throw e;
		}
	}
	
	@Test
	public void test07_openGroupMessages() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test07");
			android.test07_open_group_messages();
			System.out.println("Test Complete");
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}