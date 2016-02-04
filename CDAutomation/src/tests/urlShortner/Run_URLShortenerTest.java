package tests.urlShortner;

import org.junit.*;
import org.junit.runners.MethodSorters;

import elements.Drivers;
import tests.groups.Android_GroupTest;
import tests.groups.IOS_GroupTest;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_URLShortenerTest extends Drivers {
	
	@Test
	public void test01_websiteAddress() throws Exception {
		log("[Start] Starting url shortener test");
		try {
			log("Test01 entering website address");
			
			if (Android()) {
				new Android_URLShortenerTest().test01_shortned_bio();
			} else if (IOS()) {
				new IOS_URLShortenerTest().test01_shortned_bio();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			
			if (Android()) {
				new Android_GroupTest().more_button().click();
			}
			if (IOS()) {
				new IOS_GroupTest().more_button().click();
			}
			
			throw e;
		}
	}
	
	@Test
	public void test02_shortURL() throws Exception {
		log("[Start] Starting enter-short URL test");
		try {
			log("Test02 entering short website address");

			if (Android()) {
				new Android_URLShortenerTest().test02_shortned_bio();
			} else if (IOS()) {
				new IOS_URLShortenerTest().test02_shortned_bio();
			}
			
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			throw e;
		}
	}
	
}
	