package com.dlacours.anyadstodos;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class ArchiveListActivities extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.archive_list);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.archive_list_activities, menu);
		return true;
	}

}