package com.dlacours.anyadstodos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends Activity {

	private ListView taskList;
	private EditText addTask;
	private TaskListAdapter taskAdapter;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTask = (EditText) findViewById(R.id.addTask);
        taskList = (ListView) findViewById(R.id.taskListView);
        
        taskAdapter = new TaskListAdapter(this,TaskListController.getTaskList());
    	
    	taskList.setAdapter(taskAdapter);
    	taskList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    	
        
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    //Called when user clicks the Add button This is attached to the addButton in the xml.
    public void addTask(View view){
    	//Adds a new task
    	
    	String addText = addTask.getText().toString();
    	TaskList theTasks = TaskListController.getTaskList();
    	
    	if (!addText.equals("")){
    		Task task = new Task(addText);
    		theTasks.addTask(task);
    		taskAdapter.notifyDataSetChanged();
    	}
    	
    	
    	addTask.setText("");
    	
    	//Toast.makeText(MainActivity.this, task, Toast.LENGTH_SHORT).show();
    }

    
    //goes to summary screen
    public void showSummaries(MenuItem menu){
    	Intent intent = new Intent(this, SummariesActivity.class);
    	startActivity(intent);
    	
    }

    //goes to mail screen
    public void mailTasks(MenuItem menu){
    	Intent intent = new Intent(this, MailItemsActivity.class);
    	startActivity(intent);
    }

    //goes to archive screen
    public void archiveTasks(MenuItem menu){
    	Intent intent = new Intent(this, ArchiveListActivities.class);
    	startActivity(intent);
    }

    //goes to edit screen
    public void editTasks(MenuItem menu){
    	Intent intent = new Intent(this, EditTasksActivity.class);
    	startActivity(intent);
    }
}