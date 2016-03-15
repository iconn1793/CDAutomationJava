package com.cyberdust.automation.tests.tutorial;

import org.junit.*;
import org.junit.runners.MethodSorters;

import com.cyberdust.automation.elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_TutorialTest extends Drivers {

	@Test
	public void test01_delete_all_chatrooms() throws Exception {
		log("[Start] Starting Tutorial test");
		try {
			log("Test01 Tutorial UI");

			if (Android()) {
				new Android_TutorialTest().test01_tutorialUI();
			} else if (IOS()) {
				new IOS_TutorialTest().test01_tutorialUI();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_TutorialFunctionality() throws Exception {
		try {
			log("Test01 Tutorial Functionality");

			if (Android()) {
				new Android_TutorialTest().test02_tutorialFunctionality();
			} else if (IOS()) {
				new IOS_TutorialTest().test02_tutorialFunctionality();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}