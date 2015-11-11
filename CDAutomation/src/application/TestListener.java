package application;

import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.DefaultListModel;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TestListener extends RunListener {
	static private String myDir = Paths.get("").toAbsolutePath().normalize().toString();
	static private DefaultListModel<String> fileList = new DefaultListModel<String>();
	static private DefaultListModel<String> rawList = new FileFinder().testFilePath(myDir, fileList);
	static private DefaultListModel<String> simpleList = new FileFinder().simpleFileList();
	
	// Finds test method names
	public static List<String> getTestMethods(List<String> selectedTests) throws Exception {
		Class<?> myClass = application.TestExecuter.class;
		for (int i = 0; i < simpleList.size(); i++) {
			if (selectedTests.contains(simpleList.get(i))) {
				myClass = Class.forName((rawList.get(i).substring(rawList.get(i).indexOf("tests"), rawList.get(i).length()).replace("\\", ".").replace("/", ".")));
			}
		}

		List<String> methodList = new ArrayList<String>();
		Class<?> tClass = myClass;
		Method[] classM = tClass.getDeclaredMethods();
		
		try {
			for (int i = 0; i < classM.length; i++) {
				String classM_New = classM[i].getName().toLowerCase();
				if (classM_New.contains("test0") || classM_New.contains("test1") || classM_New.contains("test2")) {
					methodList.add(classM[i].getName());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(methodList);
		System.out.print(methodList);
		return methodList;
	}
	
	public void testRunStarted(Description description)	throws Exception
	{
		System.out.println("Number of testcases to execute : " + description.testCount());
	}

}
