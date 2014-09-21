package com.dlacours.anyadstodos;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class EditTaskAdapter extends ArrayAdapter<Task> {

	private LayoutInflater inflater;
	
	public EditTaskAdapter(Context context, TaskList editList) {
		super(context, R.layout.editable_task, editList.getTasks());
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}


	public Task getItem(int position) {
		return TaskListController.getTaskList().getTasks().get(position);
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		final int finalpos = position;
		
		if (convertView == null){
			convertView = inflater.inflate(R.layout.editable_task, null); 
		}
		
		TextView editTask = (TextView) convertView.findViewById(R.id.edit_task);
		
		editTask.setText(getItem(position).getTask());
		editTask.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder editDialogue = new AlertDialog.Builder(getContext());
				editDialogue.setMessage("Delete or Archive " + getItem(finalpos));
				editDialogue.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
					
					public void onClick(DialogInterface dialog, int which) {
				    	TaskList theTasks = TaskListController.getTaskList();
			    		theTasks.removeTask(getItem(finalpos));
			    		MainActivity.notifyChange();
			    		EditTasksActivity.notifyChange();
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

