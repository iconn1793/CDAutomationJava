package application;

import java.lang.reflect.Field;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.DefaultListModel;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.RunNotifier;

public class TestExecuter {
	private static String myDir = Paths.get("").toAbsolutePath().normalize().toString();
	private static DefaultListModel<String> fileList = new DefaultListModel<String>();
	private static DefaultListModel<String> rawList = new FileFinder().testFilePath(myDir, fileList);
	private static DefaultListModel<String> simpleList = new FileFinder().simpleFileList();
	private static JUnitCore junit = new JUnitCore();
	public static String serverErrorMessage = "";
	public static int y =0;
	
	// Finds test classes with "Run" in the name and adds them to the application
	public static void runTests (List<String> selectedTests,int x) throws Exception {
		serverErrorMessage = "Failed to establish connection to Appium server.\n";
		y=x;
		for (int i = 0; i < simpleList.size(); i++) {
			
			if (selectedTests.contains(simpleList.get(i))) {
				System.out.println("[Application]: Starting "+simpleList.get(i));

				Class<?> myClass = Class.forName((rawList.get(i).substring(rawList.get(i).indexOf("tests"), rawList.get(i).length()).replace("\\", ".").replace("/", ".")));
				junit.addListener(new application.TestListener());
				
				try {
					junit.run(myClass);
					elements.Drivers.driver.quit();
				} catch (NullPointerException e) {
					System.err.println(serverErrorMessage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void stopTests () {
		try {
			Field field = JUnitCore.class.getDeclaredField("notifier");
			field.setAccessible(true);
			RunNotifier runNotifier = (RunNotifier) field.get(junit);
			runNotifier.pleaseStop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
