package application;

import java.awt.Desktop;
import java.io.File;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.DefaultListModel;

public class LogFinder {
	static private String myDir = Paths.get("").toAbsolutePath().normalize().toString();
	static private DefaultListModel<String> fileList = new DefaultListModel<String>();
	static private DefaultListModel<String> rawList = new FileFinder().testFilePath(myDir, fileList);
	
	public void openLog(List<String> selectedTests) throws Exception {
		
		String projectPath = Paths.get("").toAbsolutePath().normalize().toString();
		String logLocation = new String();
		String testName = new String();
		String logName = new String();
		
		for (int i = 0; i < rawList.size(); i++) {
			testName = rawList.get(i).substring(rawList.get(i).indexOf("Run"), rawList.get(i).length()).replace("Run_", "").replace("Run", "");
			if (selectedTests.contains(testName)) {
				logName = rawList.get(i).substring(rawList.get(i).indexOf("tests"), rawList.get(i).indexOf("Run")-1).replace("/", ".").replace("\\", ".");
				
				if (projectPath.contains("/")) {
					logLocation = projectPath+"/testlogs/"+logName+".log";
				} else {
					logLocation = projectPath+"\\testlogs\\"+logName+".log";
				}
			}
		}
		
		try {
			Desktop.getDesktop().open(new File(logLocation));
		} catch (Exception e) {
			
		}
	}	
}
