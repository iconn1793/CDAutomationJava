package application;

import application.AutomationApp;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.DefaultListModel;
import org.junit.runner.JUnitCore;


public class TestExecuter extends AutomationApp {
	static private String myDir = Paths.get("").toAbsolutePath().normalize().toString();
	static private DefaultListModel<String> fileList = new DefaultListModel<String>();
	static private DefaultListModel<String> rawList = new FileFinder().testFilePath(myDir, fileList);
	static private DefaultListModel<String> simpleList = new FileFinder().simpleFileList();

	// Finds test classes with "Run" in the name and adds them to the application
	public static void allTests(List<String> selectedTests) throws Exception {
		JUnitCore junit = new JUnitCore();
		
		for (int i = 0; i < simpleList.size(); i++) {
			
			if (selectedTests.contains(simpleList.get(i))) {
				System.out.println("[Application]: Starting "+simpleList.get(i));
				Class<?> myClass = Class.forName((rawList.get(i).substring(rawList.get(i).indexOf("tests"), rawList.get(i).length()).replace("\\", ".").replace("/", ".")));
				junit.addListener(new application.TestListener());
				try {
					junit.run(myClass);
					elements.Drivers.callDriver().quit();
				} catch (Exception e) {
					e.printStackTrace();
					throw e;
				}
			}
		}
	}
}
