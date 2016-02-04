package elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeviceReader {
	
	public static boolean runningIOSDevice;
	public static boolean runningAndroidDevice;
	public static String IOS_UDID;
	
	public void checkDevice () throws Exception {
		String output = null;
		
		ProcessBuilder processBuilder = new ProcessBuilder("system_profiler", "SPUSBDataType");
		Process process = processBuilder.start();
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		while ((output = stdInput.readLine()) != null) {
			if (output.toLowerCase().contains("iphone")) {
				runningIOSDevice = true;
				runningAndroidDevice = false;
			}
			
			if (output.toLowerCase().contains("android")) {
				runningAndroidDevice = true;
				runningIOSDevice = false;
			}
			
			if (output.toLowerCase().contains("serial") && output.length() > 45) {
				IOS_UDID = output.replace("          Serial Number: ", "");
			}
		}
	}
}
