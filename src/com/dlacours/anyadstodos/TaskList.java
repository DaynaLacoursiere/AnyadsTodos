package com.dlacours.anyadstodos;

import java.util.ArrayList;
import java.util.Collection;


public class TaskList {

	protected ArrayList<Task> taskList;
	
	public TaskList(){
		taskList = new ArrayList<Task>();
	}
	
	public Collection<Task> getTasks() {
		// TODO Auto-generated method stub
		return taskList;
	}



	public void addTask(Task testTask) {
		// TODO Auto-generated method stub
		taskList.add(testTask);
	}

	public void removeTask(Task testTask) {
		// TODO Auto-generated method stub
		taskList.remove(testTask);
	}

}
