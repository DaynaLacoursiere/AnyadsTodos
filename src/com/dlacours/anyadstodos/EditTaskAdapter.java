package com.dlacours.anyadstodos;

import android.content.Context;
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
	
	public View getView(int position, View convertView, ViewGroup parent) {
		
		if (convertView == null){
			convertView = inflater.inflate(R.layout.editable_task, null); 
		}
		
		TextView editTask = (TextView) convertView.findViewById(R.id.edit_task);
		editTask.setText(getItem(position).getTask());
		editTask.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SummariesActivity.ArchivedSum(1);
				
			}
			
		
		});
		
		return convertView;
	}
}

