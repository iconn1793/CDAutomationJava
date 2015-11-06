package tests.reblast;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_ReblastTest extends Android_ReblastTest {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Android_ReblastTest android = new Android_ReblastTest();
	
	@Test
	public void test01_sendTextWithLoc() throws Exception {
		log("[Start] Starting reblast test");
		try {
			log("Test01 sending text blasts with location");
			android.test01_send_text_with_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_sendTextNoLoc() throws Exception {
		try {
			log("Test02 sending text blasts without location");
			android.test02_send_text_no_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test03_sendPhotoWithLoc() throws Exception {
		try {
			log("Test03 sending photo blasts with location");
			android.test03_send_photo_with_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test04_sendPhotoNoLoc() throws Exception {
		try {
			log("Test04 sending photo blasts without location");
			android.test04_send_photo_no_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test05_sendGiphyWithLoc() throws Exception {
		try {
			log("Test05 sending giphy blasts with location");
			android.test05_send_giphy_with_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test06_sendGiphyNoLoc() throws Exception {
		try {
			log("Test06 sending giphy blasts without location");
			android.test06_send_giphy_no_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test07_sendVideoWithLoc() throws Exception {
		try {
			log("Test07 sending video blasts with location");
			android.test07_send_video_with_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test08_sendVideoNoLoc() throws Exception {
		try {
			log("Test08 sending video blasts without location");
			android.test08_send_video_no_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test09_reblastSetup() throws Exception {
		try {
			log("Test09 setting up for reblast test");
			android.test09_reblast_setup();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test10_reblastTextWithLoc() throws Exception {
		try {
			log("Test10 reblasting text blasts with location");
			android.test10_reblast_text_with_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test11_reblastTextNoLoc() throws Exception {
		try {
			log("Test11 reblasting text blasts without location");
			android.test11_reblast_text_no_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test12_reblastPhotoWithLoc() throws Exception {
		try {
			log("Test12 reblasting photo blasts with location");
			android.test12_reblast_photo_with_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test13_reblastPhotoNoLoc() throws Exception {
		try {
			log("Test13 reblasting photo blasts without location");
			android.test13_reblast_photo_no_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test14_reblastGiphyWithLoc() throws Exception {
		try {
			log("Test14 reblasting giphy blasts with location");
			android.test14_reblast_giphy_with_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test15_reblastGiphyNoLoc() throws Exception {
		try {
			log("Test15 reblasting giphy blasts without location");
			android.test15_reblast_giphy_no_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test16_reblastVideoWithLoc() throws Exception {
		try {
			log("Test16 reblasting video blasts with location");
			android.test16_reblast_video_with_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test17_reblastVideoNoLoc() throws Exception {
		try {
			log("Test17 reblasting video blasts without location");
			android.test17_reblast_video_no_loc();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test18_checkReblastCount() throws Exception {
		try {
			log("Test18 checking if all reblasts were received");
			android.test18_check_reblast_count();
			log("Test Complete");
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		log("[Finish] Test complete\n");
	}
}