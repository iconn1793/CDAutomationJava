package application;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import application.TestListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.junit.runner.notification.StoppedByUserException;

public class AutomationApp {
	private JFrame myFrame;
	private boolean resetTestStatus;
	
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
	@SuppressWarnings("serial")
	private void initialize() {
		myFrame = new JFrame();
		myFrame.setResizable(false);
		myFrame.setTitle("CD Automation");
		myFrame.setBounds(300, 300, 500, 420);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.getContentPane().setLayout(null);

		// List of test files
		DefaultListModel<String> simpleList = new FileFinder().simpleFileList();
		JList<String> testClassList = new JList<String>(simpleList);
		JScrollPane testListScroll = new JScrollPane();
		testClassList.setFont(new Font("Arial", Font.BOLD, 11));
		testClassList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		testListScroll.setViewportView(testClassList);
		testListScroll.setBounds(10, 10, 150, 181);
		testListScroll.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tests", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		myFrame.getContentPane().add(testListScroll);

		// Console output window
		JTextPane consoleWindow = new JTextPane();
		JScrollPane consoleScroll = new JScrollPane();
		PrintStream outPrintStream = new PrintStream(new ConsoleOutput(consoleWindow));
		PrintStream errPrintStream = new PrintStream(new ConsoleErrorOutput(consoleWindow));
		System.setOut(outPrintStream);
		System.setErr(errPrintStream);
		consoleWindow.setBackground(Color.WHITE);
		consoleWindow.setFont(new Font("Arial", Font.PLAIN, 11));
		consoleWindow.setEditable(false);
		consoleScroll.setViewportView(consoleWindow);
		consoleScroll.setBounds(10, 219, 464, 125);
		consoleScroll.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		myFrame.getContentPane().add(consoleScroll);
		
		// JUnit output window
		DefaultListModel<String> testMethodsList = new DefaultListModel<String>();
		List<String> failedTests = new ArrayList<String>();
		List<String> passedTests = new ArrayList<String>();
		List<String> passedClass = new ArrayList<String>();
		JList<String> junitOut = new JList<String>(testMethodsList);
		JScrollPane junitScroll = new JScrollPane();
		junitOut.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		junitOut.setFont(new Font("Arial", Font.PLAIN, 11));
		junitOut.setBackground(Color.WHITE);
		junitOut.setFocusable(false);
		junitScroll.setViewportView(junitOut);
		junitScroll.setBounds(250, 10, 224, 180);
		junitScroll.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JUnit", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		myFrame.getContentPane().add(junitScroll);
		
		// Progress bar
		JProgressBar testProgressBar = new JProgressBar();
		testProgressBar.setMinimum(0);
		testProgressBar.setBounds(270, 196, 180, 14);
		testProgressBar.setForeground(Color.GREEN.darker());
		testProgressBar.setFont(new Font("Arial", Font.PLAIN, 10));
		myFrame.getContentPane().add(testProgressBar);
		
		// Buttons
		JButton selectAllButton = new JButton("Select All");
		selectAllButton.setBounds(38, 193, 90, 20);
		myFrame.getContentPane().add(selectAllButton);
		
		JButton logButton = new JButton("Open Log");
		logButton.setBounds(100, 355, 90, 25);
		myFrame.getContentPane().add(logButton);
		
		JButton runButton = new JButton("Run");
		runButton.setBounds(200, 355, 90, 25);
		myFrame.getContentPane().add(runButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.setBounds(300, 355, 90, 25);
		myFrame.getContentPane().add(stopButton);
		
		// Runnables
		Runnable testMethodSelector = new Runnable() {
			@Override
			public void run() {
				TestListener t = new TestListener();
				testProgressBar.setMaximum(testMethodsList.size()-1);
				List<String> selectedTests = testClassList.getSelectedValuesList();
				
				try {
					while (testMethodsList.contains(t.runningTest())) {
						junitOut.setSelectedValue(t.runningTest(), true);
						
						testProgressBar.setStringPainted(true);
						testProgressBar.setString("Test Progress");
						testProgressBar.setValue((junitOut.getSelectedIndex()));
						
						if (!failedTests.contains(t.failedTests())){
							failedTests.add(t.failedTests());
						}
						
						if (!passedTests.contains(t.passedTests())) {
							passedTests.add(t.passedTests());
						}

						Thread.sleep(500);
						
						// After all tests have been completed
						if (TestListener.currentTest.equals("done")) {
							testProgressBar.setValue(testProgressBar.getValue()+1);
							
							if (testProgressBar.getValue() == testMethodsList.size()-1) {
								testProgressBar.setValue(testMethodsList.size());
								testProgressBar.setString("Complete");
							}
							
							if (!failedTests.contains(t.failedTests())){
								failedTests.add(t.failedTests());
							}
							
							if (!passedTests.contains(t.passedTests())) {
								passedTests.add(t.passedTests());
							}
							
							if (testMethodsList.contains(testClassList.getSelectedValue())) {
								for (int i = 0; i < selectedTests.size(); i++) {
									if (!passedClass.contains(selectedTests.get(i))) {
										passedClass.add(selectedTests.get(i));
									}
								}
							}

							junitOut.clearSelection();
						}
					}
				} catch (Exception e) {
					e.printStackTrace();	
				}
			}
		};
		
		Runnable runTestThread = new Runnable() {
			@Override
			public void run() {
				List<String> selectedTests = testClassList.getSelectedValuesList();
				try {
					TestExecuter.allTests(selectedTests);
				} catch (StoppedByUserException e) {
					TestListener.currentTest = "done";
					System.out.println("Test Stopped");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		// Listeners
		ActionListener selectAll = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<Integer> selectAllList = new ArrayList<Integer>();
				for (int i = 0; i < simpleList.size(); i++) {
					selectAllList.add(i);
				}
				int [] allTests = new int[selectAllList.size()];
				Iterator<Integer> iterator = selectAllList.iterator();
				for (int i = 0; i < allTests.length; i++) {
					allTests[i] = iterator.next().intValue();
				}
				testClassList.setSelectedIndices(allTests);
			}
		};
		
		ActionListener runTest = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread methodSelector = new Thread(testMethodSelector);
				Thread testThread = new Thread(runTestThread);
				
				if (testThread.getState() == Thread.State.valueOf("NEW")) {
					methodSelector.start();
					testThread.start();
				} else {
					new Thread(methodSelector).start();
					new Thread(runTestThread).start();
				}
			}
		};
		
		ActionListener openLog = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> selectedTests = testClassList.getSelectedValuesList();
				try {
					new application.LogFinder().openLog(selectedTests);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new TestExecuter().stopTests();
			}
		});
		
		ActionListener clearLog = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> selectedTests = testClassList.getSelectedValuesList();
				try {
					new application.LogFinder().clearLog(selectedTests);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		// Add listeners to buttons
		selectAllButton.addActionListener(selectAll);
		logButton.addActionListener(openLog);
		runButton.addActionListener(runTest);
		
		// Right-click menu
		JPopupMenu listPopup = new JPopupMenu();
		
		listPopup.add("   Run Test").addActionListener(runTest);
		listPopup.add("   Open Log").addActionListener(openLog);
		listPopup.add("   Clear Log").addActionListener(clearLog);
		
		testClassList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				List<String> selectedTests = testClassList.getSelectedValuesList();
				if (SwingUtilities.isRightMouseButton(e)) {
					if (selectedTests.isEmpty() || selectedTests.size() == 1) {
						testClassList.setSelectedIndex(testClassList.locationToIndex(e.getPoint()));
						testClassList.setComponentPopupMenu(listPopup);
					}
				}
			}
		});

		// Drag and drop to rearrange list - TODO
		testClassList.setDropMode(DropMode.INSERT);
		testClassList.setDragEnabled(true);
		
		// Shows the test methods in a test class when selected
		testClassList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				List<String> selectedTests = testClassList.getSelectedValuesList();
				
				if (testClassList.getSelectedIndex() == testClassList.getLeadSelectionIndex() && testClassList.getSelectedIndex() == testClassList.getAnchorSelectionIndex()) {
					testMethodsList.removeAllElements();
				} 
			
				try {
					List<String> calledTestMethods = application.TestListener.getTestMethods(selectedTests);
					for (int i = 0; i < calledTestMethods.size(); i++) {
						if (selectedTests.contains(calledTestMethods.get(0)) && !testMethodsList.contains(calledTestMethods.get(i))) {
							testMethodsList.addElement(calledTestMethods.get(i));
						}
					}
					testMethodsList.addElement("\n");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				if (passedClass.contains(testClassList.getSelectedValue())) {
					testProgressBar.setMaximum(testMethodsList.size());
					testProgressBar.setValue(testMethodsList.size());
					testProgressBar.setString("Complete");
				} else {
					testProgressBar.setValue(0);
					testProgressBar.setString("");
				}
			}
		});
		
		// Test methods cell renderer
		junitOut.setCellRenderer(new DefaultListCellRenderer() {
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
				JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
				
				String filePath = Paths.get("").toAbsolutePath().normalize().toString();
				String iconLocation = "";
				
				if (filePath.contains("/")) {
					iconLocation = filePath+"/icons/";
				} else {
					iconLocation = filePath+"\\icons\\";
				}
				
				Icon tSuiteIcon = new ImageIcon(iconLocation+"tsuite.gif");
				Icon testIcon = new ImageIcon(iconLocation+"test.gif");
				Icon runningIcon = new ImageIcon(iconLocation+"running.gif");
				Icon passIcon = new ImageIcon(iconLocation+"pass.gif");
				Icon failIcon = new ImageIcon(iconLocation+"fail.gif");
				
				if (simpleList.contains(value)) {
					setIcon(tSuiteIcon);
					setFont(new Font("Arial", Font.BOLD, 11));
				}
				
				if (value.toString().contains("test")) {
					label.setBorder(BorderFactory.createEmptyBorder(2,12,0,0));
					setIcon(testIcon);
				}
				
				if (value.toString().equals(TestListener.currentTest)) {
					setIcon(runningIcon);
				}
				
				if (failedTests.contains(value)) {
					setIcon(failIcon);
				}		

				if (passedTests.contains(value)) {
					setIcon(passIcon);
				}

				return label;
			}
		});
	}
}
