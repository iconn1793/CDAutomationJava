package tests.bios;

import org.junit.*;
import org.junit.runners.MethodSorters;
import elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_ProfileBioTest extends Android_ProfileBioTest{
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
Drivers element = new Drivers();
	
	@Test
	public void test01_textBio() throws Exception
	{
		try{
			System.out.println("Starting test - Editing bio using text");
			test01_text_bio();
		}
		catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		
	}
	
	
	
}