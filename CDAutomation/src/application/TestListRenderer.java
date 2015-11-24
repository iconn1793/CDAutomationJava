package application;

import java.awt.Color;
import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

public class TestListRenderer extends DefaultListCellRenderer {
	DefaultListCellRenderer defRenderer = new DefaultListCellRenderer();
	
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
		JLabel renderer = (JLabel) defRenderer.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
		DefaultListModel<String> testMethodsList = new DefaultListModel<String>();
		renderer.setForeground(Color.RED);

		return renderer;
	}
}
