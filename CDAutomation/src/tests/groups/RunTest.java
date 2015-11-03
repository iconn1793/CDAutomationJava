package tests.groups;

import org.junit.*;
import org.junit.runners.MethodSorters;
import elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RunTest extends GroupTest {
	
	Drivers element = new Drivers();
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
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
	public void test04_sendGroupMessages() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test04");
			test04_send_group_messages();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			element.groups_tab().click();
			element.group01().click();
			throw e;
		}
	}
		
	@Test
	public void test05_openGroupMessages() throws Exception {
		try {
			System.out.println("[GroupTest] Starting test05");
			test05_open_group_messages();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}