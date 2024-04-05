package net.sourceforge.ganttproject.shape;


import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.Serializable;

public class ShapeProduct implements Serializable {
	private ArrayList listeners = new ArrayList();

	public ArrayList getListeners() {
		return listeners;
	}

	public void removeActionListener(ActionListener listener) {
		listeners.remove(listener);
	}

	public void fireActionEvent(Shape shape) {
		ActionEvent event = new ActionEvent(shape, ActionEvent.ACTION_PERFORMED, "Pattern");
		ArrayList list = (ArrayList) listeners.clone();
		ActionListener listener;
		for (int i = 0; i < list.size(); i++) {
			listener = (ActionListener) list.get(i);
			listener.actionPerformed(event);
		}
	}
}