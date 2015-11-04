package tests.reblast;

import org.junit.*;
import org.junit.runners.MethodSorters;
import elements.Drivers;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RunReblastTests extends ReblastTests {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Drivers element = new Drivers();
	
	@Test
	public void test01_sendTextWithLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test01");
			test01_send_text_with_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_sendTextNoLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test02");
			test02_send_text_no_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test03_sendPhotoWithLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test03");
			test03_send_photo_with_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test04_sendPhotoNoLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test04");
			test04_send_photo_no_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test05_sendGiphyWithLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test05");
			test05_send_giphy_with_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test06_sendGiphyNoLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test06");
			test06_send_giphy_no_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test07_sendVideoWithLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test07");
			test07_send_video_with_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test08_sendVideoNoLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test08");
			test08_send_video_no_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test09_reblastSetup() throws Exception {
		try {
			System.out.println("[Reblast] Starting test09");
			test09_reblast_setup();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test10_reblastTextWithLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test10");
			test10_reblast_text_with_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test11_reblastTextNoLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test11");
			test11_reblast_text_no_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test12_reblastPhotoWithLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test12");
			test12_reblast_photo_with_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test13_reblastPhotoNoLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test13");
			test13_reblast_photo_no_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test14_reblastGiphyWithLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test14");
			test14_reblast_giphy_with_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test15_reblastGiphyNoLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test15");
			test15_reblast_giphy_no_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test16_reblastVideoWithLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test16");
			test16_reblast_video_with_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test17_reblastVideoNoLoc() throws Exception {
		try {
			System.out.println("[Reblast] Starting test17");
			test17_reblast_video_no_loc();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test18_checkReblastCount() throws Exception {
		try {
			System.out.println("[Reblast] Starting test18");
			test18_check_reblast_count();
			System.out.println("Test Complete");
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}