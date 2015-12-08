package tests.urlShortner;

import org.junit.*;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_UrlShortnerTest extends Android_UrlShortnerTest {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Android_UrlShortnerTest android = new Android_UrlShortnerTest();
	iOS_UrlShortnerTest iOS = new iOS_UrlShortnerTest();
	@Test
	public void test01_websiteAddress() throws Exception {
		log("[Start] Starting url shortener test");
		try {
			log("Test01 entering website address");
			if (Android()) {
				android.test01_shortned_bio();
			} else if (iOS()) {
				iOS.test01_shortned_bio();
			}
		} catch (Exception e) {
			log("first test failed");
			log("[Fail] Got exception " + e);
			relaunch();
			more_button().click();
			throw e;
		}
	}
	
	@Test
	public void test02_shortURL() throws Exception {
		log("[Start] Starting enter-short URL test");
		try {
			log("Test02 entering short website address");
			if (Android()) {
				android.test02_shortned_bio();
			} else if (iOS()) {
				iOS.test01_shortned_bio();
			}
		} catch (Exception e) {
	
			log("[Fail] Got exception " + e);
			
		}
	}
	
}
	