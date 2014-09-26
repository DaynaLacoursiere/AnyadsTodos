package com.dlacours.anyadstodos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

//Awesome singleton stuff
public class TaskListController {

	/*private static final String FILENAME = "tasks.sav";
	private static final String FILENAME2 = "arch.sav";
	private static final String FILENAME3 = "unarch.sav";*/
	private static TaskList taskList = null;
	private static TaskList unarchList = null;
	private static TaskList archList = null;
	
	static public TaskList getTaskList() {
		if (taskList == null){
			taskList = new TaskList();
		}
		return taskList;
	}

	static public TaskList getUnarchList() {
		if (unarchList == null){
			unarchList = new TaskList();
		}
		return unarchList;
	}
	
	static public TaskList getArchList() {
		if (archList == null){
			archList = new TaskList();
		}
		return archList;
	}
/*
	//from lab 3
	static void loadTasksFromFile(Context context) {
		try {
			FileInputStream fis = context.openFileInput(FILENAME);
			InputStreamReader irs = new InputStreamReader(fis);
			
			// From www.javacreed.com/simple-gson-example/ 2014-25-09
			Gson myGson = new GsonBuilder().create();
			taskList = myGson.fromJson(irs, new TypeToken<TaskList>() {}.getType()); //LOADING FROM FILE
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//from lab 3
	static void saveTasksInFile(Context context) {
		try {
			FileOutputStream fos = context.openFileOutput(FILENAME, 0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			Gson gson = new Gson(); //same as new Gson.Builder().create();
			gson.toJson(taskList, osw);
			osw.flush();
			osw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//from lab 3
	static void loadArchFromFile(Context context) {
		try {
			FileInputStream fis = context.openFileInput(FILENAME2);
			InputStreamReader irs = new InputStreamReader(fis);
			
			// From www.javacreed.com/simple-gson-example/ 2014-25-09
			Gson myGson = new GsonBuilder().create();
			archList = myGson.fromJson(irs, new TypeToken<TaskList>() {}.getType()); //LOADING FROM FILE
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//from lab 3
	static void saveArchInFile(Context context) {
		try {
			FileOutputStream fos = context.openFileOutput(FILENAME2, 0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			Gson gson = new Gson(); //same as new Gson.Builder().create();
			gson.toJson(archList, osw);
			osw.flush();
			osw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//from lab 3
	static void loadUnarchFromFile(Context context) {
		try {
			FileInputStream fis = context.openFileInput(FILENAME3);
			InputStreamReader irs = new InputStreamReader(fis);
			
			// From www.javacreed.com/simple-gson-example/ 2014-25-09
			Gson myGson = new GsonBuilder().create();
			unarchList = myGson.fromJson(irs, new TypeToken<TaskList>() {}.getType()); //LOADING FROM FILE
						
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//from lab 3
	static void saveUnarchInFile(Context context) {
		try {
			FileOutputStream fos = context.openFileOutput(FILENAME3, 0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			Gson gson = new Gson(); //same as new Gson.Builder().create();
			gson.toJson(unarchList, osw);
			osw.flush();
			osw.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	*/
	
	//I don't think I'm actually using these two methods
	public void addTask(Task task){
		getTaskList().addTask(task);
	}
	
	public void deleteTask(Task task){
		getTaskList().removeTask(task);
	}
}
