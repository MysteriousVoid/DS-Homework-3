package net.sourceforge.ganttproject;


import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayList;
import java.lang.reflect.Array;
import java.util.Iterator;
import java.io.Serializable;

public class GanttTreeProduct implements Serializable {
	/**
	* Return tru if the Project has tasks and false is no tasks on the project 
	*/
	public boolean hasTasks(DefaultMutableTreeNode thisRootNode) {
		Enumeration e = (thisRootNode).preorderEnumeration();
		while (e.hasMoreElements()) {
			if (thisRootNode != (DefaultMutableTreeNode) e.nextElement())
				return true;
		}
		return false;
	}

	/**
	* Returnan ArrayList with all tasks. 
	*/
	public ArrayList getAllTasks(DefaultMutableTreeNode thisRootNode) {
		ArrayList res = new ArrayList();
		Enumeration e = (thisRootNode).preorderEnumeration();
		while (e.hasMoreElements()) {
			res.add(e.nextElement());
		}
		return res;
	}

	/**
	* Return the last default tree node 
	*/
	public DefaultMutableTreeNode getLastNode(DefaultMutableTreeNode thisRootNode) {
		return thisRootNode.getLastLeaf();
	}

	/**
	* Return all tasks on an array 
	*/
	public Object[] getAllTaskArray(DefaultMutableTreeNode thisRootNode) {
		ArrayList al = getAllTasks(thisRootNode);
		return al.toArray();
	}

	/**
	* Return all task exept the task in parameter 
	*/
	public String[] getAllTaskString(String except, DefaultMutableTreeNode thisRootNode) {
		ArrayList l = getAllTasks(thisRootNode);
		String[] res;
		if (except == null) {
			res = new String[l.size()];
		} else {
			res = new String[l.size() - 1];
		}
		int i = 0, j = 0;
		for (; i < l.size(); i++) {
			if (except == null || (l.get(i).toString() != except)) {
				Array.set(res, j, l.get(i).toString());
				j++;
			}
		}
		return res;
	}

	/**
	* Return an ArrayList with String for all tasks 
	*/
	public ArrayList getArryListTaskString(String except, DefaultMutableTreeNode thisRootNode) {
		ArrayList l = getAllTasks(thisRootNode);
		ArrayList res = new ArrayList();
		for (int i = 0; i < l.size(); i++) {
			if ((except != null && l.get(i).toString() != except) || except == null) {
				res.add(l.get(i).toString());
			}
		}
		return res;
	}

	/**
	* instead of returning a list of DefautMutableTreeNode it return a list of GanttTask 
	*/
	public ArrayList getAllGanttTasks(DefaultMutableTreeNode thisRootNode) {
		ArrayList res = new ArrayList();
		Enumeration e = (thisRootNode).preorderEnumeration();
		while (e.hasMoreElements()) {
			DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
			res.add(node.getUserObject());
		}
		return res;
	}

	/**
	* set all the earliestStart and earliestFinish to be null before scheduling 
	*/
	public void setAllTasksUnchecked(DefaultMutableTreeNode thisRootNode) {
		ArrayList tasks = getAllGanttTasks(thisRootNode);
		for (Iterator it = tasks.iterator(); it.hasNext();) {
			GanttTask task = (GanttTask) it.next();
			task.setChecked(false);
		}
	}
}