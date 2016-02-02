package tests.myBlasts;

import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_MyBlastsTest extends Android_MyBlastsTest {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	@Test
	public void test01_sendTextBlast() throws Exception {
		log("[Start] Starting My Blasts test");
		try {
			log("[Test01]");
			new Android_MyBlastsTest().test01_send_text_blast();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test02_sendPhotoBlast() throws Exception {
		try {
			log("[Test02]");
			new Android_MyBlastsTest().test02_send_photo_blast();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test03_sendVideoBlast() throws Exception {
		try {
			log("[Test03]");
			new Android_MyBlastsTest().test03_send_video_blast();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test04_viewBlastsFromHomepage() throws Exception {
		try {
			log("[Test04]");
			new Android_MyBlastsTest().test04_view_blasts_from_homepage();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test05_viewBlastsFromProfile() throws Exception {
		try {
			log("[Test05]");
			new Android_MyBlastsTest().test05_view_blasts_from_profile();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test06_viewBlastsFromSwipeView() throws Exception {
		try {
			log("[Test06]");
			new Android_MyBlastsTest().test06_view_blasts_from_swipe_view();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	
	@Test
	public void test07_checkViewsAndScreenshots() throws Exception {
		try {
			log("[Test07]");
			new Android_MyBlastsTest().test07_check_views_and_screenshots();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}
