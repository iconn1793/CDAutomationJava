package tests.blasts;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_BlastTest extends Android_BlastTest {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Android_BlastTest android = new Android_BlastTest();
	
	@Test
	public void test01_createBlastList() throws Exception {
		log("[Start] Starting blast test");
		try {
			log("Test01 creating blast list");
			android.test01_create_blast_list();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_sendTextBlasts() throws Exception {
		try {
			log("Test02 sending text blasts");
			android.test02_send_text_blasts();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test03_sendPhotoBlast1() throws Exception {
		try {
			log("Test03 sending photo blast1");
			android.test03_send_photo_blast_01();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test04_sendPhotoBlast2() throws Exception {
		try {
			log("Test04 sending photo blast2");
			android.test04_send_photo_blast_02();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test05_sendGiphyBlast() throws Exception {
		try {
			log("Test05 sending giphy blast");
			android.test05_send_giphy_blast();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test06_sendVideoBlast1() throws Exception {
		try {
			log("Test06 sending video blast1");
			android.test06_send_video_blast_01();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test07_sendVideoBlast2() throws Exception {
		try {
			log("Test07 sending video blast2");
			android.test07_send_video_blast_02();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test08_sendTextForReplies() throws Exception {
		try {
			log("Test08 sending text blast for reply test");
			android.test08_send_text_for_replies();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test09_openTextBlast() throws Exception {
		try {
			log("Test09 opening text blasts");
			android.test09_open_text_blast();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			name(account01).click(); 
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test10_openPhotoBlast() throws Exception {
		try {
			log("Test10 opening photo blasts");
			android.test10_open_photo_blast();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			name(account01).click(); 
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test11_openNonPublicBlast() throws Exception {
		try {
			log("Test11 openinig non public blast");
			android.test11_open_non_public_blast();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			name(account01).click(); 
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test12_openGiphyBlast() throws Exception {
		try {
			log("Test12 opening giphy blast");
			android.test12_open_giphy_blast();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			name(account01).click(); 
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test13_openVideoBlast() throws Exception {
		try {
			log("Test13 opening video blasts");
			android.test13_open_video_blast();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			name(account01).click(); 
			Thread.sleep(1000);
			throw e;
		}
	}
	
	@Test
	public void test14_replyToBlast() throws Exception {
		try {
			log("Test14 replying to blast");
			android.test14_reply_to_blast();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test15_checkReplies() throws Exception {
		try {
			log("Test15 checking if replies were received");
			android.test15_check_replies();
			log("Test Complete");
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
		log("[Finish] Test complete\n");
	}
}