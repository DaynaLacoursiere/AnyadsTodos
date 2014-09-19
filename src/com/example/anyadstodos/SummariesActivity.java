package com.example.anyadstodos;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.Toast;

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

	protected static int total = 0;
	protected static int checked = 0;
	protected static int unchecked = 0;
	protected static int archived = 0;
	protected static int check_archived = 0;
	protected static int uncheck_archived = 0;
	
	public static void TotalSum(int number) {
		// TODO Auto-generated constructor stub
		total += number;
	}
	
	public static void CheckedSum(int number) {
		// TODO Auto-generated constructor stub
		checked += number;
	}
	
	public static void UncheckedSum(int number) {
		// TODO Auto-generated constructor stub
		unchecked += number;
	}
	
	public static void ArchivedSum(int number) {
		// TODO Auto-generated constructor stub
		archived += number;
	}
	
	public static void CheckArchSum(int number) {
		// TODO Auto-generated constructor stub
		check_archived += number;
	}
	
	public static void UncheckArchSum(int number) {
		// TODO Auto-generated constructor stub
		uncheck_archived += number;
	}
	

}
