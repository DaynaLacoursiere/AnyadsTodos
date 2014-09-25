package com.dlacours.anyadstodos;

import java.util.ArrayList;

import android.R.color;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Toast;

public class MailItemsAdapter extends ArrayAdapter<Task> {

	private LayoutInflater inflater;
	
	public MailItemsAdapter(Context context, TaskList mailList) {
		super(context, R.layout.single_task, mailList.getTasks());
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
		
		boolean isArchived = getItem(position).getArchived();
		if (isArchived){
			checkbox.setTextColor(Color.CYAN);
		} else {
			checkbox.setTextColor(Color.WHITE);
		}
		
		checkbox.setChecked(getItem(position).getEmail());
		checkbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				
				if (isChecked){
					getItem(finalpos).setEmail(true);
					
				} else {
					getItem(finalpos).setEmail(false);
					
					
				}
				
			}
		});
		
		
		return convertView;
	}
}

