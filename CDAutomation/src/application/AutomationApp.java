package application;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
		myFrame.setTitle("CD Automation");
		myFrame.setBounds(100, 100, 460, 400);
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myFrame.getContentPane().setLayout(null);

		// List of test files
		DefaultListModel<String> simpleList = new FileFinder().simpleFileList();
		JList<String> listOfTests = new JList<String>(simpleList);
		JScrollPane scrollPane = new JScrollPane();
		
		scrollPane.setBounds(10, 11, 137, 181);
		scrollPane.setViewportView(listOfTests);
		
		listOfTests.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		myFrame.getContentPane().add(scrollPane);
		
		// Drag and drop rearrange - TODO
		listOfTests.setDropMode(DropMode.INSERT);
		listOfTests.setDragEnabled(true);

		// Console window
		JTextPane consoleOut = new JTextPane();
		consoleOut.setBackground(Color.LIGHT_GRAY);
		consoleOut.setEditable(false);
		consoleOut.setBounds(10, 203, 424, 118);
		consoleOut.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		myFrame.getContentPane().add(consoleOut);
		
		// Run button
		JButton runButton = new JButton("Run");
		runButton.setBounds(132, 328, 89, 23);
		
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				List<String> selectedTests = listOfTests.getSelectedValuesList();
				try {
					TestFinder.allTests(selectedTests);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		myFrame.getContentPane().add(runButton);
		
		// Stop button
		JButton stopButton = new JButton("Stop");
		stopButton.setBounds(231, 328, 89, 23);
		myFrame.getContentPane().add(stopButton);
	}
}
