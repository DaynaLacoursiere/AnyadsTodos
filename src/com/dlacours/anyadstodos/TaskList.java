package com.dlacours.anyadstodos;

import java.util.ArrayList;
import java.util.Collection;



public class TaskList {

	protected ArrayList<Task> taskList;
	
	public TaskList(){
		taskList = new ArrayList<Task>();
	}
	
	//arraylists are very useful
	public ArrayList<Task> getTasks() {
		return taskList;
	}

	public void addTask(Task task) {
		taskList.add(task);
		SummariesActivity.TotalSum(1);
		SummariesActivity.UncheckedSum(1);
	}

	public void removeTask(Task task) {
		/*if (task.getChecked()){
			SummariesActivity.CheckedSum(-1);
		} else {
			SummariesActivity.UncheckedSum(-1);
		}*/
		SummariesActivity.TotalSum(-1);
		taskList.remove(task);
		}
	
	public void archiveTask(Task task){
		SummariesActivity.ArchivedSum(1);
	}
	
	public void unarchiveTask(Task task){
		SummariesActivity.ArchivedSum(-1);
	}
	
	public void checkTask(Task task){
		SummariesActivity.CheckedSum(1);
		SummariesActivity.UncheckedSum(-1);
	}
	
	public void uncheckTask(Task task){
		SummariesActivity.UncheckedSum(1);
		SummariesActivity.CheckedSum(-1);
	}

}
