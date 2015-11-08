package application;

import java.nio.file.Paths;
import java.util.List;
import javax.swing.DefaultListModel;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.RunListener;

public class TestFinder {
	static private String myDir = Paths.get("").toAbsolutePath().normalize().toString();
	static private DefaultListModel<String> fileList = new DefaultListModel<String>();
	static private DefaultListModel<String> rawList = new FileFinder().testFilePath(myDir, fileList);
	static private DefaultListModel<String> simpleList = new FileFinder().simpleFileList();
	
	// Finds test classes with "Run" in the name and adds them to the application
	public static void allTests(List<String> selectedTests) throws Exception {
		JUnitCore runTest = new JUnitCore();
		RunListener output = new RunListener();
		
		for (int i = 0; i < simpleList.size(); i++) {
			
			if (selectedTests.contains(simpleList.get(i))) {
				System.out.println("[Application]: Running "+simpleList.get(i));
				Class<?> myClass = Class.forName((rawList.get(i).replace(myDir, "").replace("\\tests", "tests")
						.replace("\\tests", "tests").replace("//tests", "tests").replace("\\", ".").replace("/", ".")));

				runTest.addListener(output);
				runTest.run(myClass);
			}
		}
	}
}
