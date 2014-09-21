package com.dlacours.anyadstodos;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SummariesActivity extends Activity {
	


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sum_screen);
		
		SumList();

    	final ListView sumListView = (ListView) findViewById(R.id.sumList);

    	ArrayAdapter<String> sumAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, sumList);
    	sumListView.setAdapter(sumAdapter);
  		
		
	}
	
	protected ArrayList<String> sumList;
	
	public void SumList(){
		sumList = new ArrayList<String>();
		sumList.add("Total Tasks: " + total);
		sumList.add("Checked Tasks: " + checked);
		sumList.add("Unchecked Tasks: " + unchecked);
		sumList.add("Archived Tasks: " + archived);
		sumList.add("Checked and Archived Tasks: " + check_archived);
		sumList.add("Unchecked and Archived Tasks: " + uncheck_archived);
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
