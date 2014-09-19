package com.example.anyadstodos;

import java.util.ArrayList;
import java.util.Collection;

import com.dlacours.anyadstodos.Task;
import com.dlacours.anyadstodos.TaskList;
import com.dlacours.anyadstodos.TaskListController;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class EditTasksActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_tasks);
		
		ListView taskList = (ListView) findViewById(R.id.taskListView);
		ListView editList = (ListView) findViewById(R.id.taskEditor);
		
		TaskList theTasks = TaskListController.getTaskList();
    

    	
    	Collection<Task> tasks = TaskListController.getTaskList().getTasks();
    	ArrayList<Task> list = new ArrayList<Task>(tasks);
    	ArrayAdapter<Task> taskAdapter = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1, list);
    	editList.setAdapter(taskAdapter); //gets the tasks into the editList
    	
    	/*editList.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
			}
		});*/
  

    	
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_tasks, menu);
		return true;
	}

}
