package tests.accountManagement;

import org.junit.*;
import org.junit.runners.MethodSorters;
import elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_AccountManagement extends Android_AccountManagementTest{
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
Drivers element = new Drivers();
	
	@Test
	public void test01_ChangePassword() throws Exception
	{
		try{
			System.out.println("Starting test - Change account password");
			test01_changing_password();
		}
		catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		
	}
	@Test
	public void test02_ChangeEmail() throws Exception
	{
		try{
			System.out.println("Starting test - change account email");
			test02_changing_email();
		}
		catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		
	}
	@Test
	public void test03_AccountDeleting() throws Exception
	{
		try{
			System.out.println("Starting test - delete account");
			test03_account_deleting();
		}
		catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			throw e;
		}
		
	}
	
	
}