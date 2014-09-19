package com.dlacours.anyadstodos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.anyadstodos.ArchiveListActivities;
import com.example.anyadstodos.EditTasksActivity;
import com.example.anyadstodos.MailItemsActivity;
import com.example.anyadstodos.R;
import com.example.anyadstodos.SummariesActivity;

public class MainActivity extends Activity {

	private ListView taskList;
	private EditText addTask;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    //Called when user clicks the Add button
    public void addTask(View view){
    	//Adds a new task
    	
    	addTask = (EditText) findViewById(R.id.addTask);
    	taskList = (ListView) findViewById(R.id.taskListView);

    	String addText = addTask.getText().toString();
    	TaskList theTasks = TaskListController.getTaskList();
    	
    	if (!addText.equals("")){
    		Task task = new Task(addText);
    		theTasks.addTask(task);
    	}
    	
    	
    	Collection<Task> tasks = TaskListController.getTaskList().getTasks();
    	ArrayList<Task> list = new ArrayList<Task>(tasks);
    	ArrayAdapter<Task> taskAdapter = new ArrayAdapter<Task>(this, android.R.layout.simple_list_item_1, list);
    	taskList.setAdapter(taskAdapter);
  

    	
    	addTask.setText("");
    	
    	//Toast.makeText(MainActivity.this, task, Toast.LENGTH_SHORT).show();
    }

    

    public void showSummaries(MenuItem menu){
    	Intent intent = new Intent(MainActivity.this, SummariesActivity.class);
    	startActivity(intent);
    	
    }
    
    public void mailTasks(MenuItem menu){
    	Intent intent = new Intent(MainActivity.this, MailItemsActivity.class);
    	startActivity(intent);
    }
    
    public void archiveTasks(MenuItem menu){
    	Intent intent = new Intent(MainActivity.this, ArchiveListActivities.class);
    	startActivity(intent);
    }
    
    public void editTasks(MenuItem menu){
    	Intent intent = new Intent(MainActivity.this, EditTasksActivity.class);
    	startActivity(intent);
    }
}