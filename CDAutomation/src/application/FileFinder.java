package application;

import java.io.File;
import java.nio.file.Paths;
import javax.swing.DefaultListModel;

public class FileFinder {
	
	// Gets the absolute file path
	public DefaultListModel<String> testFilePath (String dirName, DefaultListModel<String> files) {
		DefaultListModel<String> myList = new DefaultListModel<String>();
	    File dir = new File(dirName);

	    // Get all files from directory and sub directories
	    File[] fList = dir.listFiles();
	    for (File file : fList) {
	        if (file.isFile() && file.getAbsolutePath().contains("Run") || file.getAbsolutePath().contains("run")) {
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
		return myList;
	}
	
	// Gets the simple file name
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
