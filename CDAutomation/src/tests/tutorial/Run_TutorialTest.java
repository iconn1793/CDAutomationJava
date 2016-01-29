package tests.tutorial;
import org.junit.*;
import org.junit.runners.MethodSorters;

import tests.tutorial.Android_TutorialTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_TutorialTest extends Android_TutorialTest {

	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
		
	}
	Android_TutorialTest android = new Android_TutorialTest();
	
	@Test
	public void test01_delete_all_chatrooms() throws Exception {
		log("[Start] Starting Tutorial test");
		try {
			log("Test01 Tutorial UI");
			android.test01_tutorialUI();
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
			android.test02_tutorialFunctionality();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	
	
	
}
	