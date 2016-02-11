package elements;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class VariableCheck {
	
	// Checks if Android_Home is set for Mac OS X
	public void environmentVariable() throws Exception {
		if (System.getProperty("os.name").toLowerCase().contains("mac")) {
			
			if (System.getenv("ANDROID_HOME") == null || !System.getenv("ANDROID_HOME").contains("/")) {
				File bashProfile = new File (System.getenv("HOME")+"/.bash_profile");
				FileWriter setenvWriter = new FileWriter(bashProfile, true);
				
				Scanner bashProfileScanner = new Scanner(bashProfile);
				String bashProfileContent = bashProfileScanner.useDelimiter("//Z").next();
				
				System.err.println("\n###### Environment variable updated!\n"
						+ "###### Please restart your IDE!");
				
				if (!bashProfileContent.contains("launchctl setenv ANDROID_HOME $ANDROID_HOME")) {
					setenvWriter.append("\nlaunchctl setenv ANDROID_HOME $ANDROID_HOME");
					setenvWriter.close();
					bashProfileScanner.close();
				} else {
					bashProfileScanner.close();
				}
			}
		}
	}
}
