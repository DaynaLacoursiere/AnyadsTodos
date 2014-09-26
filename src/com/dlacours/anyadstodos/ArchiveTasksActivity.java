package com.dlacours.anyadstodos;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

public class ArchiveTasksActivity extends Activity {

	private static ArchiveTaskAdapter archiveAdapter;
	private ListView archList;
	private TaskList archTasks;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.archive_list);
		
		archList = (ListView) findViewById(R.id.archiveListView);
		
		archTasks = TaskListController.getArchList();
    
        archiveAdapter = new ArchiveTaskAdapter(this, archTasks);
    	
    	archList.setAdapter(archiveAdapter);
    	archList.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		
	}
	
	/*protected void onStart() {
		super.onStart();
		TaskListController.loadTasksFromFile(getBaseContext());
		TaskListController.loadArchFromFile(getBaseContext());
		TaskListController.loadUnarchFromFile(getBaseContext());
		archiveAdapter = new ArchiveTaskAdapter(this, archTasks);
	    	
	    archList.setAdapter(archiveAdapter);
		//notifyChange();
	}*/
	
    public static void notifyChange(){
    	archiveAdapter.notifyDataSetChanged();
    }
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.archive_tasks, menu);
		return true;
	}

}

