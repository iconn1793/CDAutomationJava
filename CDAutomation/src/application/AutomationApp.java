package application;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import application.TestListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.junit.runner.notification.StoppedByUserException;

public class AutomationApp {
	private JFrame myFrame;
	
	public static void main(String[] args) {
		new Settings().loadSettings();
		
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

	public AutomationApp() {
		initialize();
	}

	// Initialize the contents of the frame
	@SuppressWarnings("serial")
	private void initialize() {
		myFrame = new JFrame();
		myFrame.setResizable(false);
		myFrame.setTitle("CD Automation");
		myFrame.setBounds(300, 150, 900, 500);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.getContentPane().setLayout(null);
		
		// List of test files
		DefaultListModel<String> simpleList = new FileFinder().simpleFileList();
		JList<String> testClassList = new JList<String>(simpleList);
		JScrollPane testListScroll = new JScrollPane();
		testClassList.setFont(new Font("Arial", Font.BOLD, 11));
		testClassList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		testListScroll.setViewportView(testClassList);
		testListScroll.setBounds(10, 10, 180, 200);
		testListScroll.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tests", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		myFrame.getContentPane().add(testListScroll);
		
		// JUnit output window
		DefaultListModel<String> testMethodsList = new DefaultListModel<String>();
		List<String> failedTests = new ArrayList<String>();
		List<String> passedTests = new ArrayList<String>();
		List<String> executedTests = new ArrayList<String>();
		JList<String> junitOut = new JList<String>(testMethodsList);
		HashMap<String, String> exceptionsMap = new HashMap<String, String>();
		JScrollPane junitScroll = new JScrollPane();
		junitOut.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		junitOut.setFont(new Font("Arial", Font.PLAIN, 11));
		junitOut.setBackground(Color.WHITE);
		junitOut.setFocusable(false);
		junitScroll.setViewportView(junitOut);
		junitScroll.setBounds(220, 10, 260, 200);
		junitScroll.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JUnit", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		myFrame.getContentPane().add(junitScroll);

		// Console output window
		JTextPane consoleOutput = new JTextPane();
		JScrollPane consoleScroll = new JScrollPane();
		PrintStream logOutPrintStream = new PrintStream(new ConsoleOutput(consoleOutput));
		PrintStream logErrPrintStream = new PrintStream(new ConsoleErrorOutput(consoleOutput));
		consoleOutput.setBackground(Color.WHITE);
		consoleOutput.setFont(new Font("Arial", Font.PLAIN, 12));
		consoleOutput.setEditable(false);
		consoleScroll.setViewportView(consoleOutput);
		consoleScroll.setBounds(10, 245, 464, 180);
		consoleScroll.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		myFrame.getContentPane().add(consoleScroll);
		
		// Server output window
		JTextPane serverOutput = new JTextPane();
		JScrollPane serverScroll = new JScrollPane();
		PrintStream serverOutPrintStream = new PrintStream(new ConsoleOutput(serverOutput));
		PrintStream serverErrPrintStream = new PrintStream(new ConsoleErrorOutput(serverOutput));
		System.setOut(serverOutPrintStream);
		System.setErr(serverErrPrintStream);
		serverOutput.setBackground(Color.DARK_GRAY.darker());
		serverOutput.setForeground(Color.WHITE);
		serverOutput.setFont(new Font("Arial", Font.PLAIN, 12));
		serverOutput.setEditable(false);
		serverScroll.setViewportView(serverOutput);
		serverScroll.setBounds(495, 14, 390, 450);
		serverScroll.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		myFrame.getContentPane().add(serverScroll);
		
		// Exception info window
		JDialog exceptionWindow = new JDialog(myFrame, "", Dialog.ModalityType.MODELESS);
		JScrollPane exceptionScroll = new JScrollPane();
		JTextPane exceptionText = new JTextPane();
		exceptionText.setEditable(false);
		exceptionText.setForeground(Color.RED.darker());
		exceptionText.setFont(new Font("Arial", Font.PLAIN, 11));
		exceptionScroll.setViewportView(exceptionText);
		exceptionWindow.getContentPane().add(exceptionScroll);
		exceptionWindow.setSize(525, 200);
		exceptionWindow.setResizable(false);
		
		// Progress bar
		JProgressBar testProgressBar = new JProgressBar();
		testProgressBar.setMinimum(0);
		testProgressBar.setBounds(260, 220, 180, 14);
		testProgressBar.setForeground(Color.GREEN.darker());
		testProgressBar.setFont(new Font("Arial", Font.PLAIN, 10));
		myFrame.getContentPane().add(testProgressBar);
		
		// Buttons
		JButton selectAllButton = new JButton("Select All");
		selectAllButton.setFont(new Font("Arial", Font.PLAIN, 12));
		selectAllButton.setBounds(16, 215, 85, 25);
		myFrame.getContentPane().add(selectAllButton);
		
		JButton logButton = new JButton("Open Log");
		logButton.setFont(new Font("Arial", Font.PLAIN, 12));
		logButton.setBounds(99, 215, 85, 25);
		myFrame.getContentPane().add(logButton);
		
		JButton runButton = new JButton("Run");
		runButton.setFont(new Font("Arial", Font.PLAIN, 12));
		runButton.setBounds(198, 437, 90, 25);
		myFrame.getContentPane().add(runButton);
		
		JButton stopButton = new JButton("Stop");
		stopButton.setFont(new Font("Arial", Font.PLAIN, 12));
		stopButton.setBounds(300, 437, 90, 25);
		myFrame.getContentPane().add(stopButton);
		
		Boolean overrideSetting = Boolean.valueOf(Settings.appSettings.getProperty("IOSOverride"));
		JToggleButton IOSButton = new JToggleButton("iOS Sim");
		IOSButton.setFont(new Font("Arial", Font.PLAIN, 12));
		IOSButton.setSelected(overrideSetting);
		IOSButton.setBounds(94, 437, 90, 25);
		myFrame.getContentPane().add(IOSButton);
		
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
						
						System.setOut(logOutPrintStream);
						System.setErr(logErrPrintStream);
						
						testProgressBar.setStringPainted(true);
						testProgressBar.setString("Test Progress");
						testProgressBar.setValue((junitOut.getSelectedIndex()));
				
						if (!failedTests.contains(t.failedTests())){
							failedTests.add(t.failedTests());
							exceptionsMap.put(t.failedTests(), TestListener.exceptionResult);
						}
						
						if (!passedTests.contains(t.passedTests())) {
							passedTests.add(t.passedTests());
						}
						
						if (testMethodsList.contains(testClassList.getSelectedValue())) {
							for (int i = 0; i < selectedTests.size(); i++) {
								if (!executedTests.contains(selectedTests.get(i))) {
									executedTests.add(selectedTests.get(i));
								}
							}
						}

						Thread.sleep(300);
						
						// After all tests have been completed
						if (TestListener.currentTest.equals("done")) {
							System.setOut(serverOutPrintStream);
							System.setErr(serverErrPrintStream);
							
							testProgressBar.setValue(testProgressBar.getValue()+1);
							
							if (testProgressBar.getValue() == testMethodsList.size()-1) {
								testProgressBar.setValue(testMethodsList.size());
								testProgressBar.setString("Complete");
							}
							
							if (!failedTests.contains(t.failedTests())){
								failedTests.add(t.failedTests());
								exceptionsMap.put(t.failedTests(), TestListener.exceptionResult);
							}
							
							if (!passedTests.contains(t.passedTests())) {
								passedTests.add(t.passedTests());
							}

							junitOut.clearSelection();
							runButton.setEnabled(true);
							testClassList.setEnabled(true);
							selectAllButton.setEnabled(true);
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
				
				try {
					TestExecuter.runTests(testClassList.getSelectedValuesList());
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
				
				runButton.setEnabled(false);
				testClassList.setEnabled(false);
				selectAllButton.setEnabled(false);
				
				if(IOSButton.isSelected()) {
					elements.Drivers.IOSEnabled = true;
				}
				
				if (executedTests.contains(testClassList.getSelectedValue())) {
					for (int i = 0; i < testMethodsList.size(); i++) {
						executedTests.remove(testMethodsList.get(i));
						passedTests.remove(testMethodsList.get(i));
						failedTests.remove(testMethodsList.get(i));
						exceptionsMap.remove(testMethodsList.get(i));
					}
				}
				

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
		
		IOSButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (IOSButton.isSelected()) {
					Settings.appSettings.put("IOSOverride", "true");
				} else {
					Settings.appSettings.put("IOSOverride", "false");
				}
				
				new Settings().storeSettings();
			}
		});
		
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
		
		listPopup.add(" Run Test").addActionListener(runTest);
		listPopup.add(" Open Log").addActionListener(openLog);
		listPopup.add(" Clear Log").addActionListener(clearLog);
		
		testClassList.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					testClassList.setSelectedIndex(testClassList.locationToIndex(e.getPoint()));
					listPopup.show(testClassList, e.getX(), e.getY());
				}
			}
		});
		
		// Shows the exception and stack trace of a failed test
		junitOut.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() == 2) {
					if (exceptionsMap.keySet().contains(junitOut.getSelectedValue())) {
						exceptionText.setText(exceptionsMap.get(junitOut.getSelectedValue()));
						exceptionText.setCaretPosition(0);
						exceptionWindow.setLocation(e.getLocationOnScreen());
						exceptionWindow.setTitle(junitOut.getSelectedValue());
						exceptionWindow.setVisible(true);
					} else {
						exceptionWindow.setVisible(false);
					}
				}
			}
		});
		
		// Drag and drop to rearrange list
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
				
				if (executedTests.contains(testClassList.getSelectedValue())) {
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
				
				Icon runningIcon = new ImageIcon(iconLocation+"running.gif");
				Icon tSuiteIcon = new ImageIcon(iconLocation+"tsuite.gif");
				Icon testIcon = new ImageIcon(iconLocation+"test.gif");
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
