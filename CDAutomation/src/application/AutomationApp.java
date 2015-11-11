package application;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.ListSelectionModel;

public class AutomationApp {
	private JFrame myFrame;

	// Launch the application.
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AutomationApp window = new AutomationApp();
					window.myFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Create the application.
	public AutomationApp() {
		initialize();
	}

	// Initialize the contents of the frame.
	private void initialize() {
		myFrame = new JFrame();
		myFrame.setResizable(false);
		myFrame.setTitle("CD Automation");
		myFrame.setBounds(300, 300, 500, 400);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.getContentPane().setLayout(null);

		// List of test files
		DefaultListModel<String> simpleList = new FileFinder().simpleFileList();
		JList<String> listOfTests = new JList<String>(simpleList);
		JScrollPane testListScroll = new JScrollPane();
		listOfTests.setFont(new Font("Arial", Font.PLAIN, 11));
		testListScroll.setViewportView(listOfTests);
		testListScroll.setBounds(10, 10, 150, 181);
		listOfTests.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tests", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		myFrame.getContentPane().add(testListScroll);
		
		// Drag and drop rearrange - TODO
		listOfTests.setDropMode(DropMode.INSERT);
		listOfTests.setDragEnabled(true);

		// Console output window
		JTextPane consoleOut = new JTextPane();
		consoleOut.setBackground(Color.LIGHT_GRAY);
		consoleOut.setEditable(false);
		consoleOut.setBounds(10, 203, 464, 118);
		consoleOut.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		myFrame.getContentPane().add(consoleOut);

		// Open log button
		JButton logButton = new JButton("Open Log");
		logButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> selectedTests = listOfTests.getSelectedValuesList();
				try {
					new application.LogFinder().openLog(selectedTests);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		logButton.setBounds(100, 326, 90, 25);
		myFrame.getContentPane().add(logButton);
		
		// JUnit output window - TODO Change from JList 
		DefaultListModel<String> methodList = new DefaultListModel<String>();
		JList<String> junitOut = new JList<String>(methodList);
		junitOut.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		junitOut.setFont(new Font("Arial", Font.PLAIN, 11));
		junitOut.setBackground(Color.WHITE);
		junitOut.setFocusable(false);
		JScrollPane junitScroll = new JScrollPane();
		junitScroll.setViewportView(junitOut);
		junitScroll.setBounds(250, 10, 224, 180);
		junitOut.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JUnit", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		myFrame.getContentPane().add(junitScroll);
		
		listOfTests.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				List<String> selectedTests = listOfTests.getSelectedValuesList();
				if (listOfTests.getSelectedIndex() == listOfTests.getLeadSelectionIndex() && listOfTests.getSelectedIndex() == listOfTests.getAnchorSelectionIndex()) {
					methodList.removeAllElements();
				}
				try {
					//methodList.removeAllElements();
					List<String> myTestMethods = application.TestListener.getTestMethods(selectedTests);
					System.out.println(myTestMethods.size());
					for (int i = 0; i < simpleList.size(); i++) {
						if (selectedTests.contains(simpleList.get(i))) {
							for (int j = 0; j < myTestMethods.size(); j++) {
								if (!methodList.contains(simpleList.get(i)) && methodList.size()-myTestMethods.size() > 0) {
									methodList.add(methodList.size()-myTestMethods.size(), simpleList.get(i));
									methodList.insertElementAt("\n", methodList.size()-myTestMethods.size()-1);
								} else if (!methodList.contains(simpleList.get(i))) {
									methodList.addElement(simpleList.get(i));
								}
								if (!methodList.contains(myTestMethods.get(j))) {
									methodList.addElement(myTestMethods.get(j));
								} 
							}
						}
					}
				} catch (Exception e) {
						e.printStackTrace();
				}
			}
		});
		
		// Run button
		JButton runButton = new JButton("Run");
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> selectedTests = listOfTests.getSelectedValuesList();
				try {
					TestExecuter.allTests(selectedTests);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		runButton.setBounds(200, 326, 90, 25);
		myFrame.getContentPane().add(runButton);
		
		// Stop button - TODO
		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					throw new InterruptedException();
				} catch (InterruptedException e) {
					System.out.println("Test stopped");
				}
			}
		});
		stopButton.setBounds(300, 326, 90, 25);
		myFrame.getContentPane().add(stopButton);
	}
}
