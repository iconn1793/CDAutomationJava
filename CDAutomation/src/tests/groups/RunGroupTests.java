package tests.groups;

import org.junit.*;
import org.junit.runners.MethodSorters;
import elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RunGroupTests extends GroupTests {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Drivers element = new Drivers();
	
	@Test
	public void test01_createGroup() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test01");
			test01_create_group();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			element.groups_tab().click();
			element.group01().click();
			throw e;
		}
	}
	
	@Test
	public void test02_addBlockedUser() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test02");
			test02_add_blocked_user();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			element.groups_tab().click();
			element.group01().click();
			throw e;
		}
	}
		
	@Test
	public void test03_groupMembers() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test03");
			test03_group_members();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			element.groups_tab().click();
			element.group01().click();
			throw e;
		}
	}
	
	@Test
	public void test04_sendUsernamePhoto() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test04");
			test04_send_username_photo();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			element.groups_tab().click();
			element.group01().click();
			throw e;
		}
	}
		
	@Test
	public void test05_sendVideoGiphy() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test05");
			test05_send_video_giphy();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			element.groups_tab().click();
			element.group01().click();
			throw e;
		}
	}
	
	@Test
	public void test06_sendGalleryPhoto() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test06");
			test06_send_gallery_photo();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			element.groups_tab().click();
			element.group01().click();
			throw e;
		}
	}
	
	@Test
	public void test07_openGroupMessages() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test07");
			test07_open_group_messages();
			System.out.println("Test Complete");
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}