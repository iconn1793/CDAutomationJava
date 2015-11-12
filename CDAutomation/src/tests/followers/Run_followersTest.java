package tests.followers;
import org.junit.*;
import org.junit.runners.MethodSorters;


public class Run_followersTest extends Android_followersTest{
	
	

	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	Android_followersTest android = new Android_followersTest();

	@Test
	public void test01_addFriends() throws Exception {
		log("[Start] Starting blast test");
		try {
			log("Test01: Adding a friend from followers menu");
			android.test01_add_friends();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test02_addFriends02() throws Exception {
		log("[Start] Starting blast test");
		try {
			log("Test01: Adding a friend from followers menu");
			android.test01_add_friends();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			throw e;
		}
	}
}