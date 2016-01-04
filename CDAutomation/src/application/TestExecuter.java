package application;

import java.lang.reflect.Field;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.DefaultListModel;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.RunNotifier;

public class TestExecuter {
	static private String myDir = Paths.get("").toAbsolutePath().normalize().toString();
	static private DefaultListModel<String> fileList = new DefaultListModel<String>();
	static private DefaultListModel<String> rawList = new FileFinder().testFilePath(myDir, fileList);
	static private DefaultListModel<String> simpleList = new FileFinder().simpleFileList();
	static private JUnitCore junit = new JUnitCore();
	
	// Finds test classes with "Run" in the name and adds them to the application
	public static void runTests (List<String> selectedTests) throws Exception {
		for (int i = 0; i < simpleList.size(); i++) {
			
			if (selectedTests.contains(simpleList.get(i))) {
				System.out.println("[Application]: Starting "+simpleList.get(i));

				Class<?> myClass = Class.forName((rawList.get(i).substring(rawList.get(i).indexOf("tests"), rawList.get(i).length()).replace("\\", ".").replace("/", ".")));
				junit.addListener(new application.TestListener());
				
				try {
					junit.run(myClass);
					elements.Drivers.callDriver().quit();
				} catch (NullPointerException e) {
					System.err.println("Could not start test! Check if the server is running.\n");
				}
			}
		}
	}
	
	public void stopTests () {
		try {
			Field field = JUnitCore.class.getDeclaredField("notifier");
			field.setAccessible(true);
			RunNotifier restNotifier = (RunNotifier) field.get(junit);
			restNotifier.pleaseStop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
