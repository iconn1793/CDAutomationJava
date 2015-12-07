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
	
	static public String currentTest = "";
	static public String failResult = "";
	static public String passResult = "";
	
	// Finds test method names
	public static List<String> getTestMethods(List<String> selectedTests) throws Exception {
		Class<?> myClass = application.TestListener.class;
		
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
					String className = classM[i].getDeclaringClass().getSimpleName().replace("Run", "").replace("_", "");
					String classMethods = classM[i].getName();
					
					if (!methodList.contains(className)) {
						methodList.add(className);
					}
					methodList.add(classMethods);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.sort(methodList);
		return methodList;
	}
	
	public void testStarted (Description description) throws Exception {
		currentTest = description.getMethodName();
	}
	
	public void testFailure (Failure failure) throws Exception {
<<<<<<< HEAD
		 testResult = failure.getDescription().getMethodName();
		 System.out.println("[FAIL] "+failure.getDescription().getMethodName()+": "+failure.getMessage()+"\n");
		 
		 
=======
		failResult = failure.getDescription().getMethodName();
	}
	
	public void testFinished (Description description) throws Exception {
		if (!description.getMethodName().equals(failResult)) {
			passResult = description.getMethodName();
		}
>>>>>>> branch 'master' of https://github.com/BrantK/CDAutomationJava.git
	}
	
	public void testRunFinished (Result result) throws Exception {
		currentTest = "done";
	}
	
	public String runningTest() {
		while (currentTest.length() == 0 || currentTest == "done") {
			System.out.flush();
		}
		return currentTest;
	}
	
	public String failedTests() {
		return failResult;
	}
	
	public String passedTests() {
		return passResult;
	}
}
