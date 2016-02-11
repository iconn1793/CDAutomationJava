package elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DeviceReader {
	
	public static boolean IOSDevice;
	public static boolean AndroidDevice;
	public static String IOS_UDID;
	
	public void checkDevice () throws Exception {
		String output = null;
		
		ProcessBuilder processBuilder = new ProcessBuilder("system_profiler", "SPUSBDataType");
		Process process = processBuilder.start();
		BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		while ((output = stdInput.readLine()) != null) {
			
			if (output.toLowerCase().contains("serial") && output.length() > 45) {
				IOS_UDID = output.replace("          Serial Number: ", "");
			}
			
			if (output.toLowerCase().contains("iphone")) {
				IOSDevice = true;
				AndroidDevice = false;
			}
			
			if (output.toLowerCase().contains("android")) {
				AndroidDevice = true;
				IOSDevice = false;
			}
			
		}
		
		processBuilder = new ProcessBuilder(System.getenv("ANDROID_HOME")+"/platform-tools/adb", "devices");
		process = processBuilder.start();
		stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
		
		if (!IOSDevice && !AndroidDevice) {
			while ((output = stdInput.readLine()) != null) {
				if (!output.contains("List of devices attached") && !output.isEmpty()) {
					AndroidDevice = true;
					IOSDevice = false;
				}
			}
		}
	}
}
