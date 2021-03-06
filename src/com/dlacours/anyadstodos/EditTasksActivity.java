package com.dlacours.anyadstodos;

import java.util.ArrayList;
import java.util.Collection;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class EditTasksActivity extends Activity {
	/*initializes and sets editAdapter*/
	private static EditTaskAdapter editAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_edit_tasks);
		
		ListView editList = (ListView) findViewById(R.id.taskEditor);            
		TaskList allTasks = TaskListController.getTaskList();
		TaskList unarchTasks = TaskListController.getUnarchList();
    
        editAdapter = new EditTaskAdapter(this,allTasks);
    	
    	editList.setAdapter(editAdapter);
		
	}
	
    public static void notifyChange(){
    	editAdapter.notifyDataSetChanged();
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edit_tasks, menu);
		return true;
	}

}
