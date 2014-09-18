package com.example.anyadstodos;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SummariesActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sum_screen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.summaries, menu);
		return true;
	}

}
