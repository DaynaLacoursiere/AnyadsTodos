package com.dlacours.anyadstodos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class EditTaskAdapter extends ArrayAdapter<Task> {

	private LayoutInflater inflater;
	
	public EditTaskAdapter(Context context, TaskList editList) {
		super(context, R.layout.editable_task, editList.getTasks());
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}


	public Task getItem(int position) {
		return TaskListController.getTaskList().getTasks().get(position);
	}
	
	public Task getUnarchItem(int position){
		return TaskListController.getUnarchList().getUnarchived().get(position);
	}
	
	public Task getArchItem(int position){
		return TaskListController.getArchList().getArchived().get(position);
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		
		final int finalpos = position;
		
		if (convertView == null){
			convertView = inflater.inflate(R.layout.editable_task, null); 
		}
		
		TextView editTask = (TextView) convertView.findViewById(R.id.edit_task);
		
		//CheckBox editCheck = (CheckBox) convertView.findViewById(R.id.edit_check);
		
		editTask.setText(getItem(position).getTask());
		
		
		boolean isChecked = getItem(position).getChecked();
		if (isChecked){
			editTask.setTextColor(Color.GREEN);
		} else {
			editTask.setTextColor(Color.YELLOW);
		}
		
		boolean isArchived = getItem(position).getArchived();
		if (isArchived && isChecked){
			editTask.setTextColor(Color.RED);
		} else if (isArchived && !isChecked){
			editTask.setTextColor(Color.MAGENTA);
		}
		
		editTask.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				final View finalv = v;
				AlertDialog.Builder editDialogue = new AlertDialog.Builder(getContext());
				editDialogue.setMessage("Delete or Archive " + getItem(finalpos));
				editDialogue.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
				    	TaskList theTasks = TaskListController.getTaskList();
			    		theTasks.removeTask(getItem(finalpos));
			    		
			    		if(getItem(finalpos).getArchived()){
			    			TaskList archTasks = TaskListController.getArchList();
			    			archTasks.removeArchivedTask(getArchItem(finalpos));
			    		} else {
			    			TaskList unarchTasks = TaskListController.getUnarchList();
			    			unarchTasks.removeUnarchivedTask(getUnarchItem(finalpos));
			    		}
			    		EditTasksActivity.notifyChange();
			    		MainActivity.notifyChange();
					}

				});
				editDialogue.setNeutralButton("Archive", new DialogInterface.OnClickListener() {
					
					
					public void onClick(DialogInterface dialog, int which) {
						// ARCHIVE TASK HERE
						
					}
				});
				editDialogue.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					
					
					public void onClick(DialogInterface dialog, int which) {
						//DO NOTHING HERE						
					}
				});
				editDialogue.show();
				
				
			}
			
		
		});
		
		return convertView;
	}
}

