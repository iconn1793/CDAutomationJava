package application;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

public class FileFinder {
	
	// For custom test list order, add tests here from top to bottom
	public List<String> testOrder () {
		List<String> myOrder = new ArrayList<String>();
		
		//////////////////////////////
		myOrder.add("run_signup");
		myOrder.add("run_blasttest");
		//////////////////////////////

		return myOrder;
	}
	
	// Gets the absolute file path
	public DefaultListModel<String> testFilePath (String dirName, DefaultListModel<String> files) {
		DefaultListModel<String> myList = new DefaultListModel<String>();
	    File dir = new File(dirName);

	    // Get all files from directory and sub directories
	    File[] fList = dir.listFiles();
	    for (File file : fList) {
	        if (file.isFile() && file.getAbsolutePath().contains("Run")) {
	            files.addElement(file.getAbsolutePath().replace("bin", "").replace("src", "").replace(".java", "").replace(".class", ""));
	        } else if (file.isDirectory()) {
	            testFilePath(file.getAbsolutePath(), files);
	        }
	    }
	    for (int i = 0; i < files.size(); i++) {
    		if (!myList.contains(files.elementAt(i))) {
    			myList.add(i, files.getElementAt(i));
	    	}
	    }
	    
	    // Puts the specified tests from testOrder() at the top of the list
	    List<String> sortedList = new ArrayList<String>();
	    for (int i = 0; i < myList.size(); i++) {
	    	sortedList.add(myList.get(i));
	    }
	    
	    myList.removeAllElements();
	    for (String list : sortedList) {
	    	
	    	for (int i = 0; i < testOrder().size(); i++) {
	    		if (list.toLowerCase().contains(testOrder().get(i))) {
		    		myList.add(0, list);
	    		}
	    	}
	    	
	    	if (!myList.contains(list)) {
	    		myList.addElement(list);
	    	}
	    }
	    
		return myList;
	}
	
	// Removes the path and extension
	public DefaultListModel<String> simpleFileList() {
		String myDir = Paths.get("").toAbsolutePath().normalize().toString();
		DefaultListModel<String> fileList = new DefaultListModel<String>();
		DefaultListModel<String> rawList = new FileFinder().testFilePath(myDir, fileList);
		DefaultListModel<String> simpleList = new DefaultListModel<String>();
		
		for (int i = 0; i < rawList.size(); i++) {
			 simpleList.addElement(rawList.get(i).substring(rawList.get(i).indexOf("Run"), rawList.get(i).length()).replace("Run_", "").replace("Run", ""));
		}
		
		return simpleList;	
	}
}
