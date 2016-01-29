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
	public void test01_Sent_Dust_TimestampTest() throws Exception {
		log("[Start] Starting timestamp test");
		try {
			log("Test01");
			new Android_TimestampTest().test01_sent_dust_timestamp();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test02_Sent_GroupText_TimestampTest() throws Exception {
		try {
			log("Test02");
			new Android_TimestampTest().test02_sent_group_timestamp();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
	@Test
	public void test03_recieved_dust_TimestampTest() throws Exception {
		try {
			log("Test03");
			new Android_TimestampTest().test03_received_dust_timestamp();
		} catch (Exception e) {
			log("[Fail] Got exception " + e);
			relaunch();
			throw e;
		}
	}
}