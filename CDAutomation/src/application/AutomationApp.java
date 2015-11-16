package application;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.JFrame;
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
		JList<String> testClassList = new JList<String>(simpleList);
		JScrollPane testListScroll = new JScrollPane();
		testClassList.setFont(new Font("Arial", Font.PLAIN, 11));
		testClassList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		testListScroll.setViewportView(testClassList);
		testListScroll.setBounds(10, 10, 150, 181);
		testListScroll.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tests", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 128, 128)));
		myFrame.getContentPane().add(testListScroll);

		// Console output window
		JTextPane consoleOut = new JTextPane();
		consoleOut.setBackground(Color.LIGHT_GRAY);
		consoleOut.setEditable(false);
		consoleOut.setBounds(10, 203, 464, 118);
		consoleOut.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		myFrame.getContentPane().add(consoleOut);
		
		// JUnit output window
		DefaultListModel<String> testMethodsList = new DefaultListModel<String>();
		JList<String> junitOut = new JList<String>(testMethodsList);
		junitOut.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		junitOut.setFont(new Font("Arial", Font.PLAIN, 11));
		junitOut.setBackground(Color.WHITE);
		junitOut.setFocusable(false);
		JScrollPane junitScroll = new JScrollPane();
		junitScroll.setViewportView(junitOut);
		junitScroll.setBounds(250, 10, 224, 180);
		junitScroll.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "JUnit", TitledBorder.LEADING, TitledBorder.TOP, null, Color.GRAY));
		myFrame.getContentPane().add(junitScroll);
		
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
		
		Runnable testMethodSelector = new Runnable() {
			@Override
			public void run() {
				int i = 0; 
				while (i < testMethodsList.size()) {
					while (application.TestListener.callRunningMethod().equals(testMethodsList.get(i))) {
						junitOut.setSelectedValue(application.TestListener.callRunningMethod(), true);
						application.TestListener.callRunningMethod();
					}
					i++;
				}
			}
		};
		
		Runnable runTestThread = new Runnable() {
			@Override
			public void run() {
				List<String> selectedTests = testClassList.getSelectedValuesList();
				try {
					TestExecuter.allTests(selectedTests);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		
		ActionListener runTest = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Thread methodSelector = new Thread(testMethodSelector);
				Thread testThread = new Thread(runTestThread);
				methodSelector.start();
				testThread.start();
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
			}
		});
		
		// Buttons //
		JButton selectAllButton = new JButton("Select All");
		selectAllButton.addActionListener(selectAll);
		selectAllButton.setBounds(160, 168, 90, 20);
		myFrame.getContentPane().add(selectAllButton);
		
		JButton logButton = new JButton("Open Log");
		logButton.addActionListener(openLog);
		logButton.setBounds(100, 326, 90, 25);
		myFrame.getContentPane().add(logButton);
		
		JButton runButton = new JButton("Run");
		runButton.addActionListener(runTest);
		runButton.setBounds(200, 326, 90, 25);
		myFrame.getContentPane().add(runButton);
		
		// TODO need to interrupt JUnit test class
		JButton stopButton = new JButton("Stop");
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		stopButton.setBounds(300, 326, 90, 25);
		myFrame.getContentPane().add(stopButton);
		

	}
}
