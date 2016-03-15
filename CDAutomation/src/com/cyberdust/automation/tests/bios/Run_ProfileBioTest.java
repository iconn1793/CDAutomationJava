package com.cyberdust.automation.tests.bios;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_ProfileBioTest extends Drivers {
	
	@Test
	public void test01_textBio() throws Exception {
		
		try {
			System.out.println("Starting test - Editing bio using text");
			
			if (Android()) {
				new Android_ProfileBioTest().test01_text_bio();
			} else if (IOS()) {
				new IOS_ProfileBioTest().test01_text_bio();
			}
			
		}
		catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}	
}