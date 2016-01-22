package elements;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestLog {
	public String newText = new String();

	public void myLog(String text) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy HH:mm:ss");
		String projectPath = Paths.get("").toAbsolutePath().normalize().toString();
		String logLocation = new String();
		
		String dateTime = LocalDateTime.now().format(formatter)+" ";
		String logName = getClass().getPackage().toString().replace("package ", "");
		String testName = ("["+getClass().getSimpleName()+"]: ").replace("Run_", "").replace("Run", "").replace("Android_", "").replace("iOS_", "");
		
		if (projectPath.contains("/")) {
			new File(projectPath+"/testlogs/").mkdir();
			logLocation = projectPath+"/testlogs/"+logName+".log";
		} else {
			new File(projectPath+"\\testlogs\\").mkdir();
			logLocation = projectPath+"\\testlogs\\"+logName+".log";
		}
		
//		if (text.toLowerCase().contains("fail") || text.toLowerCase().contains("exception") 
//				|| text.toLowerCase().contains("warning") || text.toLowerCase().contains("error")) {
//			System.err.print(dateTime + testName + text + "\n");
//		} else {
//			System.out.print(dateTime + testName + text + "\n");
//		}
		
		newText = dateTime + testName + text + "\n";
		
		FileWriter myWriter = new FileWriter(logLocation, true);
		myWriter.append(dateTime + testName + text + "\n");
		myWriter.close();
		
	}
	
	public String logText() {
		return newText;
	}
}
