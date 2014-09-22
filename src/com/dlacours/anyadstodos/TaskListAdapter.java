package com.dlacours.anyadstodos;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class TaskListAdapter extends ArrayAdapter<Task> {
	//For main task list
	
	
	private LayoutInflater inflater;
	
	public TaskListAdapter(Context context, TaskList taskList) {
		super(context, R.layout.single_task, taskList.getUnarchived());
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
	}
	
	@Override
	public Task getItem(int position) {
		return TaskListController.getUnarchList().getUnarchived().get(position);
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		final int finalpos = position;
		
		if (convertView == null){
			convertView = inflater.inflate(R.layout.single_task, null); 
		}
		CheckBox checkbox = (CheckBox) convertView.findViewById(R.id.taskcheckbox);
		
		checkbox.setText(getItem(position).getTask());
		
		checkbox.setChecked(getItem(position).getChecked());
		checkbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked){
					getItem(finalpos).setChecked(true);
					SummariesActivity.CheckedSum(1);
					SummariesActivity.UncheckedSum(-1);
				} else {
					getItem(finalpos).setChecked(false);
					SummariesActivity.CheckedSum(-1);
					SummariesActivity.UncheckedSum(1);
				}
				
			}
		});
		
		return convertView;
	}
}
