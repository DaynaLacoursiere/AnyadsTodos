package com.dlacours.anyadstodos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.anyadstodos.ArchiveListActivities;
import com.example.anyadstodos.MailItemsActivity;
import com.example.anyadstodos.R;
import com.example.anyadstodos.SummariesActivity;

public class MainActivity extends Activity {

	private ListView taskList;
	private EditText addTask;
	//private List<String> tasks = new ArrayList<String>(); //from http://stackoverflow.com/questions/2843366/how-to-add-new-elements-to-an-array
	//private ArrayAdapter<String> tasksArray = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tasks);
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    //Called when user clicks the Add button
    public void addTask(View view){
    	//Adds a new task
    	
    	addTask = (EditText) findViewById(R.id.addTask);
    	taskList = (ListView) findViewById(R.id.taskListView);

    	//String task = addTask.getText().toString();
    	//tasks.add(task);
    	
    	//taskList.setAdapter(tasksArray); //so far doesn't work. Got from http://www.codelearn.org/android-tutorial/android-listview
    	
    	//Toast.makeText(MainActivity.this, task, Toast.LENGTH_SHORT).show();
    }


    public void showSummaries(MenuItem menu){
    	//Toast.makeText(this, "Showing Summaries", Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(MainActivity.this, SummariesActivity.class);
    	startActivity(intent);
    	
    }
    
    public void mailTasks(MenuItem menu){
    	//Toast.makeText(this, "Mailing Tasks", Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(MainActivity.this, MailItemsActivity.class);
    	startActivity(intent);
    }
    
    public void archiveTasks(MenuItem menu){
    	//Toast.makeText(this, "Archiving Tasks", Toast.LENGTH_SHORT).show();
    	Intent intent = new Intent(MainActivity.this, ArchiveListActivities.class);
    	startActivity(intent);
    }
    
    public void editTasks(MenuItem menu){
    	Toast.makeText(this, "Editing Tasks", Toast.LENGTH_SHORT).show();
    }
}