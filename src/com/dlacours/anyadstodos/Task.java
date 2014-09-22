package com.dlacours.anyadstodos;

public class Task {

	protected String taskName;
	protected boolean isChecked;
	protected boolean isArchived;
	
	public Task(String taskName) {
		this.taskName=taskName;
		this.isChecked = false;
		this.isArchived = false;
	}

	public void setChecked(boolean checked){
		isChecked = checked;
	}
	
	public boolean getChecked(){
		return isChecked;
	}
	
	public void setArchived(boolean archived){
		isArchived = archived;
	}
	
	public boolean getArchived(){
		return isArchived;
	}
	
	public String getTask() {
		return this.taskName;
	}
	
	public String toString(){
		return getTask();
	}

}
