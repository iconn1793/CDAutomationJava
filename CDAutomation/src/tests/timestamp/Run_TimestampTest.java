package tests.timestamp;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import tests.timestamp.Android_TimestampTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Run_TimestampTest extends Android_TimestampTest {
	
	public static void relaunch() {
		driver.closeApp();
		driver.launchApp();
	}
	
	@Test
	public void test01_TimestampTest() throws Exception {
		log("[Start] Starting timestamp test");
		try {
			log("Test01");
			new Android_TimestampTest().test01_timestamp_test();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}