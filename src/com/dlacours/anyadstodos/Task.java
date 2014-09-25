package com.dlacours.anyadstodos;

public class Task {

	protected String taskName;
	protected boolean isChecked;
	protected boolean isArchived;
	protected boolean isRemoved;
	protected boolean toEmail;
	
	public Task(String taskName) {
		this.taskName=taskName;
		this.isChecked = false;
		this.isArchived = false;
		this.isRemoved = false;
		this.toEmail = false;
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
	
	public void setRemoved(boolean removed){
		isRemoved = removed;
	}
	
	public boolean getRemoved(){
		return isRemoved;
	}
	
	public String getTask() {
		return this.taskName;
	}
	
	public String toString(){
		return getTask();
	}

	public boolean getEmail() {
		return toEmail;
	}

	public void setEmail(boolean email){
		toEmail = email;
	}
}
