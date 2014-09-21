package com.dlacours.anyadstodos;

public class Task {

	protected String taskName;
	protected Boolean isChecked;
	
	public Task(String taskName) {
		// TODO Auto-generated constructor stub
		this.taskName=taskName;
	}

	public void setChecked(Boolean checked){
		isChecked = checked;
	}
	
	public Boolean getChecked(){
		return isChecked;
	}
	
	public String getTask() {
		// TODO Auto-generated method stub
		return this.taskName;
	}
	
	public String toString(){
		return getTask();
	}

}
