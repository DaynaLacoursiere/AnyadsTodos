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
	/*initializes and sets the mail task Adapter.
	 * This class also handles adding tasks using
	 * the add button on the main screen of the app.
	 * Also contains the intents that move the user
	 * through the app screens */
	private ListView taskList;
	private EditText addTask;
	private static TaskListAdapter taskAdapter;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addTask = (EditText) findViewById(R.id.addTask);
        taskList = (ListView) findViewById(R.id.taskListView);
        
        taskAdapter = new TaskListAdapter(this,TaskListController.getUnarchList());
    	
        
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
    	TaskList theTasks = TaskListController.getUnarchList();
    	TaskList allTasks = TaskListController.getTaskList();
    	//TaskList archTasks = TaskListController.getArchList();
    	
    	if (!addText.equals("")){
    		Task task = new Task(addText);
    		theTasks.addUnarchivedTask(task);
    		allTasks.addTask(task);
    
    		notifyChange();
    	}
    	
    	
    	
    	addTask.setText("");
    	
    }

    public static void notifyChange(){
    	taskAdapter.notifyDataSetChanged();
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
    	Intent intent = new Intent(this, ArchiveTasksActivity.class);
    	startActivity(intent);
    }

    //goes to edit screen
    public void editTasks(MenuItem menu){
    	Intent intent = new Intent(this, EditTasksActivity.class);
    	startActivity(intent);
    }


}