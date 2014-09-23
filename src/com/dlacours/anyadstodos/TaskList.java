package com.dlacours.anyadstodos;

import java.util.ArrayList;
import java.util.Collection;



public class TaskList {

	protected ArrayList<Task> taskList;
	protected ArrayList<Task> archList;
	protected ArrayList<Task> unarchList;
	
	public TaskList(){
		taskList = new ArrayList<Task>();
		archList = new ArrayList<Task>();
		unarchList = new ArrayList<Task>();
	}
	
	//arraylists are very useful
	public ArrayList<Task> getTasks() {
		return taskList;
	}
	
	public ArrayList<Task> getArchived(){
		return archList;
	}
	
	public ArrayList<Task> getUnarchived(){
		return unarchList;
	}

	
	//additions
	public void addTask(Task task) {
		taskList.add(task);
		SummariesActivity.TotalSum(1);
		SummariesActivity.UncheckedSum(1);
	}
	
	public void addUnarchivedTask(Task task){
		unarchList.add(task);
	}
	
	public void addArchivedTask(Task task){
		archList.add(task);
	}

	
	//removals
	public void removeTask(Task task) {
		if (task.getChecked()){
			SummariesActivity.CheckedSum(-1);
		} else {
			SummariesActivity.UncheckedSum(-1);
		}
		
		SummariesActivity.TotalSum(-1);
		taskList.remove(task);
	}
	
	public void removeUnarchivedTask(Task task){
		unarchList.remove(task);
	}
	
	public void removeArchivedTask(Task task){
		if (task.getChecked()){
			SummariesActivity.CheckArchSum(-1);
		} else {
			SummariesActivity.UncheckArchSum(-1);
		}
		archList.remove(task);
		SummariesActivity.ArchivedSum(-1);
	}
	

	
	
	
	
	
	
	//don't think I'm using these four
	public void archiveTask(Task task){
		archList.add(task);
		unarchList.remove(task);
		SummariesActivity.ArchivedSum(1);
		if (task.getChecked()){
			SummariesActivity.CheckArchSum(1);
		} else {
			SummariesActivity.UncheckArchSum(1);
		}
	}
	
	public void unarchiveTask(Task task){
		archList.remove(task);
		unarchList.add(task);
		SummariesActivity.ArchivedSum(-1);
		if (task.getChecked()){
			SummariesActivity.CheckArchSum(-1);
		} else {
			SummariesActivity.UncheckArchSum(-1);
		}
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
