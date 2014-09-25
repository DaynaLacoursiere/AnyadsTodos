package com.dlacours.anyadstodos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class ArchiveTaskAdapter extends ArrayAdapter<Task> {

	private LayoutInflater inflater;
	
	public ArchiveTaskAdapter(Context context, TaskList archiveList) {
		super(context, R.layout.single_task, archiveList.getArchived());
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
					if(!getItem(finalpos).getRemoved()){
						SummariesActivity.CheckArchSum(1);
						SummariesActivity.UncheckArchSum(-1);
					}
				} else {
					getItem(finalpos).setChecked(false);
					if(!getItem(finalpos).getRemoved()){
						SummariesActivity.CheckArchSum(-1);
						SummariesActivity.UncheckArchSum(1);
					}
				}
				
			}
		});
		
		return convertView;
	}
}

