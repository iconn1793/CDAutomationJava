package tests.timeout;
import org.junit.*;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_TimeOutTests extends Android_TimeOutTests {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Android_TimeOutTests android = new Android_TimeOutTests();
	
	@Test
	public void test01_TimeOutTest() throws Exception {
		log("[Start] Starting time out test");
		try {
			log("Test01: message expires");
			android.test01_video_timeout();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test02_TimeOutTest() throws Exception {
		try {
			log("Test01: message expires");
			android.test02_photo_timeout();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}
	
