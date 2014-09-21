package com.dlacours.anyadstodos;

//Awesome singleton stuff
public class TaskListController {
	private static TaskList taskList = null;
	
	static public TaskList getTaskList() {
		if (taskList == null){
			taskList = new TaskList();
		}
		return taskList;
	}
	
	public void addTask(Task task){
		getTaskList().addTask(task);
	}
	
	public void deleteTask(Task task){
		getTaskList().removeTask(task);
	}
}
