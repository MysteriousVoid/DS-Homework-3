package net.sourceforge.ganttproject.gui;


import javax.swing.JButton;
import java.awt.Container;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.io.Serializable;
import javax.swing.WindowConstants;

public class GanttAppletProduct implements Serializable {
	private JButton button = new JButton("Click to view the project planer");

	public Container createContainer(GanttApplet ganttApplet) {
		JPanel panel = new JPanel();
		button.addActionListener(ganttApplet);
		panel.add(button);
		return panel;
	}

	public static void main(String[] args) {
		GanttApplet applet = new GanttApplet();
		JFrame frame = new JFrame("Test GanttApplet");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(applet.createContainer());
		frame.pack();
		frame.setVisible(true);
	}
}