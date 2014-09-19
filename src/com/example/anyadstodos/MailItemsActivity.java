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
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MailItemsActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mail_screen);
		
		ListView taskList = (ListView) findViewById(R.id.taskListView);
		ListView emailList = (ListView) findViewById(R.id.emailList);
		
		TaskList theTasks = TaskListController.getTaskList();
    

    	
    	Collection<Task> tasks = TaskListController.getTaskList().getTasks();
    	ArrayList<Task> list = new ArrayList<Task>(tasks);
    	ArrayAdapter<Task> taskAdapter = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1, list);
    	emailList.setAdapter(taskAdapter); //gets the tasks into the emailList
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mail_items, menu);
		return true;
	}


}
