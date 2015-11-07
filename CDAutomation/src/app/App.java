package app;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import org.junit.runner.JUnitCore;
import tests.blasts.Run_BlastTest;

public class App {
	// List<File> myTestList =
	// FileFinder.myList(Paths.get("").toAbsolutePath().toString());
	private JFrame myFrame;

	// String BlastTest = new
	// Run_BlastTest().getClass().getSimpleName().replace("Run_", "");

	public void allTests(List<String> myTests) throws Exception {
		if (myTests.contains("BlastTest")) {
			// new Run_BlastTest().test01_sendTextBlasts();
			System.out.println("Running blast test");
			JUnitCore.runClasses(Run_BlastTest.class);
		}
	}

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App window = new App();
					window.myFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application.
	public App() {
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {
		myFrame = new JFrame();
		myFrame.setTitle("CD Automation");
		myFrame.setBounds(100, 100, 300, 300);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.getContentPane().setLayout(null);

		// Add file list here
		DefaultListModel<String> testList = new DefaultListModel<String>();
		testList.addElement("BlastTest");
		testList.addElement("Some other thing");

		JList<String> list = new JList<String>(testList);
		list.setBounds(10, 21, 137, 181);
		myFrame.getContentPane().add(list);
		// Drag and drop rearrange - TODO
		list.setDropMode(DropMode.INSERT);
		list.setDragEnabled(true);

		JButton runButton = new JButton("Run");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> selectedTests = list.getSelectedValuesList();
				try {
					allTests(selectedTests);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		runButton.setBounds(106, 228, 89, 23);
		myFrame.getContentPane().add(runButton);

	}
}
