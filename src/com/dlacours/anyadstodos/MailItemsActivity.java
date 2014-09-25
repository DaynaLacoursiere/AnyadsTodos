package com.dlacours.anyadstodos;

import java.util.ArrayList;
import java.util.Collection;

import android.R.string;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MailItemsActivity extends Activity {

	private static MailItemsAdapter mailAdapter;
	public static String theEmailList = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mail_screen);
		
		ListView mailList = (ListView) findViewById(R.id.emailList);
		
		TaskList theTasks = TaskListController.getTaskList();
        
        mailAdapter = new MailItemsAdapter(this, theTasks);
    	
    	mailList.setAdapter(mailAdapter);
    	mailList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
    	

		//final TaskList allTasks = TaskListController.getTaskList();

    	Collection<Task> allTasks = TaskListController.getTaskList().getTasks();
    	final ArrayList<Task> allTasksArray = new ArrayList<Task>(allTasks);
    	
		Button sendSelected = (Button) findViewById(R.id.email_button); 
		Button sendAll = (Button) findViewById(R.id.check_all_button);
		
		sendSelected.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				for (int i = 0; i < allTasksArray.size(); i++){
					if (allTasksArray.get(i).toEmail){
						theEmailList += (allTasksArray.get(i).toString()) + "\n";
					}
				}
							
				
				Intent i = new Intent(Intent.ACTION_SEND);
				i.setType("message/rfc822");
				i.putExtra(Intent.EXTRA_TEXT, theEmailList);
				startActivity(Intent.createChooser(i, "Send mail..."));
				
			}
		});
		
		sendAll.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				for (int i = 0; i < allTasksArray.size(); i++){
					theEmailList += (allTasksArray.get(i).toString()) + "\n";
				}
				
				
				Intent i = new Intent(Intent.ACTION_SEND);
				i.setType("message/rfc822");
				i.putExtra(Intent.EXTRA_TEXT, theEmailList);
				startActivity(Intent.createChooser(i, "Send mail..."));
			}
		});
	}
	
    public static void notifyChange(){
    	mailAdapter.notifyDataSetChanged();
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mail_items, menu);
		return true;
	}
	
}
