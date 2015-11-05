package tests.blasts;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_BlastTests extends Android_BlastTests {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Android_BlastTests android = new Android_BlastTests();
	
	@Test
	public void test01_sendTextBlasts() throws Exception {
		try {
			log("Starting test01");
			android.test01_send_text_blasts();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_sendPhotoBlast1() throws Exception {
		try {
			log("Starting test02");
			android.test02_send_photo_blast_01();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_sendPhotoBlast2() throws Exception {
		try {
			log("Starting test03");
			android.test03_send_photo_blast_02();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test04_sendGiphyBlast() throws Exception {
		try {
			log("Starting test04");
			android.test04_send_giphy_blast();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test05_sendVideoBlast1() throws Exception {
		try {
			log("Starting test05");
			android.test05_send_video_blast_01();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test06_sendVideoBlast2() throws Exception {
		try {
			log("Starting test06");
			android.test06_send_video_blast_02();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test07_sendTextForReplies() throws Exception {
		try {
			log("Starting test07");
			android.test07_send_text_for_replies();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test08_openTextBlast() throws Exception {
		try {
			log("Starting test08");
			android.test08_open_text_blast();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			name(account01).click(); 
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test09_openPhotoBlast() throws Exception {
		try {
			log("Starting test09");
			android.test09_open_photo_blast();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			name(account01).click(); 
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test10_openNonPublicBlast() throws Exception {
		try {
			log("Starting test10");
			android.test10_open_non_public_blast();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			name(account01).click(); 
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test11_openGiphyBlast() throws Exception {
		try {
			log("Starting test11");
			android.test11_open_giphy_blast();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			name(account01).click(); 
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test12_openVideoBlast() throws Exception {
		try {
			log("Starting test12");
			android.test12_open_video_blast();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			name(account01).click(); 
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test13_replyToBlast() throws Exception {
		try {
			log("Starting test13");
			android.test13_reply_to_blast();
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test14_checkReplies() throws Exception {
		try {
			log("Starting test14");
			android.test14_check_replies();
			log("Test Complete");
		} catch (Exception e) {
			System.err.println("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}